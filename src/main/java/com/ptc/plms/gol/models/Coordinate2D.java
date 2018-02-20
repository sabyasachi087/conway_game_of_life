package com.ptc.plms.gol.models;

/**
 * Represents a two dimensional coordinates with x and y axis
 */
public class Coordinate2D extends Coordinates {

	public Coordinate2D(double x, double y) {
		super(2);
		this.coordinates[0] = x;
		this.coordinates[1] = y;
	}

	@Override
	public Double getAxis(int axis) {
		if (axis > 1 || axis < 0) {
			throw new IllegalArgumentException("Undefined axis");
		}
		return this.coordinates[axis];
	}

	public Double getX() {
		return this.coordinates[0];
	}

	public Double getY() {
		return this.coordinates[1];
	}

}
