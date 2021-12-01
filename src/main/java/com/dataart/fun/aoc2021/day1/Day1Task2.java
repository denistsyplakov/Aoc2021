package com.dataart.fun.aoc2021.day1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class Day1Task2 {

	private static final Logger log = LoggerFactory.getLogger(Day1Task2.class);

	@Value("classpath:day1/task-input.txt")
	private Resource task1;

	public void solve() {
		int answer = 0;
		List<Integer> nums = new ArrayList<>();
		try (var br = new BufferedReader(new InputStreamReader(task1.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				nums.add(Integer.parseInt(line));
				if( nums.size() >= 4){
					if (nums.size()>4) {
						nums.remove((int) 0);
					}
					if ( nums.get(0)+nums.get(1)+nums.get(2) < nums.get(1)+nums.get(2)+nums.get(3)){
						answer++;
					}
				}
			}
		} catch (IOException e) {
			log.error("day1task2", e);
			return;
		}
		log.info("Answer: {}", answer);
	}

}
