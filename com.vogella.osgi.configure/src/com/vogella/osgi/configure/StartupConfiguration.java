package com.vogella.osgi.configure;

import org.eclipse.osgi.service.environment.EnvironmentInfo;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class StartupConfiguration {

	@Reference
	EnvironmentInfo environmentInfo;

	@Activate
	void activate() {
		System.out.println("Command line arguments");
		for (String arg : this.environmentInfo.getNonFrameworkArgs()) {
			System.out.println(arg);
		}
	}
}
