package com.ptc.plms.gol.strategies;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ptc.plms.gol.models.BaseCell;
import com.ptc.plms.gol.models.Coordinate2D;
import com.ptc.plms.gol.oops.rules.Rule;

/**
 * 
 * @author hdhingra
 *
 */
public abstract class GameStrategy2DTemplate<R extends Rule<?, ?>> implements GameStrategy<BaseCell<Coordinate2D>> {

	private Rule<?, ?>[] rules;

	@Override
	public void setRules(Rule<?, ?>[] rules) {
		this.rules = rules;
	}

	@Override
	public Rule<?, ?>[] getRules() {
		return rules;
	}

	@Override
	public Set<BaseCell<Coordinate2D>> findNeighbours(BaseCell<Coordinate2D> cell,
			Set<BaseCell<Coordinate2D>> liveCells) {
		Set<BaseCell<Coordinate2D>> neighbours = new HashSet<BaseCell<Coordinate2D>>();
		Map<Coordinate2D, BaseCell<Coordinate2D>> cellMap = this.convertToMap(liveCells);
		int x = ((Coordinate2D) cell.getCoordinates()).getX().intValue();
		int y = ((Coordinate2D) cell.getCoordinates()).getY().intValue();
		BaseCell<Coordinate2D> tempCell;
		for (int i = x - 1; i <= x + 1; i++) {
			if (i < 0)
				continue;

			for (int j = y - 1; j <= y + 1; j++) {
				if (j < 0)
					continue;

				tempCell = cellMap.get(new Coordinate2D(x, y));
				/*
				 * if (liveCells.contains(tempCell)) {
				 * tempCell.setState(State.LIVE); }
				 */
				if (tempCell != null)
					neighbours.add(tempCell.clone());
				else
					System.err.println("Invalid coordinates x=" + x + " y=" + y);
			}
		}

		return neighbours;
	}

	private Map<Coordinate2D, BaseCell<Coordinate2D>> convertToMap(Set<BaseCell<Coordinate2D>> cells) {
		Map<Coordinate2D, BaseCell<Coordinate2D>> cellMap = new HashMap<>();
		for (BaseCell<Coordinate2D> cell : cells) {
			cellMap.put((cell.getCoordinates()), cell);
		}
		return cellMap;
	}
}
