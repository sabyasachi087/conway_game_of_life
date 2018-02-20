package com.ptc.plms.gol.play;

import java.util.Set;

import com.ptc.plms.gol.models.BaseCell;

public interface GolOrchestrator<T extends BaseCell<?>> {
	
	public Set<T> applyRules(Set<T> cells);

}
