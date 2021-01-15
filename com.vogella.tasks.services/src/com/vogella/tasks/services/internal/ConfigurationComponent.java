	package com.vogella.tasks.services.internal;

import java.io.IOException;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class ConfigurationComponent {

	public ConfigurationComponent() {
		System.out.println("Constructor");
	}
	private ConfigurationAdmin cm;

	@Reference
    void setConfigurationAdmin(ConfigurationAdmin cm) {
		this.cm = cm;
		configure();
    }
 
    private void configure() {
        Configuration config;
		try {
			config = cm.getConfiguration("AdminConfiguredComponent");
	        Hashtable<String, Object> props = new Hashtable<>();
	        props.put("message", "This is the configuration");
	        props.put("parallelUpdates", 3);
	        config.update(props);

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
