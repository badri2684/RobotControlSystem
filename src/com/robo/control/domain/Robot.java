package com.robo.control.domain;

import com.robo.control.domain.Position.OREINTATION;

/**
 * This class represents the robot, that actually moves on the grid It has a
 * property called position,which tells the Robot, details about current
 * position and also guides the robot to move in different directions
 * 
 * @author Badri Srinivasan
 *
 */
public class Robot {
	// current position of the robot
	private Position currposition;

	// List of all possible directions
	public enum DIRECTION {
		LEFT, RIGHT, UP, DOWN
	};

	public DIRECTION direction;

	public Robot(Position currposition) {
		this.currposition = currposition;

	}

	/**
	 * Initializes the orientation of the robot based on initial position
	 */
	public void intialiseDircetions() {
		if (currposition.getDirection().equals(OREINTATION.N)) {
			direction = DIRECTION.UP;
		} else if (currposition.getDirection().equals(OREINTATION.E)) {
			direction = DIRECTION.RIGHT;
		} else if (currposition.getDirection().equals(OREINTATION.W)) {
			direction = DIRECTION.LEFT;
		} else {
			direction = DIRECTION.DOWN;
		}

	}

	/**
	 * Returns the current position of the robot
	 * 
	 * @return current position of the robot
	 */
	public Position getCurrposition() {
		return currposition;
	}

	/**
	 * Setter method to set the current position of the robot
	 * 
	 * @param currposition
	 */
	public void setCurrposition(Position currposition) {
		this.currposition = currposition;
	}

	/**
	 * Is used by the robot to move forward
	 * 
	 * @param steps
	 *            is the number of steps to move forward
	 * @return the current position of the robot
	 */
	public Position moveforward(int steps) {
		int xcord = currposition.getXcoordinate();
		int ycord = currposition.getYcoordinate();
		if (direction.equals(DIRECTION.LEFT)) {
			int temp = xcord - steps;
			if (temp < 0) {
				// Need to calculate X coordinate
				currposition.setXcoordinate(GridLayout.getWidth() + temp + 1);
			} else {
				currposition.setXcoordinate(temp);
			}
		} else if (direction.equals(DIRECTION.RIGHT)) {
			int temp = xcord + steps;
			if (temp > GridLayout.getWidth()) {
				// Need to calculate X coordinate
				int diff = temp - GridLayout.getWidth();
				currposition.setXcoordinate(diff - 1);
			} else {
				currposition.setXcoordinate(temp);
			}

		} else if (direction.equals(DIRECTION.UP)) {
			int temp = ycord + steps;
			if (temp > GridLayout.getLength()) {
				// Need to calculate Y coordinate
				int diff = temp - GridLayout.getLength();
				currposition.setYcoordinate(diff - 1);
			} else {
				currposition.setYcoordinate(temp);
			}

		} else {
			int temp = ycord - steps;
			if (temp < 0) {
				// Need to calculate X coordinate
				currposition.setYcoordinate(GridLayout.getLength() + temp + 1);
			} else {
				currposition.setYcoordinate(temp);
			}

		}
		return currposition;
	}

	/**
	 * Is used by the robot to move left by number of times
	 * 
	 * @param times
	 *            is the number of times the operation needs to be repeated
	 * @return
	 */

	public Position rotateLeft(int times) {
		int mod = times % 4;
		if (direction.equals(DIRECTION.LEFT)) {
			if (mod == 0) {
				direction = DIRECTION.LEFT;
			} else if (mod == 1) {
				direction = DIRECTION.DOWN;
			} else if (mod == 2) {
				direction = DIRECTION.RIGHT;
			} else if (mod == 3) {
				direction = DIRECTION.UP;
			}

		} else if (direction.equals(DIRECTION.RIGHT)) {

			if (mod == 0) {
				direction = DIRECTION.RIGHT;

			} else if (mod == 1) {
				direction = DIRECTION.UP;
			} else if (mod == 2) {
				direction = DIRECTION.LEFT;
			} else if (mod == 3) {
				direction = DIRECTION.DOWN;
			}
		} else if (direction.equals(DIRECTION.UP)) {

			if (mod == 0) {
				direction = DIRECTION.UP;
			} else if (mod == 1) {
				direction = DIRECTION.LEFT;
			} else if (mod == 2) {
				direction = DIRECTION.DOWN;
			} else if (mod == 3) {
				direction = DIRECTION.RIGHT;
			}
		} else {
			if (mod == 0) {
				direction = DIRECTION.DOWN;
			} else if (mod == 1) {
				direction = DIRECTION.RIGHT;
			} else if (mod == 2) {
				direction = DIRECTION.UP;
			} else if (mod == 3) {
				direction = DIRECTION.LEFT;
			}

		}
		if (direction.equals(DIRECTION.UP)) {
			currposition.setDirection(OREINTATION.N);
		} else if (direction.equals(DIRECTION.DOWN)) {
			currposition.setDirection(OREINTATION.S);
		} else if (direction.equals(DIRECTION.RIGHT)) {
			currposition.setDirection(OREINTATION.E);
		} else {
			currposition.setDirection(OREINTATION.W);
		}

		return currposition;
	}

	/**
	 * Is used by the robot to move right by number of times
	 * 
	 * @param times
	 *            is the number of times the operation needs to be repeated
	 * @return
	 */
	public Position rotateRight(int times) {
		int mod = times % 4;
		if (direction.equals(DIRECTION.LEFT)) {
			if (mod == 0) {
				direction = DIRECTION.LEFT;
			} else if (mod == 1) {
				direction = DIRECTION.UP;
			} else if (mod == 2) {
				direction = DIRECTION.RIGHT;
			} else if (mod == 3) {
				direction = DIRECTION.DOWN;
			}

		} else if (direction.equals(DIRECTION.RIGHT)) {

			if (mod == 0) {
				direction = DIRECTION.RIGHT;
			} else if (mod == 1) {
				direction = DIRECTION.DOWN;
			} else if (mod == 2) {
				direction = DIRECTION.LEFT;
			} else if (mod == 3) {
				direction = DIRECTION.UP;
			}
		} else if (direction.equals(DIRECTION.UP)) {

			if (mod == 0) {
				direction = DIRECTION.UP;
			} else if (mod == 1) {
				direction = DIRECTION.RIGHT;
			} else if (mod == 2) {
				direction = DIRECTION.DOWN;
			} else if (mod == 3) {
				direction = DIRECTION.LEFT;
			}
		} else {
			if (mod == 0) {
				direction = DIRECTION.DOWN;
			} else if (mod == 1) {
				direction = DIRECTION.LEFT;
			} else if (mod == 2) {
				direction = DIRECTION.UP;
			} else if (mod == 3) {
				direction = DIRECTION.RIGHT;
			}
		}
		if (direction.equals(DIRECTION.UP)) {
			currposition.setDirection(OREINTATION.N);
		} else if (direction.equals(DIRECTION.DOWN)) {
			currposition.setDirection(OREINTATION.S);
		} else if (direction.equals(DIRECTION.RIGHT)) {
			currposition.setDirection(OREINTATION.E);
		} else {
			currposition.setDirection(OREINTATION.W);
		}

		return currposition;
	}
}