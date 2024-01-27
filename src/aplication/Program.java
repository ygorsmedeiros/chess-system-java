package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();
		while (true) {
			try {
				
				UI.ClearScrean();
				UI.printBoard(chessMatch.getpieces());
				System.out.println();
				System.out.print("source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				System.out.println();
				System.out.print("target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch ( ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch ( InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
