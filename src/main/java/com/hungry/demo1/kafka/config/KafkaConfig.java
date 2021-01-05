package com.hungry.demo1.kafka.config;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hungry.demo1.kafka.producer.RestaurantChoiceKafkaProducer;

@Configuration
@EnableConfigurationProperties({ KafkaProperties.class })
public class KafkaConfig {

	@Bean
	public RestaurantChoiceKafkaProducer restaurantChoiceKafkaProducer(KafkaProperties kafkaProperties) {
    	Properties propertiesMap = new Properties();
    	propertiesMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
    	propertiesMap.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaProperties.getClientId());
    	propertiesMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaProperties.getKeySerializer());
    	propertiesMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getValueSerializer()); // TODO: create RC serializer
        Producer<Long, String> restaurantChoiceProducer = new KafkaProducer<>(propertiesMap);
		return new RestaurantChoiceKafkaProducer(kafkaProperties.getDestinationTopic(), restaurantChoiceProducer);
	}

}