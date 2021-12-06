package com.dataart.fun.aoc2021.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
class Day5Tests {

	@Autowired
	Day5Task1 day5Task1;

	@Autowired
	Day5Task2 day5Task2;

	@Value("classpath:day5/task-input-test.txt")
	Resource testInput;

	@Test
	void testDay5Task1() throws IOException {
		day5Task1.taskInput = testInput;
		Assertions.assertEquals(day5Task1.solve(), "5");
	}

	@Test
	void testDay5Task2() throws IOException {
		day5Task2.taskInput = testInput;
		Assertions.assertEquals(day5Task2.solve(), "12");
	}


}
