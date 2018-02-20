package com.ptc.plms.gol.strategies;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ptc.plms.gol.StateData;
import com.ptc.plms.gol.models.StateCell;

public class TestDefaultStrategy extends StateData {

	@Test
	public void test() {
		GameStrategy<StateCell> gs = StrategyFactory.getDefaultStrategy();
		Set<StateCell> neighbours = gs.findNeighbours(cell_matrx[1][1], cells);
		Assert.assertTrue(neighbours.size() == 8);
	}

}
