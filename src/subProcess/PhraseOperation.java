package subProcess;

import part.CharElement;

import java.util.ArrayList;

public class PhraseOperation {

    private char[][] keywordMatrix;
    private char[] keyword;
    private ArrayList<Character> closeChar;
    private CharOperation charOperation;

    public PhraseOperation(){
        this.charOperation = new CharOperation();
        this.keywordMatrix = new char[5][5];
    }

    public void setKeyword(String str) {
        str = str.toUpperCase();
        str = charOperation.removeSpace(str);
        str = charOperation.removeJ(str);
        str = charOperation.removeDuplicate(str);
        this.keyword = str.toCharArray();
    }

    public char[][] getMatrix(){
        this.closeChar = new ArrayList<>();
        int ascii = 65;
        int index = 0;
        for (int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(index < this.keyword.length){
                    this.keywordMatrix[i][j] = this.keyword[index];
                    closeChar.add(this.keyword[index]);
                    index++;
                } else {
                    while (charOperation.checkExist(closeChar, (char)ascii)){
                        ascii++;
                    }
                    if(ascii == 74){
                        this.keywordMatrix[i][j] = (char)(ascii+1);
                        ascii += 2;
                    } else {
                        this.keywordMatrix[i][j] = (char)(ascii);
                        ascii++;
                    }
                }
            }
        }
        return this.keywordMatrix;
    }

    public ArrayList<CharElement> getPhrase(String str){
        ArrayList<CharElement> list = new ArrayList<>();
        str = str.toUpperCase();
        str = charOperation.removeSpace(str);
        char[] chars = str.toCharArray();
        int index = 0;
        do {
            if (index == chars.length-1){
                list.add(new CharElement(chars[index], 'Z'));
                index++;
            } else {
                if (chars[index] != chars[index+1]){
                    list.add(new CharElement(chars[index], chars[index+1]));
                    index += 2;
                }else{
                    list.add(new CharElement(chars[index], 'Z'));
                    index++;
                }
            }
        }while (index < chars.length);
        return list;
    }
}
