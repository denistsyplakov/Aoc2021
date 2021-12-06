package com.dataart.fun.aoc2021.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Day3Tests {

	@Autowired
	Day3Task1 day3Task1;

	@Autowired
	Day3Task2 day3Task2;

	@Test
	void testDay3Task1() throws IOException {
		Assertions.assertEquals(day3Task1.solve(), "198");
	}

	@Test
	void testDay3Task2() throws IOException {
		Assertions.assertEquals(day3Task2.solve(), "230");
	}

}
