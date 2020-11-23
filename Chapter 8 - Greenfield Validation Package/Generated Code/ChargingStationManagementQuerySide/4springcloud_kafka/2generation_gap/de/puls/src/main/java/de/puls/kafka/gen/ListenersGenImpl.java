package de.puls.kafka.gen;

import de.puls.domain.QuerySideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;

public abstract class ListenersGenImpl implements ListenersGen {

    protected QuerySideService querySideService;

    @Autowired()
    @Override
    public void setQuerySideService(QuerySideService querySideService) {
        this.querySideService = querySideService;
    }

    @KafkaListener(topics = "${kafka.topic.parkingAreaCreatedEvents}", groupId = "${kafka.group.parkingAreaCreatedEvents}", containerFactory = "avroParkingAreaCreatedEventsKafkaListenerContainerFactory", errorHandler = "receiveParkingAreaCreatedEventErrorHandler")
    @Override
    public void avroReceiveParkingAreaCreatedEventListener(Object object) {
        querySideService.avroReceiveParkingAreaCreatedEvent(object);
    }

    @Bean()
    @Override
    public ConsumerAwareListenerErrorHandler receiveParkingAreaCreatedEventErrorHandler() {
        return (message, exception, consumer) -> querySideService.receiveParkingAreaCreatedEventErrorHandler(message, exception, consumer);
    }

    @KafkaListener(topics = "${kafka.topic.parkingAreaUpdatedEvents}", groupId = "${kafka.group.parkingAreaUpdatedEvents}", containerFactory = "avroParkingAreaUpdatedEventsKafkaListenerContainerFactory", errorHandler = "receiveParkingAreaUpdatedEventErrorHandler")
    @Override
    public void avroReceiveParkingAreaUpdatedEventListener(Object object) {
        querySideService.avroReceiveParkingAreaUpdatedEvent(object);
    }

    @Bean()
    @Override
    public ConsumerAwareListenerErrorHandler receiveParkingAreaUpdatedEventErrorHandler() {
        return (message, exception, consumer) -> querySideService.receiveParkingAreaUpdatedEventErrorHandler(message, exception, consumer);
    }

    @KafkaListener(topics = "${kafka.topic.parkingAreaDeletedEvents}", groupId = "${kafka.group.parkingAreaDeletedEvents}", containerFactory = "avroParkingAreaDeletedEventsKafkaListenerContainerFactory", errorHandler = "receiveParkingAreaDeletedEventErrorHandler")
    @Override
    public void avroReceiveParkingAreaDeletedEventListener(Object object) {
        querySideService.avroReceiveParkingAreaDeletedEvent(object);
    }

    @Bean()
    @Override
    public ConsumerAwareListenerErrorHandler receiveParkingAreaDeletedEventErrorHandler() {
        return (message, exception, consumer) -> querySideService.receiveParkingAreaDeletedEventErrorHandler(message, exception, consumer);
    }
}
