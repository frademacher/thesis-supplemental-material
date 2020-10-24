package de.puls.kafka.gen;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

public abstract class ParkingAreaProducerServiceGenImpl implements ParkingAreaProducerServiceGen {

    protected KafkaTemplate<String, GenericRecord> avroProducer;

    @Autowired()
    @Override
    public void setAvroProducer(KafkaTemplate<String, GenericRecord> avroProducer) {
        this.avroProducer = avroProducer;
    }

    @Value(value = "${kafka.topic.parkingAreaCreatedEvents}")
    protected String parkingAreaCreatedEventsTopic;

    @Override
    public ListenableFuture<SendResult<String, GenericRecord>> sendParkingAreaCreatedEvent(GenericRecord genericRecord) {
        return avroProducer.send(new ProducerRecord<>(parkingAreaCreatedEventsTopic, genericRecord));
    }

    @Value(value = "${kafka.topic.parkingAreaUpdatedEvents}")
    protected String parkingAreaUpdatedEventsTopic;

    @Override
    public ListenableFuture<SendResult<String, GenericRecord>> sendParkingAreaUpdatedEvent(GenericRecord genericRecord) {
        return avroProducer.send(new ProducerRecord<>(parkingAreaUpdatedEventsTopic, genericRecord));
    }

    @Value(value = "${kafka.topic.parkingAreaDeletedEvents}")
    protected String parkingAreaDeletedEventsTopic;

    @Override
    public ListenableFuture<SendResult<String, GenericRecord>> sendParkingAreaDeletedEvent(GenericRecord genericRecord) {
        return avroProducer.send(new ProducerRecord<>(parkingAreaDeletedEventsTopic, genericRecord));
    }
}
