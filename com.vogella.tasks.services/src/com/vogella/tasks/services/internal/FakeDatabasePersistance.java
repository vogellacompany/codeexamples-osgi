package com.vogella.tasks.services.internal;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

// Example for configuration
@Component(
		property = {
				"message=This is a demo of an inline configured service", 
				"parallelUpdates:Integer=3" })
public class FakeDatabasePersistance {

    @Activate
    void activate(Map<String, Object> properties) {
        String msg = (String) properties.get("message");
        Integer iter = (Integer) properties.get("parallelUpdates");
 
        for (int i = 1; i <= iter; i++) {
            System.out.println(i + ": " + msg);
        }
        System.out.println();
    }
}