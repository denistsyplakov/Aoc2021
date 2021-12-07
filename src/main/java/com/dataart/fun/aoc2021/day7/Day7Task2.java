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
		return numbers
				.stream()
				.map(num -> {
					int n = Math.abs(num - mark);
					return n * (n + 1) / 2;
				})
				.mapToInt(Integer::intValue).sum();
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(7, 2);
	}
}
