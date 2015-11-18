package com.robo.control.validator;

import com.robo.control.domain.GridLayout;

/**
 * This is the validator class that checks if the user input is correct and
 * prints appropriate errors in case of any issues
 * 
 * @author Badri Srinivasan
 *
 */
public class RobotControlValidator {

	/**
	 * Validates the command that helps the Robot to move
	 * 
	 * @param command
	 *            is the command in a particular format, example M1RM4L M - Move
	 *            Forward L - Rotate Left R - Rotate Right Each command is
	 *            followed by a number from 1-100, which indicates the number of
	 *            times to perform the action
	 * @return a boolean value of true if the command is in the correct format a
	 *         boolean value of false if the command is not in the correct
	 *         format
	 */
	public static boolean validateCommand(String command) {
		

		boolean status = true;
		char[] commandarry = command.toCharArray();
		int i, j;
		if(Character.isDigit(commandarry[0])){
			System.out.println("The first character cannot be a number");
			status =false;
			return status;
			
		}
		for (i = 0; i < commandarry.length;) {

			StringBuilder numberstr = new StringBuilder("");
			for (j = i + 1; j < commandarry.length;) {
				while (j < commandarry.length && (!(commandarry[j] == 'M' || commandarry[j] == 'L'
						|| commandarry[j] == 'R')) && (Character.isDigit(commandarry[j]))){
					numberstr.append(commandarry[j]);
					j++;

				} // end of while loop
				break; // break the inner for loop
			} // end of inner for loop
			if (commandarry[i] == 'M' || commandarry[i] == 'L' || commandarry[i] == 'R') {

				if (numberstr.length() != 0) {
					i=j;
					int count = Integer.valueOf(numberstr.toString());
					if (count > GridLayout.getLength() || count <= 0) {
						System.out.println("The number can be only between 1-100");
						status = false;
						return status;
					}
				}else{
					i++;
				}

			} else {
				System.out.println("The characters can be only L,R,M");
				status = false;
				return status;
			}
			

		} // end of main for loop
		return status;
	}

	/**
	 * Returns a boolean value of true if the initial position is the correct
	 * format, returns a boolean value of false if the initial position is not
	 * in the correct format
	 * 
	 * @param initialpos
	 *            The initial position of the Robot , for example N 0 0 The
	 *            first charter can be one of N S W E The second character is
	 *            the x coordinate The third character is the y coordinate All
	 *            the characters are separated by a space
	 * @return true if the initial position is in correct format
	 */
	public static boolean validateInitialPosition(String initialpos) {
		boolean status = true;
		if (null != initialpos && null != initialpos.split(" ") && initialpos.split(" ").length == 3) {
			String[] startpostparam = initialpos.split(" ");
			String direction = startpostparam[0];
			try {
				int xvalue = Integer.valueOf(startpostparam[1]);
				int yvalue = Integer.valueOf(startpostparam[2]);
				if (xvalue < 0 || yvalue < 0) {
					status = false;
					System.out.println("The X and Y coordinates can only be a positive integer");
				}
				// Check this condition
				if (xvalue > GridLayout.getWidth() || yvalue > GridLayout.getLength()) {
					status = false;
					System.out.println("The X and Y coordinates can not be greater than the grid layout");
				}

			} catch (NumberFormatException e) {
				System.out.println("The X and Y coordinates should be a valid number");
				status = false;
			}
			if (null != direction && !(direction.equals("N") || direction.equals("W") || direction.equals("E")
					|| direction.equals("S"))) {
				System.out.println("The direction can be only one of N,S,E,W");
				status = false;
			}

		} else {
			System.out.println("The intial parameter String is not in the correct format");
			status = false;
		}
		return status;

	}

}
