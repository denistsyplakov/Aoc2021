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

@Service
public class Day3Task1 implements Solver, WithLogger {

	@Value("classpath:day3/task-input.txt")
	Resource taskInput;

	public int solve() throws IOException {

		try (var br = new BufferedReader(new InputStreamReader(taskInput.getInputStream()))) {
			String line;
			int[] zeros = null;
			int[] ones = null;
			while ((line = br.readLine()) != null) {
				if (zeros == null) {
					//all lines have the same length
					zeros = new int[line.length()];
					ones = new int[line.length()];
				}
				char[] lineChars = line.toCharArray();
				for (int i = 0; i < lineChars.length; i++) {
					switch (lineChars[i]) {
						case '0' -> zeros[i]++;
						case '1' -> ones[i]++;
					}
				}
			}
			log().info("{}/{}", zeros, ones);
			var gammaStr = new char[zeros.length];
			var epsilonStr = new char[zeros.length];
			for (int i = 0; i < zeros.length; i++) {
				if (zeros[i] > ones[i]) {
					gammaStr[i] = '0';
					epsilonStr[i] = '1';
				} else {
					gammaStr[i] = '1';
					epsilonStr[i] = '0';
				}
			}
			log().info("{}*{}", gammaStr, epsilonStr);
			return Integer.parseInt(new String(gammaStr), 2) * Integer.parseInt(new String(epsilonStr), 2);
		}
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(3, 1);
	}

}
