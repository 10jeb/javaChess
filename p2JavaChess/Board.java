import java.util.*;
public class Board {

    private static Board board_instance = null; 
    public List<BoardListener> boardListeners = new ArrayList<BoardListener>();
    private Piece[][] pieces = new Piece[8][8]; //coords for a Piece object

    private Board() {}
    
    public static Board theBoard() {
        if (board_instance == null){
            board_instance = new Board();
        }
        return board_instance;
    }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
	    int letterPos = (Character.getNumericValue(loc.charAt(0)) - 10);
        int numberPos = (Character.getNumericValue(loc.charAt(1)) - 1);
        //System.out.println("L/N Poss: " + letterPos + " " + numberPos);

        if ((letterPos > 7 || letterPos < 0)  || (numberPos > 7 || numberPos < 0)){
            throw new UnsupportedOperationException("Invalid location.");
        }

        if (pieces[letterPos][numberPos] != null) {
            return pieces[letterPos][numberPos];
        }
        return null;
    }

    public void addPiece(Piece p, String loc) {
        int letterPos = (Character.getNumericValue(loc.charAt(0)) - 10);
        int numberPos = (Character.getNumericValue(loc.charAt(1)) - 1);

	    if (pieces[letterPos][numberPos] != null || (letterPos > 7 || letterPos < 0)  || (numberPos > 7 || numberPos < 0)){
            throw new UnsupportedOperationException("A piece already exists at this location.");
        }
        pieces[letterPos][numberPos] = p;
    }

    public void movePiece(String from, String to) {
        int fromLetterPos = (Character.getNumericValue(from.charAt(0)) - 10);
        int fromNumberPos = (Character.getNumericValue(from.charAt(1)) - 1);
        int toLetterPos = (Character.getNumericValue(to.charAt(0)) - 10);
        int toNumberPos = (Character.getNumericValue(to.charAt(1)) - 1);
        Piece toBeCaptured = null;

        if (pieces[fromLetterPos][fromNumberPos] == null){
            throw new UnsupportedOperationException("There is no piece in the starting location to move.");
        }
        if ((toLetterPos > 7 || toLetterPos < 0)  || (toNumberPos > 7 || toNumberPos < 0)){
            throw new UnsupportedOperationException("One of the input locations is invalid.");
        }
        if (pieces[toLetterPos][toNumberPos].color() == pieces[fromLetterPos][fromNumberPos].color()){
            throw new UnsupportedOperationException("You cannot move a piece on top of a piece of the same color.");
        }

        Logger boardListener = new Logger();
        this.registerListener(boardListener);

        if (pieces[toLetterPos][toNumberPos] != null){
            toBeCaptured = pieces[toLetterPos][toNumberPos];
        }
        pieces[toLetterPos][toNumberPos] = pieces[fromLetterPos][fromNumberPos];
        pieces[fromLetterPos][fromNumberPos] = null;

        boardListener.onMove(from, to, pieces[fromLetterPos][fromNumberPos]);
        if (toBeCaptured != null){
            boardListener.onCapture(pieces[toLetterPos][toNumberPos], toBeCaptured);
        }
    }

    public void clear() {
        for (int i = 0; i < pieces.length; i++){
            for (int j = 0; j < pieces[0].length; j++){
                pieces[i][j] = null;
            }
        }
    }

    public void registerListener(BoardListener bl) {
        this.boardListeners.add(bl);
    }

    public void removeListener(BoardListener bl) {
        if (!this.boardListeners.contains(bl)){
            throw new UnsupportedOperationException("Cannot remove something that's not there.");
        }
        for (int i = 0; i < this.boardListeners.size(); i ++){
            if (this.boardListeners.get(i) == bl) {
                this.boardListeners.remove(this.boardListeners.get(i));
            }
        }
        System.out.println("All instances of BoardListener " + bl + " have been removed.");
    }

    public void removeAllListeners() {
        if (!this.boardListeners.isEmpty()){
            this.boardListeners.clear();
        }
        return;
    }

    public void iterate(BoardInternalIterator bi) {
        int decREDIX = 10;

        for (int i = 0; i < pieces.length; i++){
            for (int j = 0; j < pieces[0].length; j++){
                char letterAtPos = (char) (i + 97);
                char numberAtPos = Character.forDigit(i, decREDIX);
                StringBuilder sb = new StringBuilder();
                sb.append(letterAtPos);
                sb.append(numberAtPos);
                String loc = sb.toString();
                bi.visit(loc, pieces[i][j]);
                System.out.println("Piece: " + pieces[i][j] + " is at position " + loc);
            }
        }
    }

    //including this method actually made me write more code since I did not want to create a coords variable in 
    //methods where it was applicable and then assign letterPos = coords.get(0) since I felt that writing coords.get(0)
    //everywhere was a bit slower to be human-readable than letterPos and more keystrokes to type
    /*public ArrayList<Integer> locToCoords(String loc){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        int letterPos = (Character.getNumericValue(loc.charAt(0)) - 10);
        int numberPos = (Character.getNumericValue(loc.charAt(1)) - 1);
        coords.add(letterPos);
        coords.add(numberPos);
        return coords;
    }*/

    public String coordsToLoc(int xCoord, int yCoord){
        int decREDIX = 10;
        char x = (char)xCoord;
        char y = Character.forDigit(yCoord, decREDIX);
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.append(y);
        String loc = sb.toString();
        return loc;
    }
}