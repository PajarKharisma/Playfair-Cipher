package subProcess;

import part.CharElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CharOperation {

    public boolean checkExist(ArrayList<Character> arr, char c){
        for (char i:arr) {
            if (i == c){
                return true;
            }
        }

        return false;
    }

    public String removeJ(String str){
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length; i++){
            chars[i] = (chars[i] == 'J') ? 'I' : chars[i];
        }
        return String.valueOf(Arrays.copyOf(chars, chars.length));
    }

    public String removeSpace(String str){
        char[] chars = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i=0; i<chars.length; i++){
            if (chars[i] != ' '){
                list.add(chars[i]);
            }
        }

        String result = "";
        for (char i:list) {
            result += i;
        }

        return result;
    }

    public String removeDuplicate(String str){
        char[] chars = str.toCharArray();
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            int j;
            for (j = 0; j < i; j++){
                if (chars[i] == chars[j]){
                    break;
                }
            }

            if (j == i){
                chars[index++] = chars[i];
            }
        }
        return String.valueOf(Arrays.copyOf(chars, index));
    }
}
