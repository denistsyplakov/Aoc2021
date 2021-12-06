package com.dataart.fun.aoc2021;

import java.io.IOException;

public interface Solver {

	String solve() throws IOException;

	TaskSignature signature();

}
