package com.ptc.plms.gol.strategies;

import java.util.Set;

import com.ptc.plms.gol.models.BaseCell;
import com.ptc.plms.gol.rules.Rule;

/**
 * 
 * @author hdhingra
 *
 */
public interface GameStrategy<T extends BaseCell<?>> {

	Set<T> findNeighbours(T cellFromCurrentGeneration, Set<T> cellMatrix);

	Rule[] getRules();

}
