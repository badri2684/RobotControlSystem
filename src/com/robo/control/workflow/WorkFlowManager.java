package com.robo.control.workflow;

import java.util.Scanner;

import com.robo.control.controller.RobotController;
import com.robo.control.domain.GridLayout;
import com.robo.control.domain.Position;
import com.robo.control.validator.RobotControlValidator;

/**
 * This class ties all the pieces together, the controller,validator It also
 * exposes a single method to be called from the client
 * 
 * @author Badri Srinivasan
 *
 */
public class WorkFlowManager {
	RobotController controller;

	public WorkFlowManager() {
		// System.out.println("Default Constructor");
	}

	/**
	 * Is the method, that is invoked by the client class It takes the input
	 * from the client Brings the different components of the application
	 * together like the controller and the validator
	 */
	public void start() {

		System.out.println("*******Robort Control Simulation Program*******");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the robots intial position::");
		String position = sc.nextLine();
		if (RobotControlValidator.validateInitialPosition(position)) {
			String[] startpostparam = position.split(" ");
			String direction = startpostparam[0];
			int xcoordinate = Integer.valueOf(startpostparam[1]);
			int ycoordinate = Integer.valueOf(startpostparam[2]);
			// Initializing the parameters required for setup
			intialiseParameters(direction, xcoordinate, ycoordinate);
			System.out.println("Enter the instruction::");
			String command = sc.nextLine();
			if (RobotControlValidator.validateCommand(command)) {
				Position finalpos = controller.executeRobotCommands(command);
				System.out.println("Final Position:::" + finalpos);
			}
			// Closing the scanner object
			sc.close();

		}

	}

	/**
	 * Initializes/Prepares the Robot to take instructions
	 * 
	 * @param direction
	 *            is the initial direction one of [N,S,W,E]
	 * @param xcoordinate
	 *            is the value of the x coordinate
	 * @param ycoordinate
	 *            is the value of the y coordinate
	 */

	private void intialiseParameters(String direction, int xcoordinate, int ycoordinate) {

		// Initializing the grid layout to (100 * 100)
		GridLayout.setGridLayout(100, 100);
		controller = new RobotController();
		controller.initializeRobot(direction, xcoordinate, ycoordinate);
	}

}
