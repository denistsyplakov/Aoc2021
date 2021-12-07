package com.dataart.fun.aoc2021.day7;

import com.dataart.fun.aoc2021.TaskSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Day7Task2 extends Day7Task1 {

	@Value("classpath:day7/task-input.txt")
	Resource taskInput;

	protected int checkFuel(Integer mark, List<Integer> numbers) {
		int sum = 0;
		for (Integer number : numbers) {
			int n = Math.abs(number - mark);
			sum += n * (n + 1) / 2;
		}
		return sum;
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(7, 2);
	}
}
