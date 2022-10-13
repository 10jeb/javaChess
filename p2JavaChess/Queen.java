import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) { color = c; }
    // implement appropriate methods

    public String toString() {
        String shade = null;
        String pieceType = "q";
        if (color == Color.BLACK){
            shade = "b";
        } else {
            shade = "w";
        }
        return (shade + pieceType);
    }

    public List<String> moves(Board b, String loc) {
        List<String> possibleMoves = new ArrayList<String>();
        int letterPos = (Character.getNumericValue(loc.charAt(0)) + 87); 
        int numberPos = (Character.getNumericValue(loc.charAt(1)));
        int i = 1;
        int j = 1;
        int k = 1;
        int l = 1;
        int m = 1;
        int n = 1;
        int p = 1;
        int q = 1;

        //rook movement
        while ((numberPos + i) <= 8){
            int fartherY = numberPos + i;
            if ((b.getPiece(b.coordsToLoc(letterPos, fartherY)) != null) && (b.getPiece(b.coordsToLoc(letterPos, fartherY)).color() != this.color())){
                break;
            }
            if ((letterPos <= 104) && (fartherY <= 8)){
                possibleMoves.add(b.coordsToLoc(letterPos, fartherY));
            }
            i++;
        }
        while ((letterPos + k) <= 104){
            int fartherX = letterPos + k;
            if ((b.getPiece(b.coordsToLoc(fartherX, numberPos)) != null) && (b.getPiece(b.coordsToLoc(fartherX, numberPos)).color() != this.color())){
                break;
            }
            if ((fartherX <= 104) && (numberPos <= 8)){
                possibleMoves.add(b.coordsToLoc(fartherX, numberPos));
            }
            k++;
        }
        while ((numberPos - j) >= 1){
            int lesserY = numberPos - j;
            if ((b.getPiece(b.coordsToLoc(letterPos, lesserY)) != null) && (b.getPiece(b.coordsToLoc(letterPos, lesserY)).color() != this.color())){
                break;
            }
            if ((letterPos >= 97) && (lesserY >= 1)){
                possibleMoves.add(b.coordsToLoc(letterPos, lesserY));
            }
            j++;
        }
        while ((letterPos - l) >= 97){
            int lesserX = letterPos - l;
            if ((b.getPiece(b.coordsToLoc(lesserX, numberPos)) != null) && (b.getPiece(b.coordsToLoc(lesserX, numberPos)).color() != this.color())){
                break;
            }
            if ((lesserX >= 97) && (numberPos >= 1)){
                possibleMoves.add(b.coordsToLoc(lesserX, numberPos));
            }
            l++;
        }
        //bishop movement
        while (((numberPos + m) <= 8) && ((letterPos + m) <= 104)){
            int farX = letterPos + m;
            int farY = numberPos + m;
            if ((b.getPiece(b.coordsToLoc(farX, farY)) != null) && (b.getPiece(b.coordsToLoc(farX, farY)).color() != this.color())){
                break;
            }
            if ((farX <= 104) && (farY <= 8)){
                possibleMoves.add(b.coordsToLoc(farX, farY));
            }
            m++;
        }
        while (((numberPos + p) <= 8) && ((letterPos - p) >= 97)){
            int farY = numberPos + p;
            int lesX = letterPos - p;
            if ((b.getPiece(b.coordsToLoc(lesX, farY)) != null) && (b.getPiece(b.coordsToLoc(lesX, farY)).color() != this.color())){
                break;
            }
            if ((lesX >= 97) && (farY <= 8)){
                possibleMoves.add(b.coordsToLoc(lesX, farY));
            }
            p++;
        }
        while (((numberPos - n) >= 1) && ((letterPos + n) <= 104)){
            int moreX = letterPos + n;
            int lessY = numberPos - n;
            if ((b.getPiece(b.coordsToLoc(moreX, lessY)) != null) && (b.getPiece(b.coordsToLoc(moreX, lessY)).color() != this.color())){
                break;
            }
            if ((moreX <= 104) && (lessY >= 1)){
                possibleMoves.add(b.coordsToLoc(moreX, lessY));
            }
            n++;
        }
        while (((numberPos - q) >= 1) && ((letterPos - q) >= 97)){
            int lessY = numberPos - q;
            int lessX = letterPos - q;
            if ((b.getPiece(b.coordsToLoc(lessX, lessY)) != null) && (b.getPiece(b.coordsToLoc(lessX, lessY)).color() != this.color())){
                break;
            }
            if ((lessX >= 97) && (lessY >= 1)){
                possibleMoves.add(b.coordsToLoc(lessX, lessY));
            }
            q++;
        }
        return possibleMoves;
    }

}