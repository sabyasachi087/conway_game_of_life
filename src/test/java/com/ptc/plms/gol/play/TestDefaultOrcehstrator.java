package com.ptc.plms.gol.play;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ptc.plms.gol.StateData;
import com.ptc.plms.gol.models.State;
import com.ptc.plms.gol.models.StateCell;
import com.ptc.plms.gol.strategies.StrategyFactory;

public class TestDefaultOrcehstrator extends StateData {

	@Test
	public void test1() {
		GolOrchestrator<StateCell> orchestrator = new DefaultOrchestrator(StrategyFactory.getDefaultStrategy());
		this.cell_matrx[1][1].setState(State.LIVE);
		this.cell_matrx[1][0].setState(State.LIVE);
		this.cell_matrx[1][2].setState(State.LIVE);
		Set<StateCell> newCells = orchestrator.applyRules(this.cells);
		Assert.assertTrue(newCells.size() == 3);
	}

	@Test
	public void test2() {
		GolOrchestrator<StateCell> orchestrator = new DefaultOrchestrator(StrategyFactory.getDefaultStrategy());
		this.cell_matrx[1][1].setState(State.LIVE);
		this.cell_matrx[1][0].setState(State.LIVE);
		this.cell_matrx[2][2].setState(State.LIVE);
		Set<StateCell> newCells = orchestrator.applyRules(this.cells);
		Assert.assertTrue(newCells.size() == 2);
	}

}
