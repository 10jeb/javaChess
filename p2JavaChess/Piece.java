import java.util.*;

abstract public class Piece {

    public Color color;
    public static HashMap<Character,PieceFactory> pieceTypesMap = new HashMap<Character,PieceFactory>();

    public static void registerPiece(PieceFactory pf) {
        pieceTypesMap.put(pf.symbol(), pf);
    }

    public static Piece createPiece(String name) {
        if ((name.charAt(0)) == 'b') {
            return pieceTypesMap.get(name.charAt(1)).create(Color.BLACK);
        } else if ((name.charAt(0)) == 'w') {
            return pieceTypesMap.get(name.charAt(1)).create(Color.WHITE);
        }
        throw new UnsupportedOperationException("Piece must be black or white");
    }

    public Color color() {
        return color;
    }

    abstract public String toString();

    abstract public List<String> moves(Board b, String loc);
}