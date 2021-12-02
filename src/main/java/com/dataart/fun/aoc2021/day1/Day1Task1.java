package com.dataart.fun.aoc2021.day1;

import com.dataart.fun.aoc2021.Solver;
import com.dataart.fun.aoc2021.TaskSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class Day1Task1 implements Solver {

	@Value("classpath:day1/task-input.txt")
	private Resource task1;

	public int solve() throws IOException {
		Integer nprev = null;
		int answer = 0;
		try (var br = new BufferedReader(new InputStreamReader(task1.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				int n = Integer.parseInt(line);
				if (nprev != null && nprev < n) {
					answer++;
				}
				nprev = n;
			}
		}
		return answer;
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(1, 1);
	}

}
