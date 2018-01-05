package com.sensing.api;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.BadRequestException;
import com.googlecode.objectify.ObjectifyService;
import com.sensing.entity.TemperatureEntity;

@Api(name = "temperatureAPI", version = "v1")
public class TemperatureEndpoint {

	static {
		ObjectifyService.register(TemperatureEntity.class);
	}

	/*
	 * Check if latitude and longitude values are correct
	 */
	private boolean checkCoords(int latInf, int latSup, int longInf, int longSup) {
		boolean checkLat = latInf >= -90 && latInf <= 90 && latSup >= -90 && latInf <= 90;
		boolean checkLong = longInf >= -180 && longInf <= 180 && longSup >= -180 && longSup <= 180;
		return checkLat && checkLong;
	}

	/**
	 * This method gets all entities. It uses HTTP GET method.
	 *
	 * @return The list of entities.
	 */
	@ApiMethod(name = "listTemperatureEntity", httpMethod = HttpMethod.GET, path = "temperature")
	public List<TemperatureEntity> listTemperatureEntity() {
		List<TemperatureEntity> res = ofy().load().type(TemperatureEntity.class).list();

		return res;
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getTemperatureEntity", httpMethod = HttpMethod.GET, path = "temperature/{id}")
	public TemperatureEntity getTemperatureEntity(@Named("id") Long id) {
		TemperatureEntity res = ofy().load().type(TemperatureEntity.class).id(id).now();

		return res;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown. It uses HTTP POST method.
	 *
	 * @param TemperatureEntity
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 * @throws BadRequestException If arguments are not correct
	 */
	@ApiMethod(name = "insertTemperatureEntity", httpMethod = HttpMethod.POST, path = "temperature")
	public TemperatureEntity insertTemperatureEntity(TemperatureEntity temperatureEntity) throws BadRequestException {
		if (!checkCoords(temperatureEntity.getLatInf(), temperatureEntity.getLatSup(), temperatureEntity.getLongInf(),
				temperatureEntity.getLongSup())) {
			throw new BadRequestException("Geographic coordinate must be in existing range (lat : [-90;90], long : [-180;180])");
		}

		temperatureEntity.updateId();
		ofy().save().entity(temperatureEntity).now();

		return temperatureEntity;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown. It uses HTTP PUT method.
	 *
	 * @param TemperatureEntity
	 *            the entity to be updated.
	 * @return The updated entity.
	 * @throws BadRequestException If arguments are not correct
	 */
	@ApiMethod(name = "updateTemperatureEntity", httpMethod = HttpMethod.PUT, path = "temperature")
	public TemperatureEntity updateTemperatureEntity(TemperatureEntity temperatureEntity) throws BadRequestException {
		if (!checkCoords(temperatureEntity.getLatInf(), temperatureEntity.getLatSup(), temperatureEntity.getLongInf(),
				temperatureEntity.getLongSup())) {
			throw new BadRequestException("Geographic coordinate must be in existing range (lat : [-90;90], long : [-180;180])");
		}
		
		temperatureEntity.updateId();
		ofy().save().entity(temperatureEntity).now();

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
		ofy().delete().type(TemperatureEndpoint.class).id(id).now();
	}
}
