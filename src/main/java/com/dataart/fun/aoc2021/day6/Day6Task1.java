package com.dataart.fun.aoc2021.day6;

import com.dataart.fun.aoc2021.Solver;
import com.dataart.fun.aoc2021.TaskSignature;
import com.dataart.fun.aoc2021.WithLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Day6Task1 implements Solver, WithLogger {

	@Value("classpath:day6/task-input.txt")
	Resource taskInput;

	int daysToSimulate = 80;

	static class BigIntContainer {
		BigInteger value = new BigInteger("0");

		public void inc() {
			value = value.add(new BigInteger("1"));
		}

		public void add(BigInteger val2) {
			value = value.add(val2);
		}
	}

	@Override
	public String solve() throws IOException {
		List<Integer> numbers;
		try (var br = new BufferedReader(new InputStreamReader(taskInput.getInputStream()))) {
			numbers = Arrays.stream(br.readLine().split(","))
					.map(Integer::parseInt)
					.collect(Collectors.toList());
		}
		Map<Integer, BigIntContainer> stages = new HashMap<>();
		for (Integer num : numbers) {
			stages.computeIfAbsent(num, num1 -> new BigIntContainer()).inc();
		}
		for (int day = 1; day <= daysToSimulate; day++) {
			stages = doSimulation(stages);
		}
		return count(stages).toString();
	}

	private Map<Integer, BigIntContainer> doSimulation(Map<Integer, BigIntContainer> stages) {
		Map<Integer, BigIntContainer> result = new HashMap<>();
		for (Integer key : stages.keySet()) {
			if (key != 0) {
				result.computeIfAbsent(key - 1, integer -> new BigIntContainer()).add(stages.get(key).value);
			} else {
				result.computeIfAbsent(6, integer -> new BigIntContainer()).add(stages.get(key).value);
				result.put(8, stages.get(key));
			}
		}
		return result;
	}

	private BigInteger count(Map<Integer, BigIntContainer> stages) {
		BigInteger result = new BigInteger("0");
		for (var n : stages.values()) {
			result = result.add(n.value);
		}
		return result;
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(6, 1);
	}
}
