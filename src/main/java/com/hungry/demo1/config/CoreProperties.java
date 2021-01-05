package com.hungry.demo1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Necessary properties to run the application.
 * 
 * @author dalyan
 * @date 11/23/2020
 */
@ConfigurationProperties(prefix = "core")
@Validated
public class CoreProperties {
	
	@NotEmpty(message = "A database name is required")
	private String databaseName;
	
	@NotEmpty(message = "A collection name is required")
	private String collectionName;
	
	@NotEmpty(message = "A mongoDB URI is required")
	private String mongoDatabaseURI;

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getMongoDatabaseURI() {
		return mongoDatabaseURI;
	}

	public void setMongoDatabaseURI(String mongoDatabaseURI) {
		this.mongoDatabaseURI = mongoDatabaseURI;
	}
}