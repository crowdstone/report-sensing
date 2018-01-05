package com.sensing.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.sensing.entity.TemperatureEntity;

@Api(name = "temperatureAPI", version = "v1")
public class TemperatureEndpoint {

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getTemperatureEntity", httpMethod = HttpMethod.GET, path = "temperature/{id}")
	public TemperatureEntity getTemperatureEntity(@Named("id") Long id) {
		
		return null;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown. It uses HTTP POST method.
	 *
	 * @param TemperatureEntity
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertTemperatureEntity", httpMethod = HttpMethod.POST, path = "temperature")
	public TemperatureEntity insertTemperatureEntity(TemperatureEntity temperatureEntity) {
		
		return temperatureEntity;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown. It uses HTTP PUT method.
	 *
	 * @param TemperatureEntity
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateTemperatureEntity", httpMethod = HttpMethod.PUT, path = "temperature")
	public TemperatureEntity updateTemperatureEntity(TemperatureEntity temperatureEntity) {
		
		return temperatureEntity;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 *
	 * @param id
	 *            the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeTemperatureEntity", httpMethod = HttpMethod.DELETE, path = "temperature/{id}")
	public void removeTemperatureEntity(@Named("id") Long id) {
		
	}
}
