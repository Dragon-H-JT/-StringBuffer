package digit;

import java.util.Arrays;
import java.util.Scanner;

public class TestNumber {
    public static void main(String[] args) {
        String[] Str = new String[100];
        char[] c = new char[2];
        int star = '0';
        int end = 'Z' + 1;
        int count = 0;
        for (int i = 0; i < Str.length; i++) {
            for (int j = 0; j < c.length; j++) {
                while (true) {
                    char c1 = (char) (Math.random() * (end - star) + star);
                    if (Character.isDigit(c1) || Character.isLetter(c1)) {
                        c[j] = c1;
                        break;
                    }
                }
            }
            String result = new String(c);
            Str[i] = result;
            System.out.print(Str[i] + " ");
            if (i != 0 && i % 20 == 19) {
                System.out.println();
            }
        }
        for (int i = 0; i < Str.length; i++) {
            for (int j = i + 1; j < Str.length; j++) {
                if (Str[i].equalsIgnoreCase(Str[j])) {
                    putArray(Str[i]);
                    break;
                }
            }
        }
        System.out.printf("总共有 %d种重复的字符串%n", pos);
        if (pos != 0) {
            System.out.println("分别是：");
            for (int i = 0; i < pos; i++) {
                System.out.print(foundstr[i] + " ");
            }
        }
    }
    static String[] foundstr = new String[100];
    static int pos;
    private static void putArray(String s){
        for(int i = 0; i < pos;i++){
            if(foundstr[i].equalsIgnoreCase(s)){
                return ;
            }
        }
        foundstr[pos++] = s;
    }
}
