package com.ptc.plms.gol.oops;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ptc.plms.gol.strategies.DefaultGameStrategy;
import com.ptc.plms.gol.strategies.GameStrategy;

public class TestDefaultStrategy {

	private Set<Cell> cells = new HashSet<>();
	private Integer MAX_X = 3, MAX_Y = 3;
	private Cell[][] cell_matrx = new Cell[MAX_X][MAX_Y];

	@Before
	public void init() {
		// Initialize a MAX_X x MAX_Y matrix of dead cell
		Cell cell = null;
		for (int x = 0; x < MAX_X; x++) {
			for (int y = 0; y < MAX_Y; y++) {
				cell = new Cell(x, y, State.DEAD);
				cells.add(cell);
				cell_matrx[x][y] = cell;
			}
		}
	}

	@Test
	public void test() {
		GameStrategy gs = new DefaultGameStrategy();
		Set<Cell> neighbours = gs.findNeighbours(cell_matrx[1][1], cells);
		Assert.assertTrue(neighbours.size() == 8);
	}

	private void print() {
		for (int x = 0; x < MAX_X; x++) {
			for (int y = 0; y < MAX_Y; y++) {
				System.out.println((cell_matrx[x][y]).getState() + " ");
			}
			System.out.println();
		}
	}

}
