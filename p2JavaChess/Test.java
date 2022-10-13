public class Test {

    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

    public static void test1() {
	Board b = Board.theBoard();
	Piece.registerPiece(new KnightFactory());
    Piece.registerPiece(new KingFactory());
    Piece.registerPiece(new BishopFactory());
    Piece.registerPiece(new RookFactory());
    Piece.registerPiece(new QueenFactory());
    Piece.registerPiece(new PawnFactory());
	Piece p = Piece.createPiece("wn");
    Piece king = Piece.createPiece("bk");
    Piece bishop = Piece.createPiece("bb");
    Piece rook = Piece.createPiece("wr");
    Piece queen = Piece.createPiece("bq");
    Piece pawn = Piece.createPiece("bp");
    Piece p2 = Piece.createPiece("wp");
	b.addPiece(p, "b6");
    b.addPiece(king, "h8");
    b.addPiece(bishop, "h2");
	//assert b.getPiece("a3") == p;
    //king.moves(b, "f5");
    //p.moves(b, "e5");
    //bishop.moves(b, "e5");
    //rook.moves(b, "d5");
    //queen.moves(b,"a1");
    pawn.moves(b, "a7");
    p2.moves(b, "a2");
   //b.coordsToLoc(3, 4); works to print d4
    }
    
    public static void main(String[] args) {
	test1();
    }

}