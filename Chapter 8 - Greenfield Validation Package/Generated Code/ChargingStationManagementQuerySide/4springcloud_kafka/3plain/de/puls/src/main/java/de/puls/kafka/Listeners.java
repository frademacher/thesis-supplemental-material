package de.puls.kafka;

import de.puls.domain.QuerySideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.stereotype.Component;

@Component()
public class Listeners {

    private QuerySideService querySideService;

    @Autowired()
    public void setQuerySideService(QuerySideService querySideService) {
        this.querySideService = querySideService;
    }

    @KafkaListener(topics = "${kafka.topic.parkingAreaCreatedEvents}", groupId = "${kafka.group.parkingAreaCreatedEvents}", containerFactory = "avroParkingAreaCreatedEventsKafkaListenerContainerFactory", errorHandler = "receiveParkingAreaCreatedEventErrorHandler")
    public void avroReceiveParkingAreaCreatedEventListener(Object object) {
        querySideService.avroReceiveParkingAreaCreatedEvent(object);
    }

    @Bean()
    public ConsumerAwareListenerErrorHandler receiveParkingAreaCreatedEventErrorHandler() {
        return (message, exception, consumer) -> querySideService.receiveParkingAreaCreatedEventErrorHandler(message, exception, consumer);
    }

    @KafkaListener(topics = "${kafka.topic.parkingAreaUpdatedEvents}", groupId = "${kafka.group.parkingAreaUpdatedEvents}", containerFactory = "avroParkingAreaUpdatedEventsKafkaListenerContainerFactory", errorHandler = "receiveParkingAreaUpdatedEventErrorHandler")
    public void avroReceiveParkingAreaUpdatedEventListener(Object object) {
        querySideService.avroReceiveParkingAreaUpdatedEvent(object);
    }

    @Bean()
    public ConsumerAwareListenerErrorHandler receiveParkingAreaUpdatedEventErrorHandler() {
        return (message, exception, consumer) -> querySideService.receiveParkingAreaUpdatedEventErrorHandler(message, exception, consumer);
    }

    @KafkaListener(topics = "${kafka.topic.parkingAreaDeletedEvents}", groupId = "${kafka.group.parkingAreaDeletedEvents}", containerFactory = "avroParkingAreaDeletedEventsKafkaListenerContainerFactory", errorHandler = "receiveParkingAreaDeletedEventErrorHandler")
    public void avroReceiveParkingAreaDeletedEventListener(Object object) {
        querySideService.avroReceiveParkingAreaDeletedEvent(object);
    }

    @Bean()
    public ConsumerAwareListenerErrorHandler receiveParkingAreaDeletedEventErrorHandler() {
        return (message, exception, consumer) -> querySideService.receiveParkingAreaDeletedEventErrorHandler(message, exception, consumer);
    }
}
