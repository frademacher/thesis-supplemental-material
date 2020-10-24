package de.puls.domain;

import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service()
public class QuerySideService {

    public void avroReceiveParkingAreaCreatedEvent(Object object) {
        // TODO: Implement handler
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Object receiveParkingAreaCreatedEventErrorHandler(Message<?> message, ListenerExecutionFailedException listenerExecutionFailedException, Consumer<?, ?> consumer) {
        // TODO: Implement error handler
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void avroReceiveParkingAreaUpdatedEvent(Object object) {
        // TODO: Implement handler
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Object receiveParkingAreaUpdatedEventErrorHandler(Message<?> message, ListenerExecutionFailedException listenerExecutionFailedException, Consumer<?, ?> consumer) {
        // TODO: Implement error handler
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void avroReceiveParkingAreaDeletedEvent(Object object) {
        // TODO: Implement handler
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Object receiveParkingAreaDeletedEventErrorHandler(Message<?> message, ListenerExecutionFailedException listenerExecutionFailedException, Consumer<?, ?> consumer) {
        // TODO: Implement error handler
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
