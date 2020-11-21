#!/usr/bin/env python3

import re
import sys

def read_csv_file_as_key_value_pairs(csvFile):
    pairs = {}

    try:
        with open(csvFile, 'r') as file:
            keys = file.readline().rstrip().split(';')
            for k in keys:
                pairs[k] = 0
            values = file.readline().rstrip().split(';')
            i = 0
            while i < len(keys) and i < len(values):
                key = keys[i]
                value = values[i]
                numericValue = toNumber(value)
                if numericValue is not None:
                    pairs[key] += numericValue
                else:
                    pairs[key] = value
                i += 1
    except IOError as error:
        print("IOError occurred while reading %s: %s" % (csvFile, error))

    return pairs

def toNumber(s):
    try:
        result = float(s)
        result = int(s)
    except ValueError:
        result = None
    return result

def addTo(targetPairs, pairs, duplicateKey):
    for k, v in pairs.items():
        if k not in duplicateKeys:
            duplicateKeys[k] = 0

        if k not in targetPairs:
            targetPairs[k] = v
        else:
            numericTargetValue = toNumber(v)
            if numericTargetValue is not None:
                targetPairs[k] += v
            else:
                duplicateKeys[k] = duplicateKeys[k] + 1
                duplicateKeyName = k + str(duplicateKeys[k])
                targetPairs[duplicateKeyName] = v

def write_as_tex_vars(targetFile, pairs):
    with open(targetFile, 'w') as file:
        validEntries = dict((name, value) for name, value in pairs.items() \
            if is_valid_tex_var_name(name))
        for name in sorted(validEntries.keys()):
            value = pairs[name]
            file.write('\def \\brownEval%s{%s}\n' % \
                (toFirstUpper(name).replace('_', ''), str(value)))

VALID_TEX_VAR_NAME_PATTERN = re.compile('[a-zA-Z0-9_]+$')
def is_valid_tex_var_name(s):
    return VALID_TEX_VAR_NAME_PATTERN.match(s)

def toFirstUpper(s):
    if len(s) == 0:
        return s
    elif len(s) == 1:
        return s.upper()

    firstLetter = s[0]
    otherLetters = s[1:]
    return firstLetter.upper() + otherLetters

if __name__ == '__main__':
    if len(sys.argv) <= 2:
        print("Please specify TeX file name for variables and at least one " \
            "input CSV file")
        sys.exit(1)

    resultPairs = {}
    duplicateKeys = {}
    for csvFile in sys.argv[2:]:
        pairs = read_csv_file_as_key_value_pairs(csvFile)
        addTo(resultPairs, pairs, duplicateKeys)

    write_as_tex_vars(sys.argv[1], resultPairs)
