package com.vogella.osgi.console;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.service.component.annotations.Component;


@Component
public class AndAndQuitCommand implements CommandProvider {

	public AndAndQuitCommand() {
		System.out.println("command");
	}
    // add prints sum of its two arguments
    public void _add(CommandInterpreter ci) {
        int a = Integer.parseInt(ci.nextArgument());
        int b = Integer.parseInt(ci.nextArgument());
        ci.println(a+b);
    }

    // quit just calls "exit"
    public void _quit(CommandInterpreter ci) {
        ci.execute("exit");
    }

    @Override
    public String getHelp() {
        return "";
    }

}