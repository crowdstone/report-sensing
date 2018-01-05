package com.sensing.api;

import javax.jdo.PersistenceManager;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

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
		PersistenceManager mgr = getPersistenceManager();
		TemperatureEntity TemperatureEntity = null;
		try {
			TemperatureEntity = mgr.getObjectById(TemperatureEntity.class, id);
		} finally {
			mgr.close();
		}
		return TemperatureEntity;
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
	public TemperatureEntity insertTemperatureEntity(TemperatureEntity TemperatureEntity) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsTemperatureEntity(TemperatureEntity)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(TemperatureEntity);
		} finally {
			mgr.close();
		}
		return TemperatureEntity;
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
	public TemperatureEntity updateTemperatureEntity(TemperatureEntity TemperatureEntity) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsTemperatureEntity(TemperatureEntity)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(TemperatureEntity);
		} finally {
			mgr.close();
		}
		return TemperatureEntity;
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
		PersistenceManager mgr = getPersistenceManager();
		try {
			TemperatureEntity TemperatureEntity = mgr.getObjectById(TemperatureEntity.class, id);
			mgr.deletePersistent(TemperatureEntity);
		} finally {
			mgr.close();
		}
	}

	private boolean containsTemperatureEntity(TemperatureEntity TemperatureEntity) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(TemperatureEntity.class, TemperatureEntity.getId());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}