package com.ptc.plms.gol;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;

import com.ptc.plms.gol.models.State;
import com.ptc.plms.gol.models.StateCell;

public class StateData {

	protected Set<StateCell> cells = new HashSet<>();
	private Integer MAX_X = 3, MAX_Y = 3;
	protected StateCell[][] cell_matrx = new StateCell[MAX_X][MAX_Y];

	@Before
	public void init() {
		// Initialize a MAX_X x MAX_Y matrix of dead cell
		StateCell cell = null;
		for (int x = 0; x < MAX_X; x++) {
			for (int y = 0; y < MAX_Y; y++) {
				cell = new StateCell(x, y, State.DEAD);
				cells.add(cell);
				cell_matrx[x][y] = cell;
			}
		}
	}
	
	protected void print() {
		for (int x = 0; x < MAX_X; x++) {
			for (int y = 0; y < MAX_Y; y++) {
				System.out.println((cell_matrx[x][y]).getState() + " ");
			}
			System.out.println();
		}
	}

}
