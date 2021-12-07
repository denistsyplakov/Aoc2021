package com.dataart.fun.aoc2021.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Day6Tests {

	@Autowired
	Day6Task1 day6Task1;

	@Autowired
	Day6Task2 day6Task2;

	@Test
	void testDay6Task1() throws IOException {
		Assertions.assertEquals(day6Task1.solve(), "5934");
	}

	@Test
	void testDay6Task2() throws IOException {
		Assertions.assertEquals(day6Task2.solve(), "26984457539");
	}


}
