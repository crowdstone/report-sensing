package com.sensing.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Api(name = "temperatureAPI", version = "v1")
public class TemperatureEndpoint {

	@ApiMethod(name = "listTemperatureEntity", httpMethod = HttpMethod.GET, path = "temperature")
	public String listTemperatureEntity() {

		return "TEST";
	}
}