package controller;

import model.*;
import view.IoManager;

public class Control {
	private IoManager io;

	public Control() {
		io = new IoManager();
	}

	public void init() {
		Chess chess = new Chess();
		chess.putAllPieces();
		io.showMessage(chess.showBoard());
		chess.searchCells();
		chess.setScores();
		io.showMessage(chess.showMoves());
	}
}
