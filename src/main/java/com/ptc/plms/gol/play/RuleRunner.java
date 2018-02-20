package com.ptc.plms.gol.play;

import com.ptc.plms.gol.models.StateCell;
import com.ptc.plms.gol.strategies.DefaultGameStrategy;

public class RuleRunner {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		GolOrchestrator<StateCell> orchestrator = new DefaultOrchestrator(new DefaultGameStrategy());
		/** TODO - Execute your code */
	}

}
