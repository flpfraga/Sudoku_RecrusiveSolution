
public class Maze {

	public static boolean verificaLinha(int[] maze, int index, int insert) {
		int linha = index / 9;
		linha = linha * 9;
		for (int c = 0; c < 9; c++) {
			if (maze[linha + c] == insert) {
//				System.out.println("invalido linh");
				return false;
			}
		}
		return true;
	}

	public static boolean verificaColuna(int[] maze, int index, int insert) {
		int coluna = index % 9;
		for (int c = 0; c < 9; c++) {
			if (maze[coluna] == insert) {
//				System.out.println("invalido coluna");
				return false;
			}
			coluna += 9;
		}
		return true;
	}

	public static boolean verificaQuadrande(int[] maze, int index, int insert) {
		int linha = index / 9;
		int coluna = index % 9;
		int quadro = 0;
		if (linha <= 2) {
			if (coluna <= 2) {
				quadro = 0;
			} else if (coluna > 2 && coluna <= 5) {
				quadro = 3;
			} else if (coluna > 5) {
				quadro = 6;
			}
		} else if (linha > 2 && linha <= 5) {
			if (coluna <= 2) {
				quadro = 27;
			} else if (coluna > 2 && coluna <= 5) {
				quadro = 30;
			} else if (coluna > 5) {
				quadro = 33;
			}
		} else if (linha > 5) {
			if (coluna <= 2) {
				quadro = 54;
			} else if (coluna > 2 && coluna <= 5) {
				quadro = 57;
			} else if (coluna > 5) {
				quadro = 60;
			}
		}
//		System.out.println("quadro selecionado " + quadro);
		for (int c = 0; c < 9; c++) {
			if (maze[quadro] == insert) {
//				System.out.println("invalido quadro " + quadro);
				return false;
			}
			if (c % 3 == 2) {
				quadro += 6;
			}
			quadro++;
		}
		return true;
	}

	public static void printMaze(int[] maze) {
		for (int c = 0; c < 81; c++) {
			if (c % 9 == 0 && c > 0) {
				System.out.print("|");
				System.out.println();
			}
			if (maze[c] == 0) {
				System.out.print("|   ");
			} else {
				System.out.print("| " + maze[c] + " ");
			}

		}
	}

	public static int[] resolveSudoku(int[] maze, int index, int insert) {
		if (index >= 81) {
			System.out.println("Soluçao encontrada");
			printMaze(maze);
			return maze;
		}
		if (insert <= 9) {

			if (maze[index] == 0) {
				if (verificaColuna(maze, index, insert) && verificaLinha(maze, index, insert)
						&& verificaQuadrande(maze, index, insert)) {
					maze[index] = insert;
					maze = resolveSudoku(maze, (index + 1), 1);
				}

				maze[index] = 0;
				return resolveSudoku(maze, index, (insert + 1));

			} else {
				return resolveSudoku(maze, (index + 1), 1);
			}

		}
		return maze;

	}

	public static void main(String[] args) {
		int maze[] = new int[81];

		maze[0] = 5;
		maze[1] = 3;
		maze[4] = 7;
		maze[9] = 6;
		maze[12] = 1;
		maze[13] = 9;
		maze[14] = 5;
		maze[19] = 9;
		maze[20] = 8;
		maze[25] = 6;
		maze[27] = 8;
		maze[31] = 6;
		maze[35] = 3;
		maze[36] = 4;
		maze[45] = 7;
		maze[39] = 8;
		maze[41] = 3;
		maze[44] = 1;
		maze[49] = 2;
		maze[53] = 6;
		maze[55] = 6;
		maze[60] = 2;
		maze[61] = 8;
		maze[66] = 4;
		maze[67] = 1;
		maze[68] = 9;
		maze[71] = 5;
		maze[76] = 8;
		maze[79] = 7;
		maze[80] = 9;

		maze = resolveSudoku(maze, 0, 1);

	}

}
