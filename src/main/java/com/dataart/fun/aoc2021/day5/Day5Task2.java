package com.dataart.fun.aoc2021.day5;

import com.dataart.fun.aoc2021.TaskSignature;
import org.springframework.stereotype.Service;

@Service
public class Day5Task2 extends Day5Task1 {

	public Day5Task2() {
		count45DegreeLines = true;
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(5, 2);
	}
}
