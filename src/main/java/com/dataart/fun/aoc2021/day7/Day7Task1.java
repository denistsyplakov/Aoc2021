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
		int from = Collections.min(numbers);
		int to = Collections.max(numbers);
		int minFuel = Integer.MAX_VALUE;
		for (int i = from; i <= to; i++) {
			int fuel = checkFuel(i, numbers);
			if (minFuel > fuel) {
				log().info("{}:{}->{}", i, minFuel, fuel);
				minFuel = fuel;
			}
		}
		return minFuel + "";
	}

	protected int checkFuel(Integer mark, List<Integer> numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += Math.abs(numbers.get(i) - mark);
		}
		return sum;
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(7, 1);
	}
}
