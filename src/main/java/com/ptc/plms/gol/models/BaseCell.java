package com.ptc.plms.gol.models;

public abstract class BaseCell<T extends Coordinates> implements Cloneable {

	protected T cord;

	protected BaseCell(T cord) {
		this.cord = cord;
	}

	public abstract T getCoordinates();

	// Must override cloning functionality
	/** Create a deep copy of the object */
	public abstract BaseCell<T> clone();

}
