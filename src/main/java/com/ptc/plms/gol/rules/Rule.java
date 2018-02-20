package com.ptc.plms.gol.rules;

import com.ptc.plms.gol.models.CellProperty;

/**
 * 
 * @author hdhingra
 *
 */
public interface Rule {
	CellProperty nextState(CellProperty currentState,int liveNeighbours);
}
	
	
	
