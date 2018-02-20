package com.ptc.plms.gol.strategies;

import com.ptc.plms.gol.rules.Rule;
import com.ptc.plms.gol.rules.StateRule;

/**
 * 
 * @author hdhingra
 *
 */
public class DefaultGameStrategy extends GameStrategy2DTemplate {

	protected final Rule[] rules;

	public DefaultGameStrategy() {
		Rule rule1 = new StateRule();
		this.rules = new Rule[] { rule1 };
	}

	@Override
	public Rule[] getRules() {
		return rules;
	}

}
