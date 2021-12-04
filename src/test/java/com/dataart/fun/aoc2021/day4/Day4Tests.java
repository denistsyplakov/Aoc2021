package com.dataart.fun.aoc2021.day4;

import com.dataart.fun.aoc2021.day3.Day3Task1;
import com.dataart.fun.aoc2021.day3.Day3Task2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.IOException;

@SpringBootTest
class Day4Tests {

	@Autowired
	Day4Task1 day4Task1;

	@Autowired
	Day4Task2 day4Task2;

	@Value("classpath:day4/task-input-test.txt")
	Resource testInput;

	@Test
	void testDay4Task1() throws IOException {
		day4Task1.taskInput = testInput;
		Assert.isTrue( day4Task1.solve() == 4512,"day4Task1.solve() == 4512");
	}

	@Test
	void testDay4Task2() throws IOException {
		day4Task2.taskInput = testInput;
		Assert.isTrue( day4Task2.solve() == 1924,"day4Task2.solve() == 1924");
	}

}
