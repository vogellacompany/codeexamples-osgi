package com.vogella.osgi.console;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import com.vogella.events.VogellaEventConstants;


@Component
public class EventCommandSender implements CommandProvider {

	@Reference
    EventAdmin eventAdmin;
	
    public void _sendEvent(CommandInterpreter ci) {
    	String command = ci.nextArgument();

        // create the event properties object
        Map<String, Object> properties = new HashMap<>();
        properties.put(VogellaEventConstants.PROPERTY_KEY_TARGET, command);
        Event event = null;
 
        switch (command) {
            case "help":
                event = new Event(VogellaEventConstants.TOPIC_HELP, properties);
                break;
            case "update":
                event = new Event(VogellaEventConstants.TOPIC_UPDATE, properties);
                break;
            case "":
                event = new Event(VogellaEventConstants.TOPIC_SWITCH, properties);
                break;
            default:
                System.out.println("Such a command is not known!");
        }
 
        if (event != null) {
            eventAdmin.postEvent(event);
        }
    }

	@Override
	public String getHelp() {
		return "Allows to tigger events via the command line, options: help, update, switch ";
	}
}