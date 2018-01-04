package com.sensing.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.CollectionResponse;
import com.sensing.entity.TemperatureEntity;

@Api(name = "temperature-api")
public class TemperatureEndpoint {
	
	@ApiMethod(name="listTemperatureEntity", httpMethod="GET", path="temperatures/")
    public CollectionResponse<TemperatureEntity> listTemperatureEntity(){
    	
    	
    	
    	return null;
    }
}