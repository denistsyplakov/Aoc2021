package com.dataart.fun.aoc2021.day3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.IOException;

@SpringBootTest
class Day3Tests {

	@Autowired
	Day3Task1 day3Task1;

	@Autowired
	Day3Task2 day3Task2;

	@Value("classpath:day3/task-input-test.txt")
	Resource testInput;

	@Test
	void testDay3Task1() throws IOException {
		day3Task1.taskInput = testInput;
		Assert.isTrue( day3Task1.solve() == 198,"day3Task1.solve() == 198");
	}

	@Test
	void testDay3Task2() throws IOException {
		day3Task2.taskInput = testInput;
		Assert.isTrue( day3Task2.solve() == 230,"day3Task2.solve() == 230");
	}

}
