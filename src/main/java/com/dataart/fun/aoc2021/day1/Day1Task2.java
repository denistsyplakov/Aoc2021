package com.dataart.fun.aoc2021.day1;

import com.dataart.fun.aoc2021.Solver;
import com.dataart.fun.aoc2021.TaskSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class Day1Task2 implements Solver {

	@Value("classpath:day1/task-input.txt")
	private Resource task1;

	public int solve() throws IOException {
		int answer = 0;
		List<Integer> nums = new ArrayList<>();
		try (var br = new BufferedReader(new InputStreamReader(task1.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				nums.add(Integer.parseInt(line));
				if (nums.size() >= 4) {
					if (nums.size() > 4) {
						nums.remove(0);
					}
					if (nums.get(0) + nums.get(1) + nums.get(2) < nums.get(1) + nums.get(2) + nums.get(3)) {
						answer++;
					}
				}
			}
		}
		return answer;
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(1, 2);
	}

}
