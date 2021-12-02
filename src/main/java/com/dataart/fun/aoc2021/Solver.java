package com.dataart.fun.aoc2021;

import java.io.IOException;

public interface Solver {

	int solve() throws IOException;

	TaskSignature signature();

}
