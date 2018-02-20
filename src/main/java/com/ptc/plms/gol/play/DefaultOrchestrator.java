package com.ptc.plms.gol.play;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ptc.plms.gol.models.BaseCell;
import com.ptc.plms.gol.models.CellProperty;
import com.ptc.plms.gol.models.Coordinate2D;
import com.ptc.plms.gol.models.State;
import com.ptc.plms.gol.models.StateCell;
import com.ptc.plms.gol.rules.Rule;
import com.ptc.plms.gol.strategies.GameStrategy;

public class DefaultOrchestrator implements GolOrchestrator<StateCell> {

	private GameStrategy<StateCell> gameStrategy;

	@SuppressWarnings("unchecked")
	public DefaultOrchestrator(GameStrategy<? extends BaseCell<Coordinate2D>> gameStrategy) {
		this.gameStrategy = (GameStrategy<StateCell>) gameStrategy;
	}

	public Set<StateCell> applyRules(Set<StateCell> cells) {
		Set<StateCell> nextGeneration = new HashSet<StateCell>();
		for (StateCell cellFromCurrentGeneration : cells) {
			processCell(cellFromCurrentGeneration, cells, nextGeneration);
		}

		return filterDead(nextGeneration);
	}

	private Set<StateCell> filterDead(Set<StateCell> nextGeneration) {
		Iterator<StateCell> iterator = nextGeneration.iterator();

		while (iterator.hasNext()) {
			if (State.DEAD.equals(iterator.next().getState())) {
				iterator.remove();
			}
		}

		return nextGeneration;
	}

	private void processCell(StateCell cell, Set<StateCell> currentGeneration, Set<StateCell> nextGeneration) {
		if (nextGeneration.contains(cell))
			return; // already processed

		StateCell clonedCell = cell.clone();

		CellProperty nextState = null;
		for (Rule rule : gameStrategy.getRules()) {
			nextState = rule.nextState(clonedCell.getState(), findLiveNeighbourCount(clonedCell, currentGeneration));
			if (!clonedCell.getState().equals(nextState)) {
				break;
			}
		}
		clonedCell.setState((State) nextState);
		nextGeneration.add(clonedCell);
	}

	private int findLiveNeighbourCount(StateCell cell, Set<StateCell> liveCells) {
		int count = 0;
		for (StateCell c : gameStrategy.findNeighbours(cell, liveCells)) {
			if (State.LIVE.equals(c.getState()))
				count++;
		}
		return count;
	}

}
