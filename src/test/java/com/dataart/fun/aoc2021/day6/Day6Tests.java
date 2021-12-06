package com.dataart.fun.aoc2021.day6;

import com.dataart.fun.aoc2021.day5.Day5Task1;
import com.dataart.fun.aoc2021.day5.Day5Task2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
class Day6Tests {

	@Autowired
	Day6Task1 day6Task1;

	@Autowired
	Day6Task2 day6Task2;

	@Value("classpath:day6/task-input-test.txt")
	Resource testInput;

	@Test
	void testDay5Task1() throws IOException {
		day6Task1.taskInput = testInput;
		Assertions.assertEquals(day6Task1.solve(), "5934");
	}

	@Test
	void testDay5Task2() throws IOException {
		day6Task2.taskInput = testInput;
		Assertions.assertEquals(day6Task2.solve(), "26984457539");
	}


}