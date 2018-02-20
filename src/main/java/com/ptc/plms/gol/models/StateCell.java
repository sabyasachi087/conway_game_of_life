package com.ptc.plms.gol.models;

import com.ptc.plms.gol.models.State;

public class StateCell extends BaseCell<Coordinate2D> {

	private State state;

	public StateCell(int x, int y) {
		super(new Coordinate2D(x, y));
	}

	public StateCell(int x, int y, State state) {
		super(new Coordinate2D(x, y));
		this.state = state;
	}

	@Override
	public Coordinate2D getCoordinates() {
		return this.cord;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public StateCell clone() {
		return new StateCell(this.getCoordinates().getX().intValue(), this.getCoordinates().getY().intValue(),
				this.state);
	}

	@Override
	public String toString() {
		return "StateCell [state=" + state + ", getCoordinates()=" + getCoordinates() + "]";
	}
	
	

}
