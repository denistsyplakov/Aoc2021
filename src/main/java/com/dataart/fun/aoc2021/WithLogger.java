package com.dataart.fun.aoc2021;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface WithLogger {

	default Logger log() {
		return LoggerFactory.getLogger(this.getClass());
	}

}
