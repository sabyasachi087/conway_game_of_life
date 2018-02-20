package com.ptc.plms.gol.oops.rules;

import com.ptc.plms.gol.models.BaseCell;
import com.ptc.plms.gol.models.CellProperty;

/**
 * 
 * @author hdhingra
 *
 */
public interface Rule<T extends CellProperty,E extends BaseCell<?>> {
	T nextState(E currentState,int liveNeighbours);
	
	T getProperty(BaseCell<?> e);
	
	void setProperty(BaseCell<?> e,CellProperty property);
}
