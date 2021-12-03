package com.dataart.fun.aoc2021;

import com.dataart.fun.aoc2021.day3.Day3Task1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Aoc2021ApplicationTests {

	@Autowired
	Day3Task1 day3Task1;

	@Test
	void contextLoads() {
	}

	@Test
	void testDay3Task1() throws IOException {
		day3Task1.solve();
	}

}
