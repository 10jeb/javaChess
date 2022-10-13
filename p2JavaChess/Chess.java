import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Chess {
    public static void main(String[] args) {
	if (args.length != 2) {
	    System.out.println("Usage: java Chess layout moves");
	}
	Piece.registerPiece(new KnightFactory());
	Piece.registerPiece(new KingFactory());
	Piece.registerPiece(new QueenFactory());
	Piece.registerPiece(new BishopFactory());
	Piece.registerPiece(new RookFactory());
	Piece.registerPiece(new PawnFactory());
	Board.theBoard().registerListener(new Logger());
	// args[0] is the layout file name
	// args[1] is the moves file name
	//run with java Chess layout1 moves1
	try {
		BufferedReader layoutReader = new BufferedReader(new FileReader(args[0]));

		String currLine = null;
		while ((currLine = layoutReader.readLine()) != null) {
			if (currLine.charAt(0) == '#') {
				continue;
			}
			System.out.println(currLine);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		BufferedReader movesReader = new BufferedReader(new FileReader(args[1]));
		String currLine = null;
		while ((currLine = movesReader.readLine()) != null) {
			if (currLine.charAt(0) == '#') {
				continue;
			}
			//initialize x and such here == lines().add() or smt
			System.out.println(currLine);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}

	// Leave the following code at the end of the simulation:
	System.out.println("Final board:");
	Board.theBoard().iterate(new BoardPrinter());
    }
}