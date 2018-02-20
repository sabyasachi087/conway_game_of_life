package com.ptc.plms.gol.play;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ptc.plms.gol.models.BaseCell;
import com.ptc.plms.gol.models.CellProperty;
import com.ptc.plms.gol.models.State;
import com.ptc.plms.gol.models.StateCell;
import com.ptc.plms.gol.oops.rules.Rule;
import com.ptc.plms.gol.strategies.GameStrategy;

public class RuleRunner implements GolOrchestrator {

	private GameStrategy<?> gameStrategy;

	public RuleRunner(GameStrategy<?> gameStrategy) {
		this.gameStrategy = gameStrategy;
	}

	public Set<? extends BaseCell<?>> applyRules(Set<? extends BaseCell<?>> liveCells) {
		Set<BaseCell<?>> nextGeneration = new HashSet<BaseCell<?>>();

		Set<BaseCell<?>> neighbouringCells;
		for (BaseCell<?> cellFromCurrentGeneration : liveCells) {
			processCell(cellFromCurrentGeneration, liveCells, nextGeneration);

			neighbouringCells = gameStrategy.findNeighbours(cellFromCurrentGeneration, liveCells);

			for (BaseCell<?> neighbouringCell : neighbouringCells) {
				processCell(neighbouringCell, liveCells, nextGeneration);
			}
		}

		return filterDead(nextGeneration);
	}

	private Set<BaseCell<?>> filterDead(HashSet<BaseCell<?>> nextGeneration) {
		Iterator<BaseCell<?>> iterator = nextGeneration.iterator();

		while (iterator.hasNext()) {
			if (State.DEAD.equals(iterator.next().getState())) {
				iterator.remove();
			}
		}

		return nextGeneration;
	}

	private void processCell(BaseCell<?> cell, Set<? extends BaseCell<?>> currentGeneration, Set<? extends BaseCell<?>> nextGeneration) {
		if (nextGeneration.contains(cell))
			return; // already processed

		cell = cell.clone();

		CellProperty nextState = null;
		for (Rule<?,?> rule : gameStrategy.getRules()) {
			nextState = rule.nextState(cell, findLiveNeighbourCount(cell, currentGeneration));
			rule.setProperty(cell, nextState);
			if (!rule.getProperty(cell).equals(nextState)) {
				break;
			}
		}

		cell.setState(nextState);
		nextGeneration.add(cell);
	}

	private int findLiveNeighbourCount(T extends BaseCell<?> cell, Set<? extends BaseCell<?>> liveCells) {
		int count = 0;
		for (BaseCell<?> c : gameStrategy.findNeighbours(cell, liveCells)) {
			if (State.LIVE.equals(c.getState()))
				count++;
		}
		return count;
	}

}
