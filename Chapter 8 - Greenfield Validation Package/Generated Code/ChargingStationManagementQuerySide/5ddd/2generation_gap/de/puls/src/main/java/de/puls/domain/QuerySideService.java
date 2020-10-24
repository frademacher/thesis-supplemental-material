package de.puls.domain;

import de.puls.domain.gen.QuerySideServiceGenImpl;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends QuerySideServiceGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
@Service()
public class QuerySideService extends QuerySideServiceGenImpl {

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

    public QuerySideService() {
    }
}
