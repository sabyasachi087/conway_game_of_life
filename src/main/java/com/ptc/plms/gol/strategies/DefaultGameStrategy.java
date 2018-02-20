package com.ptc.plms.gol.strategies;

import com.ptc.plms.gol.oops.rules.Rule;
import com.ptc.plms.gol.oops.rules.StateRule;

/**
 * 
 * @author hdhingra
 *
 */
public class DefaultGameStrategy extends GameStrategy2DTemplate<StateRule> {

	public DefaultGameStrategy() {
		setRules(new Rule[] { new StateRule() });
	}

}
