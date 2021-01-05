package com.hungry.demo1.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

public class RestaurantChoiceKafkaProducer {

	private String destinationTopic;
	private Producer<Long, String> restaurantChoiceProducer;
    
    public RestaurantChoiceKafkaProducer(String destinationTopic, Producer<Long, String> restaurantChoiceProducer) {
    	this.destinationTopic = destinationTopic;
    	this.restaurantChoiceProducer = restaurantChoiceProducer;
    	runProducer(10);
    }
    
    void runProducer(final int sendMessageCount) {
        long time = System.currentTimeMillis();

        try {
            for (long index = time; index < time + sendMessageCount; index++) {
                final ProducerRecord<Long, String> record = new ProducerRecord<>(destinationTopic, index, "Hello Mom " + index);
                final CountDownLatch countDownLatch = new CountDownLatch(sendMessageCount);

                RecordMetadata metadata = restaurantChoiceProducer.send(record).get();

                long elapsedTime = System.currentTimeMillis() - time;
                System.out.printf("sent record(key=%s value=%s) " + "meta(partition=%d, offset=%d) time=%d\n",
                        record.key(), record.value(), metadata.partition(), metadata.offset(), elapsedTime);
            }
        } catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			restaurantChoiceProducer.flush();
			restaurantChoiceProducer.close();
        }
    }
}
