package com.vogella.osgi.eventreceiver;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import com.vogella.events.VogellaEventConstants;

@Component(
    property = {
    		EventConstants.EVENT_TOPIC + "=" + VogellaEventConstants.TOPIC_ALL,
    		EventConstants.EVENT_FILTER + "=" + "(!(target=update))"})
public class WildcardEventReceiver implements EventHandler {

	@Override
	public void handleEvent(Event event) {
		System.out.println("Triggered for: "
		        + event.getProperty(VogellaEventConstants.PROPERTY_KEY_TARGET));
	}
	
	
}

