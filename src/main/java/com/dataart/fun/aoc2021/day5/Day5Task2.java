package com.dataart.fun.aoc2021.day5;

import com.dataart.fun.aoc2021.Solver;
import com.dataart.fun.aoc2021.TaskSignature;
import com.dataart.fun.aoc2021.WithLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

@Service
public class Day5Task2 extends Day5Task1 {

	public Day5Task2() {
		count45DegreeLines = true;
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(5,2);
	}
}
