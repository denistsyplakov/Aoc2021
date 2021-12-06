package com.dataart.fun.aoc2021.day6;

import com.dataart.fun.aoc2021.TaskSignature;
import org.springframework.stereotype.Service;

@Service
public class Day6Task2 extends Day6Task1 {
	public Day6Task2() {
		daysToSimulate = 256;
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(6, 2);
	}
}
