package com.ptc.plms.gol.oops.rules;

import com.ptc.plms.gol.models.BaseCell;
import com.ptc.plms.gol.models.CellProperty;
import com.ptc.plms.gol.models.State;
import com.ptc.plms.gol.models.StateCell;

/**
 * 
 * @author hdhingra
 *
 */
public class StateRule implements Rule<State, StateCell> {

	@Override
	public State nextState(StateCell currentCell, int liveNeighbours) {
		State currentState = currentCell.getState();
		if (State.LIVE.equals(currentState)) {
			if (liveNeighbours == 2 || liveNeighbours == 3) {
				return State.LIVE;
			} else
				return State.DEAD;
		} else if (State.DEAD.equals(currentState)) {
			if (liveNeighbours == 3) {
				return State.LIVE;
			}
		}

		return currentState;
	}

	@Override
	public State getProperty(BaseCell<?> e) {
		return ((StateCell)e).getState();
	}

	@Override
	public void setProperty(BaseCell<?> e, CellProperty property) {
		((StateCell)e).setState((State)property);	
	}

}
