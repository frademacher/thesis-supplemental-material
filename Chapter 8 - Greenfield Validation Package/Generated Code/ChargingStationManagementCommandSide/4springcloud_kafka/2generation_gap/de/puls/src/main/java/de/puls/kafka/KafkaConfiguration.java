package de.puls.kafka;

import de.puls.kafka.gen.KafkaConfigurationGenImpl;
import org.springframework.context.annotation.Configuration;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends KafkaConfigurationGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
@Configuration()
public class KafkaConfiguration extends KafkaConfigurationGenImpl {

    public KafkaConfiguration() {
    }
}
