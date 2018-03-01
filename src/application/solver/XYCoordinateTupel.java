/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 */

package application.solver;

public class XYCoordinateTupel {

	private int xCoordinate, yCoordinate;

	public XYCoordinateTupel() {
		xCoordinate = 0;
		yCoordinate = 0;

	}

	public XYCoordinateTupel(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	@Override
	public String toString() {
		return xCoordinate + "|" + yCoordinate;
	}
}
