package com.ptc.plms.gol.rules;

import com.ptc.plms.gol.models.CellProperty;
import com.ptc.plms.gol.models.State;

/**
 * 
 * @author hdhingra
 *
 */
public class StateRule implements Rule {

	@Override
	public CellProperty nextState(CellProperty currentState, int liveNeighbours) {
		if (State.LIVE.equals(currentState)) {
			if (liveNeighbours == 2 || liveNeighbours == 3) {
				return State.LIVE;
			} else {
				return State.DEAD;
			}
		} else if (State.DEAD.equals(currentState)) {
			if (liveNeighbours == 3) {
				return State.LIVE;
			}
		}
		return currentState;
	}

}
