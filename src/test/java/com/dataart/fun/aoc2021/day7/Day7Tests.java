package com.dataart.fun.aoc2021.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Day7Tests {

	@Autowired
	Day7Task1 day7Task1;

	@Autowired
	Day7Task2 day7Task2;

	@Test
	void testDay7Task1() throws IOException {
		Assertions.assertEquals("37", day7Task1.solve());
	}

	@Test
	void testDay7Task2() throws IOException {
		Assertions.assertEquals("168", day7Task2.solve());
	}


}
