package com.dataart.fun.aoc2021;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class Aoc2021Application implements CommandLineRunner {

	@Autowired
	List<Solver> solvers;

	public static void main(String[] args) {
		SpringApplication.run(Aoc2021Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(solve(2, 2));
	}

	private int solve(int day, int taskN) throws IOException {
		for (Solver solver : solvers) {
			if (solver.signature().day() == day && solver.signature().taskN() == taskN) {
				return solver.solve();
			}
		}
		throw new IllegalStateException("No solver for day: " + day + " taskN: " + taskN);
	}

}
