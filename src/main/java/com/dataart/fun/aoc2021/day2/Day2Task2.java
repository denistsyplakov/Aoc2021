package com.dataart.fun.aoc2021.day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class Day2Task2 {

	private static final Logger log = LoggerFactory.getLogger(Day2Task2.class);

	@Value("classpath:day2/task-input.txt")
	private Resource input;

	public void solve() {
		int horPos = 0;
		int depth = 0;
		int aim = 0;
		try (var br = new BufferedReader(new InputStreamReader(input.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] cmd = line.split(" ");
				int val = Integer.parseInt(cmd[1]);
				switch (cmd[0]) {
					case "forward" -> {
						horPos += val;
						depth += aim * val;
					}
					case "up" -> aim -= val;
					case "down" -> aim += val;
				}
			}
		} catch (IOException e) {
			log.error("day2task1", e);
			return;
		}
		log.info("Answer horPos: {} depth:{} answer: {}", horPos, depth, horPos * depth);
	}

}
