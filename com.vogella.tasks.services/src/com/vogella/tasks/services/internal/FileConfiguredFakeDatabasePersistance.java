package com.vogella.tasks.services.internal;
import java.util.Map;
 
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
 
@Component(
    properties="OSGI-INF/config.properties"
)
public class FileConfiguredFakeDatabasePersistance {
 
    @Activate
    void activate(Map<String, String> properties) {
        String msg = (String) properties.get("message");
        String iter = (String) properties.get("parallelUpdates");
 
        if (msg != null && iter != null) {
            Integer count = Integer.valueOf(iter);
            for (int i = 1; i <= count; i++) {
                System.out.println(i + ": " + msg);
            }
            System.out.println();
        }
    }
}