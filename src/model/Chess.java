package model;

public class Chess {
	public static int TAM = 8;
	private Cell board[][];
	private Cell moves[];

	// Crear la matriz
	public Chess() {
		moves = new Cell[8];
		for (int i = 0; i < moves.length; i++) {
			moves[i] = null;
		}
		board = new Cell[TAM][TAM];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = new Cell(i, j, ' ', 0);
			}
		}
	}

	// Posicionar fichas
	private void putPieces(char type, int number) {
		int x, y;
		for (int i = 0; i < number; i++) {
			do {
				x = this.getRandomNumber(0, 8);
				y = this.getRandomNumber(0, 8);
			} while (board[x][y].getType() != ' ');
			board[x][y].setType(type);
			;
		}
	}

	public void putAllPieces() {
		this.putPieces('C', 1);
		this.putPieces('A', 4);
		this.putPieces('E', 4);
	}

	// Analizar Jugadas
	private Cell SearchHorse() {
		Cell horseCell = null;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j].getType() == 'C') {
					horseCell = new Cell(i, j);
				}
			}
		}
		return horseCell;
	}

	private boolean isValidMove(int x, int y) {
		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}

	public void searchCells() {

		int x = this.SearchHorse().getX();
		int y = this.SearchHorse().getY();
		int i = 0;

		int[][] possibleMoves = { { x - 2, y - 1 }, { x - 1, y - 2 }, { x + 1, y - 2 }, { x + 2, y - 1 },
				{ x + 2, y + 1 }, { x + 1, y + 2 }, { x - 1, y + 2 }, { x - 2, y + 1 } };
		for (int[] move : possibleMoves) {
			int newX = move[0];
			int newY = move[1];

			if (isValidMove(newX, newY) && board[newX][newY].getType() != 'A') {
				moves[i] = board[newX][newY];
				i++;
			}
		}
	}

	public void setScores() {
		for (int i = 0; i < moves.length; i++) {
			if (moves[i] != null) {
				if (moves[i].getType() == ' ') {
					moves[i].setScore(5);
				} else if (moves[i].getType() == 'E') {
					moves[i].setScore(10);
				}
			}
		}
	}

	// Mostrar el tablero
	public String showBoard() {

		// Parte Superior
		String showMatrix = "    A   B   C   D   E   F   G   H\n";
		showMatrix += "  ╔";
		for (int k = 0; k < board.length - 1; k++) {
			showMatrix += "═══╦";
		}
		showMatrix += "═══╗\n";

		// Numeros/Objetos
		for (int i = 0; i < board.length; i++) {
			showMatrix += (8 - i) + " ║";
			for (int j = 0; j < board.length; j++) {
				showMatrix += " " + board[i][j].getType() + " ║";
			}
			if (i < board.length - 1) {
				showMatrix += "\n  ╠";
				for (int j = 0; j < board.length - 1; j++) {
					showMatrix += "═══╬";
				}
				showMatrix += "═══╣\n";
			}
		}
		// Parte inferior
		showMatrix += "\n  ╚";
		for (int a = 0; a < board.length - 1; a++) {
			showMatrix += "═══╩";
		}
		showMatrix += "═══╝";

		return showMatrix;
	}

	// Mostrar Jugadas
	public String showMoves() {
		String showMoves = "";
		int i = 0;
		while (i < moves.length && moves[i] != null) {
			showMoves+= "Jugada: " + (8-moves[i].getX());
			
			switch(moves[i].getY()) {
			case 0:
				showMoves+='A';
				break;
			case 1:
				showMoves+='B';
				break;
			case 2:
				showMoves+='C';
				break;
			case 3:
				showMoves+='D';
				break;
			case 4:
				showMoves+='E';
				break;
			case 5:
				showMoves+='F';
				break;
			case 6:
				showMoves+='G';
				break;
			case 7:
				showMoves+='H';
				break;
			}
			showMoves+= " Puntaje: "+moves[i].getScore();
			showMoves+="\n";
			i++;
		}
		showMoves+= "Con " + i +" Jugadas Posibles"; 
		return showMoves;
	}

	// Metodo random
	public int getRandomNumber(int lower, int upper) {
		int randomNumber = (int) (Math.random() * (upper - lower)) + lower;
		return randomNumber;
	}

	// Gets y Sets
	public static int getTAM() {
		return TAM;
	}

	public static void setTAM(int tAM) {
		TAM = tAM;
	}

	public Cell[][] getBoard() {
		return board;
	}

	public void setBoard(Cell[][] board) {
		this.board = board;
	}

	public Cell[] getMoves() {
		return moves;
	}

	public void setMoves(Cell[] moves) {
		this.moves = moves;
	}

}
