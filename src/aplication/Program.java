package aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while (!chessMatch.getCheckMate()) {
			try {
				
				UI.ClearScrean();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.ClearScrean();
				UI.printBoard(chessMatch.getpieces(), possibleMoves);
				
				System.out.println();
				System.out.print("target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if(captured != null) {
					captured.add(capturedPiece);
				}
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
		
		UI.ClearScrean();
		UI.printMatch(chessMatch, captured);
	}

}
