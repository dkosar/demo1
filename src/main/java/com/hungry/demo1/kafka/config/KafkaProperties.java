package com.hungry.demo1.kafka.config;

import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "kafka")
@Validated
public class KafkaProperties {
	
	@NotEmpty(message = "Destination topic is required")
	private String destinationTopic;
	
	@NotEmpty(message = "Must specify Kafka broker server location")
	private String bootstrapServers;
	
	@NotEmpty(message = "Must specify a client ID value")
	private String clientId;
	
	@NotEmpty(message = "Please specify a key serializer")
	private String keySerializer;
	
	@NotEmpty(message = "Please specify a value serializer")
	private String valueSerializer;

	public String getDestinationTopic() {
		return destinationTopic;
	}

	public void setDestinationTopic(String destinationTopic) {
		this.destinationTopic = destinationTopic;
	}

	public String getBootstrapServers() {
		return bootstrapServers;
	}

	public void setBootstrapServers(String bootstrapServers) {
		this.bootstrapServers = bootstrapServers;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getKeySerializer() {
		return keySerializer;
	}

	public void setKeySerializer(String keySerializer) {
		this.keySerializer = keySerializer;
	}

	public String getValueSerializer() {
		return valueSerializer;
	}

	public void setValueSerializer(String valueSerializer) {
		this.valueSerializer = valueSerializer;
	}

}
