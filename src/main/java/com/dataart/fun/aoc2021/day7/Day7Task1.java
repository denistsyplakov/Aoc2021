package com.dataart.fun.aoc2021.day7;

import com.dataart.fun.aoc2021.Solver;
import com.dataart.fun.aoc2021.TaskSignature;
import com.dataart.fun.aoc2021.WithLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class Day7Task1 implements Solver, WithLogger {

	@Value("classpath:day7/task-input.txt")
	Resource taskInput;

	@Override
	public String solve() throws IOException {
		List<Integer> numbers;
		try (var br = new BufferedReader(new InputStreamReader(taskInput.getInputStream()))) {
			numbers = Arrays.stream(br.readLine().split(","))
					.map(Integer::parseInt)
					.collect(Collectors.toList());
		}
		return IntStream.range(Collections.min(numbers), Collections.max(numbers))
				.map(mark -> checkFuel(mark, numbers))
				.min().getAsInt() + "";

	}

	protected int checkFuel(Integer mark, List<Integer> numbers) {
		return numbers.stream()
				.map(num -> Math.abs(num - mark))
				.mapToInt(Integer::intValue).sum();
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(7, 1);
	}
}
