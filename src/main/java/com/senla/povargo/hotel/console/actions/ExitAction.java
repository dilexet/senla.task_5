package com.senla.povargo.hotel.console.actions;

import com.senla.povargo.hotel.tools.Logger;

public class ExitAction implements IAction {

	@Override
	public void execute() {
		Logger.info("Process terminated");
		System.exit(0);
	}
}
