package com.hungry.demo1.config;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromCodecs;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hungry.demo1.dao.RestaurantDAO;
import com.hungry.demo1.model.RestaurantChoice;
import com.hungry.demo1.serializers.CuisineTypeCodec;
import com.hungry.demo1.serializers.FoodTypeCodec;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Configuration
@EnableConfigurationProperties({ CoreProperties.class })
public class ApplicationConfig {
	
	@Bean
	public RestaurantDAO restaurantDao(final MongoClient mongoClient, final CoreProperties coreProperties) {
		try {
			MongoDatabase db = mongoClient.getDatabase(coreProperties.getDatabaseName());
			return new RestaurantDAO(db.getCollection(coreProperties.getCollectionName(), RestaurantChoice.class));
        }
		catch (IllegalArgumentException e) {
			System.err.println("Error creating database instance with given name: " + coreProperties.getDatabaseName());
			return new RestaurantDAO(null);
		}
	}
	
	@Bean
	public MongoClient mongoClient(final CoreProperties coreProperties) {
		final ConnectionString connectionString = new ConnectionString(coreProperties.getMongoDatabaseURI());
		final CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		final CodecRegistry customEnumCodecs = fromCodecs(new CuisineTypeCodec(),new FoodTypeCodec());
		final CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry, customEnumCodecs);
		
		MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
		
		return MongoClients.create(clientSettings);
	}
}