package com.dataart.fun.aoc2021;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class Day3Task1  implements Solver, WithLogger  {

	@Value("classpath:day3/task-input.txt")
	private Resource task1;

	public int solve() throws IOException {

		try (var br = new BufferedReader(new InputStreamReader(task1.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {

			}
		}

		return -1;
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(3, 1);
	}

}
