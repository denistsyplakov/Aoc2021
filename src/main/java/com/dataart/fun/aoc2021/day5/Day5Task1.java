package com.dataart.fun.aoc2021.day5;

import com.dataart.fun.aoc2021.Solver;
import com.dataart.fun.aoc2021.TaskSignature;
import com.dataart.fun.aoc2021.WithLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

@Service
public class Day5Task1 implements Solver, WithLogger {

	record Vector(int x1, int y1, int x2, int y2) {
	}

	@Value("classpath:day5/task-input.txt")
	Resource taskInput;

	protected boolean count45DegreeLines = false;

	public String solve() throws IOException {

		int answer;
		try (var br = new BufferedReader(new InputStreamReader(taskInput.getInputStream()))) {
			String line;
			int widthX = -1;
			int widthY = -1;
			Set<Vector> vectors = new HashSet<>();
			while ((line = br.readLine()) != null) {
				String[] lineArr = line.split(" ");
				String[] pair1 = lineArr[0].split(",");
				String[] pair2 = lineArr[2].split(",");
				var v = new Vector(
						Integer.parseInt(pair1[0]), Integer.parseInt(pair1[1]),
						Integer.parseInt(pair2[0]), Integer.parseInt(pair2[1])
				);
				widthX = checkWidthX(widthX, v);
				widthY = checkWidthY(widthY, v);
				vectors.add(v);
			}
			int[][] field = new int[widthX + 1][widthY + 1];
			vectors.forEach(vector -> applyVector(field, vector));
			answer = 0;
			for (int x = 0; x <= widthX; x++) {
				for (int y = 0; y <= widthY; y++) {
					if (field[y][x] > 1) {
						answer++;
					}
				}
			}
		}
		return answer+"";
	}

	private int checkWidthY(int widthY, Vector v) {
		if (widthY < v.y1()) {
			widthY = v.y1();
		}
		if (widthY < v.y2()) {
			widthY = v.y2();
		}
		return widthY;
	}

	private int checkWidthX(int widthX, Vector v) {
		if (widthX < v.x1()) {
			widthX = v.x1();
		}
		if (widthX < v.x2()) {
			widthX = v.x2();
		}
		return widthX;
	}

	private void applyVector(int[][] field, Vector vector) {
		if (!count45DegreeLines && vector.x1 != vector.x2 && vector.y1 != vector.y2) {
			return;
		}
		int dx = Integer.signum(vector.x2() - vector.x1());
		int dy = Integer.signum(vector.y2() - vector.y1());
		int x = vector.x1;
		int y = vector.y1;
		while (true) {
			field[y][x] += 1;
			if (x == vector.x2 && y == vector.y2) {
				break;
			}
			x += dx;
			y += dy;
		}
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(5, 1);
	}

}
