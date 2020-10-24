package de.puls.kafka.gen;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;

public interface KafkaConfigurationGen {

    KafkaAdmin kafkaAdmin();

    ConsumerFactory<String, Object> avroParkingAreaCreatedEventsConsumerFactory();

    ConcurrentKafkaListenerContainerFactory<String, Object> avroParkingAreaCreatedEventsKafkaListenerContainerFactory();

    ConsumerFactory<String, Object> avroParkingAreaUpdatedEventsConsumerFactory();

    ConcurrentKafkaListenerContainerFactory<String, Object> avroParkingAreaUpdatedEventsKafkaListenerContainerFactory();

    ConsumerFactory<String, Object> avroParkingAreaDeletedEventsConsumerFactory();

    ConcurrentKafkaListenerContainerFactory<String, Object> avroParkingAreaDeletedEventsKafkaListenerContainerFactory();
}
