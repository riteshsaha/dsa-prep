package practice_projects;

import java.util.ArrayList;
import java.util.List;

/*
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 1 1 1 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 
 * 
 * snake((5,5), (5,6), (5,7))
 * 
 * 
 */

public class TestClass {
	
	public static void move(int[][] board, List<List<Integer>> snake, String direction) {
		int r = snake.get(0).get(0);
		int c = snake.get(0).get(1);
		switch(direction) {
			case "UP":
				moveUpOrDown(board, r, c, snake, direction);
				break;
			case "DOWN":
				moveUpOrDown(board, r, c, snake, direction);
				break;
			case "LEFT":
				moveLeftOrRight(board, r, c, snake, direction);
				break;
			case "RIGHT":
				moveLeftOrRight(board, r, c, snake, direction);
				break;
			default:
				moveLeftOrRight(board, r, c, snake, "LEFT");
		}
		return;
	}
	
	public static void moveLeftOrRight(int[][] board, int r, int c, List<List<Integer>> snake, String dir) {
		int headPosition = c;
		int snakeSize = snake.size();
		if(dir.equalsIgnoreCase("LEFT")) {
			for(int i = c; i >= 0; i--) {
				headPosition = i;
				if(i == 0) {
					System.out.print("Game over!!");
					return;
				}
			}
		} else {
			for(int i = 0; i <= c; i++) {
				headPosition = i;
				if(i == board[0].length - 1) {
					System.out.print("Game over!!");
					return;
				}
			}
		}

		for(int i = 0; i < snakeSize; i++) {
			List<Integer> pos = new ArrayList<>();
			pos.add(r, headPosition+i);
			snake.add(pos);
		}
		//snake = {{r, headPosition}, {r, headPosition+1}, {r, headPosition+2}};
	}	
	
	public static void moveUpOrDown(int[][] board, int r, int c, List<List<Integer>> snake, String dir) {
		int headPosition = r;
		int snakeSize = snake.size();
		if(dir.equalsIgnoreCase("DOWN")) {
			for(int i = 0; i <= r; i++) {
				headPosition = i;
				if(i == board.length - 1) {
					System.out.print("Game over!!");
					return;
				}
			}
		} else {
			for(int i = r; i >= 0; i--) {
				headPosition = i;
				if(i == 0) {
					System.out.print("Game over!!");
					return;
				}
			}
		}

		for(int i = 0; i < snakeSize; i++) {
			List<Integer> pos = new ArrayList<>();
			pos.add(r, headPosition+i);
			snake.add(pos);
		}
		//snake = {{r, headPosition}, {r, headPosition+1}, {r, headPosition+2}};
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = new int[10][10];
		int rowCount = board.length - 1;
		int colCount = board[0].length - 1;
		int snakeSize = 3;
		List<List<Integer>> snake = new ArrayList<>();
		for(int i = 0; i < snakeSize; i++) {
			List<Integer> pos = new ArrayList<>();
			pos.add(rowCount/2, colCount/2+i);
			snake.add(pos);
		}
		//int[][] snake = {{rowCount/2, colCount/2}, {rowCount/2, colCount/2 + 1}, {rowCount/2, colCount/2 + 2}};
		/*while(true) {
			Scanner sc = new Scanner();
		}*/
		move(board, snake, "UP");
	}

}
