package com.ptc.plms.gol.rules;

import org.junit.Assert;
import org.junit.Test;

import com.ptc.plms.gol.models.State;

public class TestRule {

	@Test
	public void testStateRule() {
		Rule rule = new StateRule();
		Assert.assertEquals(rule.nextState(State.LIVE, 1), State.DEAD);
		Assert.assertEquals(rule.nextState(State.LIVE, 2), State.LIVE);
		Assert.assertEquals(rule.nextState(State.DEAD, 3), State.LIVE);
		// Add all possible case here
	}

}
