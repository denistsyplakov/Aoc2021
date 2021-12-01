package com.dataart.fun.aoc2021;

import com.dataart.fun.aoc2021.day1.Day1Task1;
import com.dataart.fun.aoc2021.day1.Day1Task2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aoc2021Application implements CommandLineRunner {

	@Autowired
	Day1Task1 day1Task1;

	@Autowired
	Day1Task2 day1Task2;

	public static void main(String[] args) {
		SpringApplication.run(Aoc2021Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		day1Task2.solve();
	}
}
