package com.ptc.plms.gol.strategies;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ptc.plms.gol.models.BaseCell;
import com.ptc.plms.gol.models.Coordinate2D;

/**
 * 
 * @author hdhingra
 *
 */
public abstract class GameStrategy2DTemplate implements GameStrategy<BaseCell<Coordinate2D>> {

	@Override
	public Set<BaseCell<Coordinate2D>> findNeighbours(BaseCell<Coordinate2D> cell,
			Set<BaseCell<Coordinate2D>> cellMatrix) {
		Set<BaseCell<Coordinate2D>> neighbours = new HashSet<BaseCell<Coordinate2D>>();
		Map<Coordinate2D, BaseCell<Coordinate2D>> cellMap = this.convertToMap(cellMatrix);
		int x = cell.getCoordinates().getX().intValue();
		int y = cell.getCoordinates().getY().intValue();
		BaseCell<Coordinate2D> tempCell;
		for (int i = x - 1; i <= x + 1; i++) {
			if (i < 0)
				continue;

			for (int j = y - 1; j <= y + 1; j++) {
				if (j < 0)
					continue;
				if (i == x && j == y) {
					continue;
				} else {
					tempCell = cellMap.get(new Coordinate2D(i, j));
					if (tempCell != null) {
						neighbours.add(tempCell.clone());
					}
				}
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
