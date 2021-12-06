package com.dataart.fun.aoc2021.day3;

import com.dataart.fun.aoc2021.Solver;
import com.dataart.fun.aoc2021.TaskSignature;
import com.dataart.fun.aoc2021.WithLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class Day3Task2 implements Solver, WithLogger {

	private record ZerosAndOnes(int[] zeros, int[] ones) {
	}

	private interface BitPredicate {
		char bit(ZerosAndOnes counts, int pos);
	}

	@Value("classpath:day3/task-input.txt")
	Resource taskInput;

	public String solve() throws IOException {
		List<char[]> numbers = new ArrayList<>();
		try (var br = new BufferedReader(new InputStreamReader(taskInput.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				numbers.add(line.toCharArray());
			}
		}
		return (findValue(numbers, (counts, pos) -> counts.ones()[pos] >= counts.zeros()[pos] ? '1' : '0') *
				findValue(numbers, (counts1, pos1) -> counts1.zeros()[pos1] <= counts1.ones()[pos1] ? '0' : '1'))+"";
	}

	private int findValue(List<char[]> numbers, BitPredicate predicate) {
		numbers = new ArrayList<>(numbers);
		final var width = numbers.get(0).length;
		for (int i = 0; i < width; i++) {
			final var pos = i;
			final char bit = predicate.bit(calcZerosAndOnes(numbers), pos);
			numbers.removeIf(o -> o[pos] != bit);
			if (numbers.size() == 1) {
				return Integer.parseInt(new String(numbers.get(0)), 2);
			}
		}
		throw new RuntimeException("Cannot fine the value");
	}

	private ZerosAndOnes calcZerosAndOnes(List<char[]> data) {
		int width = data.get(0).length;
		ZerosAndOnes counts = new ZerosAndOnes(new int[width], new int[width]);
		for (var lineChars : data) {
			for (int i = 0; i < lineChars.length; i++) {
				switch (lineChars[i]) {
					case '0' -> counts.zeros()[i]++;
					case '1' -> counts.ones()[i]++;
				}
			}
		}
		return counts;
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(3, 2);
	}

}
