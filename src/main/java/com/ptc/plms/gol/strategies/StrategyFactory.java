package com.ptc.plms.gol.strategies;

import com.ptc.plms.gol.models.BaseCell;
import com.ptc.plms.gol.models.Coordinate2D;
import com.ptc.plms.gol.models.StateCell;

@SuppressWarnings("unchecked")
public class StrategyFactory {

	public static final GameStrategy<StateCell> getDefaultStrategy() {
		GameStrategy<? extends BaseCell<Coordinate2D>> tmp = new DefaultGameStrategy();
		GameStrategy<StateCell> gs = (GameStrategy<StateCell>) tmp;
		return gs;
	}

}
