package com.dataart.fun.aoc2021.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Day4Tests {

	@Autowired
	Day4Task1 day4Task1;

	@Autowired
	Day4Task2 day4Task2;

	@Test
	void testDay4Task1() throws IOException {
		Assertions.assertEquals(day4Task1.solve(), "4512");
	}

	@Test
	void testDay4Task2() throws IOException {
		Assertions.assertEquals(day4Task2.solve(), "1924");
	}

}
