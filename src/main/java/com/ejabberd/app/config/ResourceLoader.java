package com.ejabberd.app.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ResourceLoader extends ResourceConfig {


	public ResourceLoader() {
		
        packages("com.rest.api");
	}
}
