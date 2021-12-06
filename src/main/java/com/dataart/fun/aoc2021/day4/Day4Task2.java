package com.dataart.fun.aoc2021.day4;

import com.dataart.fun.aoc2021.Solver;
import com.dataart.fun.aoc2021.TaskSignature;
import com.dataart.fun.aoc2021.WithLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class Day4Task2 implements Solver, WithLogger {

	private static final int cellMarker = 1_000_000;

	@Value("classpath:day4/task-input.txt")
	Resource taskInput;

	record Board(int[][] field, AtomicBoolean boardWon) {
		Board {
			boardWon.set(false);
		}

		public boolean bingoQuestionMark(int number) {
			if (boardWon.get()) {
				//no bingo for already won boards.
				return false;
			}
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (field[i][j] == number) {
						field[i][j] = field[i][j] + cellMarker;
						return checkBingo(i, j);
					}
				}
			}
			return false;
		}

		private boolean checkBingo(int i, int j) {
			int linesNonMarked = 0;
			for (int k = 0; k < 5; k++) {
				if (field()[i][k] < cellMarker) {
					linesNonMarked++;
					break;
				}
			}
			for (int k = 0; k < 5; k++) {
				if (field()[k][j] < cellMarker) {
					linesNonMarked++;
					break;
				}
			}
			boardWon.set(linesNonMarked < 2);
			return boardWon.get();
		}

		private int sumAllUnmarked() {
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (field()[i][j] < cellMarker) {
						sum += field()[i][j];
					}
				}
			}
			return sum;
		}

	}

	@Override
	public String solve() throws IOException {
		List<Integer> numbers;
		Set<Board> boards = new HashSet<>();
		try (var br = new BufferedReader(new InputStreamReader(taskInput.getInputStream()))) {
			numbers = Arrays.stream(br.readLine().split(","))
					.map(Integer::parseInt)
					.collect(Collectors.toList());
			while (br.readLine() != null) {
				boards.add(readBoard(br));
			}
		}
		int wonBoardCount = 0;
		for (Integer number : numbers) {
			for (Board board : boards) {
				if (board.bingoQuestionMark(number)) {
					wonBoardCount++;
					if (wonBoardCount == boards.size()) {
						return (board.sumAllUnmarked() * number) + "";
					}
				}
			}
		}
		throw new IllegalStateException("No bingo :-(");
	}

	private Board readBoard(BufferedReader br) throws IOException {
		var board = new Board(new int[5][5], new AtomicBoolean(false));
		for (int i = 0; i < 5; i++) {
			String[] boardLine = br.readLine().trim().replaceAll("  *", " ").split(" ");
			Assert.isTrue(boardLine.length == 5, "boardLine.length == 5");
			for (int j = 0; j < 5; j++) {
				board.field()[i][j] = Integer.parseInt(boardLine[j]);
			}
		}
		return board;
	}

	@Override
	public TaskSignature signature() {
		return new TaskSignature(4, 2);
	}
}
