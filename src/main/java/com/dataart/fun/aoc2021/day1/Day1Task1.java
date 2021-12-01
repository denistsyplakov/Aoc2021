package com.dataart.fun.aoc2021.day1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class Day1Task1 {

	private static final Logger log = LoggerFactory.getLogger(Day1Task1.class);

	@Value("classpath:day1/task-input.txt")
	private Resource task1;

	public void solve() {
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
		} catch (IOException e) {
			log.error("day1task1", e);
			return;
		}
		log.info("Answer: {}", answer);
	}

}
