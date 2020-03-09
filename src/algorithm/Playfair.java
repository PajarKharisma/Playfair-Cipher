package algorithm;

import part.CharElement;

import java.awt.*;
import java.util.ArrayList;

public class Playfair {

    public String encrypt(char[][] matrix, ArrayList<CharElement> listBigram){
        String chiper = "";
        for (CharElement bigram:listBigram) {
            Point pos1 = this.getPos(matrix, bigram.getChar1());
            Point pos2 = this.getPos(matrix, bigram.getChar2());

            if(pos1.y == pos2.y){
                chiper += matrix[(pos1.x + 1) % 5][pos1.y];
                chiper += matrix[(pos2.x + 1) % 5][pos2.y];
            }else if (pos1.x == pos2.x){
                chiper += matrix[pos1.x][(pos1.y + 1) % 5];
                chiper += matrix[pos2.x][(pos2.y + 1) % 5];
            } else {
                chiper += matrix[pos1.x][pos2.y];
                chiper += matrix[pos2.x][pos1.y];
            }
        }
        return chiper;
    }

    public String decrypt(char[][] matrix, ArrayList<CharElement> listBigram){
        String chiper = "";
        for (CharElement bigram:listBigram) {
            Point pos1 = this.getPos(matrix, bigram.getChar1());
            Point pos2 = this.getPos(matrix, bigram.getChar2());

            if(pos1.y == pos2.y){
                chiper += matrix[((pos1.x - 1) < 0) ? (pos1.x - 1) + 5 : pos1.x - 1][pos1.y];
                chiper += matrix[((pos2.x - 1) < 0) ? (pos2.x - 1) + 5 : pos2.x - 1][pos2.y];
            }else if (pos1.x == pos2.x){
                chiper += matrix[pos1.x][(pos1.y - 1) < 0 ? (pos1.y - 1) + 5 : pos1.y - 1];
                chiper += matrix[pos2.x][(pos2.y - 1) < 0 ? (pos2.y - 1) + 5 : pos2.y - 1];
            } else {
                chiper += matrix[pos1.x][pos2.y];
                chiper += matrix[pos2.x][pos1.y];
            }
        }
        return chiper;
    }

    private Point getPos(char[][] matrix, char character){
        for (int x=0; x<matrix.length; x++){
            for (int y=0; y<matrix[x].length; y++){
                if (matrix[x][y] == character){
                    return new Point(x,y);
                }
            }
        }
        return null;
    }
}
