#!/usr/bin/env python3

import csv
import math
import os
import sys

SERVICES = [
    'ChargingStationManagementCommandSide',
    'ChargingStationManagementQuerySide'
]

PATTERN_COMPARISON_BASE_GENLET = '5ddd'
PATTERN_ORDER = ['3plain', '1extended_generation_gap', '2generation_gap']

DOMAIN_COMPARISON_BASE_GENLET = '5ddd'
DOMAIN_COMPARISON_BASE_PATTERN = '3plain'

GENLET_COMPARISON_BASE_PATTERN = '3plain'

RATIO_COMPARISON_BASE_GENLET = '5ddd'
RATIO_COMPARISON_BASE_PATTERN = '3plain'

TEX_VARS={}
DELAYED_PRINTING_TEX_VARS=set()

def tex_var(service, step, language, key, value, genlet='', pattern='',
    keySuffix='', delayPrinting=False):
    varKeyComponents = [
        'greenEval',
        first_upper(service),
        first_upper(step),
        first_upper(tex_var_language(language)),
        first_upper(tex_var_pattern(genlet)),
        first_upper(tex_var_pattern(pattern)),
        first_upper(key),
        first_upper(keySuffix)
    ]
    varKey = ''.join(varKeyComponents)
    TEX_VARS[varKey] = value

    if printVariables:
        if not delayPrinting:
            print_var(varKey)
        else:
            DELAYED_PRINTING_TEX_VARS.add(varKey)
    else:
        print()

def print_var(varKey, varValue=None):
    print_cyan('\t(%s = %s)' % \
        (varKey, varValue if varValue else TEX_VARS[varKey]))

def print_delayed_vars():
    for v in DELAYED_PRINTING_TEX_VARS:
        print_var(v)

def tex_var_language(language):
    if not language:
        return ''

    parts = language.split('_')
    varGenlet = ''.join(map(lambda p: first_upper(p), parts))
    return first_lower(varGenlet)

def tex_var_pattern(pattern):
    if not pattern:
        return ''

    parts = pattern[1:].split('_')
    varPattern = ''.join(map(lambda p: first_upper(p), parts))
    return first_lower(varPattern)

def tex_var_genlet(genlet):
    if not genlet:
        return ''

    parts = genlet[1:].split('_')
    varGenlet = ''.join(map(lambda p: first_upper(p), parts))
    return first_lower(varGenlet)

def first_upper(s):
    if not s:
        return s
    return s[0].upper() + s[1:]

def first_lower(s):
    if not s:
        return s
    return s[0].lower() + s[1:]

def compare_generation_patterns(service):
    stepName = 'patternCompare'

    patternBasePath = '../Generated Code/%s/%s' % \
        (service, PATTERN_COMPARISON_BASE_GENLET)
    patternFolders = [
        (f.name, f.path) for f in os.scandir(patternBasePath) if f.is_dir()
    ]

    patterns = []
    locsPerLanguageAndPattern = {}
    for (pattern, folder) in patternFolders:
        patterns.append(pattern)

        csvFilePath = '%s/loc_analysis.csv' % folder
        clocCsv = parse_cloc_csv(csvFilePath)
        for language, locInfos in clocCsv.items():
            if not locInfos['isGen']:
                continue

            if not language in locsPerLanguageAndPattern:
                locsPerLanguageAndPattern[language] = {}

            locsPerLanguageAndPattern[language][pattern] = {
                'nFiles': locInfos['nFiles'],
                'loc': locInfos['loc']
            }

    patterns = sorted(patterns, key=PATTERN_ORDER.index)
    maxNFiles = 0
    maxLoc = 0
    for language in locsPerLanguageAndPattern:
        print_red(language)
        for pattern in patterns:
            locInfos = locsPerLanguageAndPattern[language][pattern]
            print_yellow('\t' + printable_pattern(pattern))
            nFiles = locInfos['nFiles']
            maxNFiles = max(maxNFiles, int(nFiles))
            print('\t\tnFiles: ' + locInfos['nFiles'], end='')
            tex_var(
                service,
                stepName,
                language,
                'nFiles',
                nFiles,
                pattern=pattern
            )
            loc = locInfos['loc']
            maxLoc = max(maxLoc, int(loc))
            print('\t\tLOC: %s' % loc, end='')
            tex_var(
                service,
                stepName,
                language,
                'loc',
                loc,
                pattern=pattern
            )

    tex_var(
        service,
        stepName,
        '',
        'ceilNFiles',
        roundup(maxNFiles),
        delayPrinting=True
    )
    tex_var(
        service,
        stepName,
        '',
        'ceilLoc',
        roundup(maxLoc),
        delayPrinting=True
    )

def roundup(x, base=100.0):
    return int(math.ceil(x / base)) * int(base)

def rounddown(x, base=100.0):
    return int(math.floor(x / base)) * int(base)

def print_red(string):
    print_color(91, string)

def print_red_bg(string):
    print_color(41, string)

def print_yellow(string):
    print_color(93, string)

def print_magenta(string):
    print_color(95, string)

def print_blue(string):
    print_color(34, string)

def print_cyan(string, lineEnd='\n'):
    print_color(96, string)

def print_color(color, string, lineEnd='\n'):
    print('\033[%sm%s\033[0m' % (str(color), string), end=lineEnd)

def printable_pattern(pattern):
    return pattern[1:].replace('_', ' ')

def parse_cloc_csv(filePath):
    parseResults = {}

    with open(filePath, newline='') as csvfile:
        reader = csv.reader(csvfile, delimiter=';', quotechar='|')
        for row in reader:
            language = row[0]
            parseResults[language] = {
                'nFiles': row[1],
                'loc': row[2],
                'isGen': row[3] == 'gen',
                'isDomain': row[4] == 'domain',
            }

    return parseResults

def compare_domain(service):
    stepName = 'domainCompare'

    basePath = '../Generated Code/%s/%s/%s' % \
        (service, DOMAIN_COMPARISON_BASE_GENLET, DOMAIN_COMPARISON_BASE_PATTERN)

    domainCsvFilePath = '%s/loc_analysis_domain_only.csv' % basePath
    domainCsv = parse_cloc_csv(domainCsvFilePath)
    domainLanguages = get_gen_languages(domainCsv)

    completeCsvFilePath = '%s/loc_analysis.csv' % basePath
    completeCsv = parse_cloc_csv(completeCsvFilePath)
    completeLanguages = get_gen_languages(completeCsv)

    overlappingLanguages = completeLanguages #.intersection(domainLanguages)

    completeNFilesOverAllLanguages = 0
    completeLocOverAllLanguages = 0
    domainNFilesOverAllLanguages = 0
    domainLocOverAllLanguages = 0
    serviceNFilesOverAllLanguages = 0
    serviceLocOverAllLanguages = 0
    for language in overlappingLanguages:
        if language in domainCsv:
            domainLocInfos = domainCsv[language]
        else:
            domainLocInfos = {
                'nFiles': '0',
                'loc': '0'
            }
        completeLocInfos = completeCsv[language]
        print_red(language)

        print_yellow('\tComplete')
        print('\t\tnFiles: ' + completeLocInfos['nFiles'], end='')
        tex_var(
            service,
            stepName,
            language,
            'nFiles',
            completeLocInfos['nFiles'],
            keySuffix='complete'
        )
        completeNFilesOverAllLanguages += int(completeLocInfos['nFiles'])

        print('\t\tLOC: ' + completeLocInfos['loc'], end='')
        tex_var(
            service,
            stepName,
            language,
            'loc',
            completeLocInfos['loc'],
            keySuffix='complete'
        )
        completeLocOverAllLanguages += int(completeLocInfos['loc'])

        print_yellow('\tDomain')
        print('\t\tnFiles: ' + domainLocInfos['nFiles'], end='')
        tex_var(
            service,
            stepName,
            language,
            'nFiles',
            domainLocInfos['nFiles'],
            keySuffix='domain'
        )
        domainNFilesOverAllLanguages += int(domainLocInfos['nFiles'])

        print('\t\tLOC: ' + domainLocInfos['loc'], end='')
        tex_var(
            service,
            stepName,
            language,
            'loc',
            domainLocInfos['loc'],
            keySuffix='domain'
        )
        domainLocOverAllLanguages += int(domainLocInfos['loc'])

        print_yellow('\tService')
        serviceNFiles = int(completeLocInfos['nFiles']) - \
            int(domainLocInfos['nFiles'])
        print('\t\tnFiles: %d' % serviceNFiles, end='')
        tex_var(
            service,
            stepName,
            language,
            'nFiles',
            serviceNFiles,
            keySuffix='service'
        )
        serviceNFilesOverAllLanguages += serviceNFiles

        serviceLoc = int(completeLocInfos['loc']) - int(domainLocInfos['loc'])
        print('\t\tLOC: %d' % serviceLoc, end='')
        tex_var(
            service,
            stepName,
            language,
            'loc',
            serviceLoc,
            keySuffix='service'
        )
        serviceLocOverAllLanguages += serviceLoc

    print_red('Over all languages')

    print_yellow('\tComplete')
    print('\t\tnFiles: %d' % completeNFilesOverAllLanguages, end='')
    tex_var(
        service,
        stepName,
        '',
        'completeNFiles',
        completeNFilesOverAllLanguages
    )
    print('\t\tLOC: %d' % completeLocOverAllLanguages, end='')
    tex_var(
        service,
        stepName,
        '',
        'completeLoc',
        completeLocOverAllLanguages
    )

    print_yellow('\tDomain')
    print('\t\tnFiles: %d' % domainNFilesOverAllLanguages, end='')
    tex_var(
        service,
        stepName,
        '',
        'domainNFiles',
        domainNFilesOverAllLanguages
    )
    print('\t\tLOC: %d' % domainLocOverAllLanguages, end='')
    tex_var(
        service,
        stepName,
        '',
        'domainLoc',
        domainLocOverAllLanguages
    )

    print_yellow('\tService')
    serviceNFilesOverAllLanguages = completeNFilesOverAllLanguages - \
        domainNFilesOverAllLanguages
    print('\t\tnFiles: %d' % serviceNFilesOverAllLanguages, end='')
    tex_var(
        service,
        stepName,
        '',
        'serviceNFiles',
        serviceNFilesOverAllLanguages
    )
    serviceLocOverAllLanguages = completeLocOverAllLanguages - \
        domainLocOverAllLanguages
    print('\t\tLOC: %d' % serviceLocOverAllLanguages, end='')
    tex_var(
        service,
        stepName,
        '',
        'serviceLoc',
        serviceLocOverAllLanguages
    )

def get_gen_languages(parsedCsv):
    languages = set()
    for language, locInfos in parsedCsv.items():
        if locInfos['isGen']:
            languages.add(language)
    return languages

def get_man_languages(parsedCsv):
    languagesWithDomainInfo = {}
    for language, locInfos in parsedCsv.items():
        if not locInfos['isGen']:
            languagesWithDomainInfo[language] = locInfos['isDomain']
    return languagesWithDomainInfo

def compare_genlets(service):
    stepName = 'genletCompare'

    genletBasePath = '../Generated Code/' + service
    genletFolders = [
        (f.name, f.path) for f in os.scandir(genletBasePath) if f.is_dir()
    ]

    genlets = []
    locsPerLanguageAndGenlet = {}
    for (genlet, folder) in genletFolders:
        genlets.append(genlet)

        csvFilePath = '%s/%s/loc_analysis.csv' % \
            (folder, GENLET_COMPARISON_BASE_PATTERN)
        clocCsv = parse_cloc_csv(csvFilePath)
        for language, locInfos in clocCsv.items():
            if not locInfos['isGen']:
                continue

            if not language in locsPerLanguageAndGenlet:
                locsPerLanguageAndGenlet[language] = {}

            locsPerLanguageAndGenlet[language][genlet] = {
                'nFiles': locInfos['nFiles'],
                'loc': locInfos['loc']
            }

    for language in locsPerLanguageAndGenlet:
        maxNFiles = 0
        maxLoc = 0
        minNFiles = None
        minLoc = None

        print_red(language)
        for genlet in sorted(genlets):
            if genlet not in locsPerLanguageAndGenlet[language]:
                continue

            locInfos = locsPerLanguageAndGenlet[language][genlet]
            print_yellow('\t' + printable_genlet(genlet))
            nFiles = locInfos['nFiles']
            maxNFiles = max(int(nFiles), maxNFiles)

            if not minNFiles:
                minNFiles = int(nFiles)
            else:
                minNFiles = min(int(nFiles), minNFiles)

            print('\t\tnFiles: ' + nFiles, end='')
            tex_var(
                service,
                stepName,
                language,
                'nFiles',
                nFiles,
                genlet
            )

            loc = locInfos['loc']
            maxLoc = max(int(loc), maxLoc)

            if not minLoc:
                minLoc = int(loc)
            else:
                minLoc = min(int(loc), minLoc)

            print('\t\tLOC: %s' % locInfos['loc'], end='')
            tex_var(
                service,
                stepName,
                language,
                'loc',
                loc,
                genlet
            )

        tex_var(
            service,
            stepName,
            language,
            'floorNFiles',
            rounddown(minNFiles, 10.0),
            delayPrinting=True
        )

        tex_var(
            service,
            stepName,
            language,
            'floorLoc',
            rounddown(minLoc),
            delayPrinting=True
        )

        tex_var(
            service,
            stepName,
            language,
            'ceilNFiles',
            roundup(maxNFiles, 10.0),
            delayPrinting=True
        )

        tex_var(
            service,
            stepName,
            language,
            'ceilLoc',
            roundup(maxLoc),
            delayPrinting=True
        )

def printable_genlet(genlet):
    return genlet[1:].replace('_', ' ')

def compare_ratio(service):
    stepName = 'ratioCompare'

    basePath = '../Generated Code/%s/%s/%s' % \
        (service, RATIO_COMPARISON_BASE_GENLET, RATIO_COMPARISON_BASE_PATTERN)

    compare_ratio_delegate(service, stepName, basePath, 'loc_analysis.csv')
    compare_ratio_delegate(service, stepName, basePath,
        'loc_analysis_domain_only.csv', True)

def compare_ratio_delegate(service, stepName, basePath, csvFile,
    domainOnly=False):
    csvFilePath = basePath + '/' + csvFile
    csv = parse_cloc_csv(csvFilePath)
    if domainOnly:
        csv = {k: v for k, v in filter(lambda i: i[1]['isDomain'], csv.items())}

    genLanguages = get_gen_languages(csv)
    manLanguages = list(map(
        lambda l: l[0],
        # LOC of language "LEMMA" also include LOC of language "LEMMA_domain".
        # Filter out "LEMMA_domain", if the ratio for the complete LOC shall be
        # calculated based on "loc_analysis.csv" (instead of
        # "loc_analysis_domain_only.csv").
        filter(lambda l: l[1] == domainOnly, get_man_languages(csv).items())
    ))

    genLoc = {k: v for k, v in filter(
        lambda i: i[1]['isGen'] and i[0] in genLanguages,
        csv.items()
    )}
    manLoc = {k: v for k, v in filter(
        lambda i: not i[1]['isGen'] and i[0] in manLanguages,
        csv.items()
    )}

    if not domainOnly:
        print_red('Complete')
    else:
        print_red('Domain')
    print_and_var_ratio_info(service, stepName, manLoc, domainOnly, True)
    print_and_var_ratio_info(service, stepName, genLoc, domainOnly)

def print_and_var_ratio_info(service, stepName, languageAndLocInfos, domainOnly,
    isMan=False):
    generationKind = 'manual' if isMan else 'generated'
    print_yellow('\t%s' % generationKind.title())

    sumNFiles = 0
    sumLoc = 0
    domainSuffix = 'DomainOnly' if domainOnly else ''
    for language, locInfos in languageAndLocInfos.items():
        print_blue('\t\t' + language)

        print('\t\t\tnFiles: ' + locInfos['nFiles'], end='')
        sumNFiles += int(locInfos['nFiles'])
        tex_var(
            service,
            stepName,
            language,
            'nFiles',
            locInfos['nFiles'],
            keySuffix=generationKind + domainSuffix
        )

        print('\t\t\tLOC: ' + locInfos['loc'], end='')
        sumLoc += int(locInfos['loc'])
        tex_var(
            service,
            stepName,
            language,
            'loc',
            locInfos['loc'],
            keySuffix=generationKind + domainSuffix
        )

    print_blue('\t\tSUMS')

    print('\t\t\tnFiles: %d' % sumNFiles, end='')
    tex_var(
        service,
        stepName,
        '',
        'nFiles',
        sumNFiles,
        keySuffix=generationKind + domainSuffix + 'Sum'
    )

    print('\t\t\tnLOC: %d' % sumLoc, end='')
    tex_var(
        service,
        stepName,
        '',
        'loc',
        sumLoc,
        keySuffix=generationKind + domainSuffix + 'Sum'
    )

def store_variables(filepath):
    #with open(filepath, 'a') as file:
    with open(filepath, 'w') as file:
        file.write('\n')
        for name in sorted(TEX_VARS.keys()):
            value = TEX_VARS[name]
            file.write('\def \%s{%s}\n' % (name, str(value)))

printVariables = False
if __name__ == '__main__':
    storeVariables=len(sys.argv) > 1
    if storeVariables:
        printVariables = True

    for service in SERVICES:
        print_magenta('-' * 100)
        print_magenta('Pattern comparison for microservice %s ' \
            '(base Genlet: %s)' % (service, PATTERN_COMPARISON_BASE_GENLET))
        print_magenta('-' * 100)
        compare_generation_patterns(service)
        print()

    print()
    print_red_bg(' ' * 200)
    print()

    for service in SERVICES:
        print_magenta('-' * 100)
        print_magenta('Comparison of domain- and service-related code for ' \
            'microservice %s (base Genlet: %s, base pattern: %s)' % \
            (service, DOMAIN_COMPARISON_BASE_GENLET,
             DOMAIN_COMPARISON_BASE_PATTERN)
        )
        print_magenta('-' * 100)
        compare_domain(service)
        print()

    print()
    print_red_bg(' ' * 200)
    print()

    for service in SERVICES:
        print_magenta('-' * 100)
        print_magenta('Genlet comparison for microservice %s ' \
            '(base pattern: %s)' % (service, GENLET_COMPARISON_BASE_PATTERN))
        print_magenta('-' * 100)
        compare_genlets(service)
        print()

    print()
    print_red_bg(' ' * 200)
    print()

    for service in SERVICES:
        print_magenta('-' * 100)
        print_magenta('Ratio comparison for microservice %s (base Genlet: ' \
            '%s, base pattern: %s)' % (service, RATIO_COMPARISON_BASE_GENLET,
             RATIO_COMPARISON_BASE_PATTERN))
        print_magenta('-' * 100)
        compare_ratio(service)
        print()

    if printVariables:
        print_magenta('-' * 100)
        print_magenta('Delayed Variables')
        print_magenta('-' * 100)
        print_delayed_vars()

    if storeVariables:
        store_variables(sys.argv[1])