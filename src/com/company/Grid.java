package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Grid {

    public static String[][] toArrayOfString(int[][] data) {
        String[][] res = new String[data.length][data[0].length];

        for (int i = 0; i != data.length; ++i) {
            for (int j = 0; j != data[i].length; ++j) {
                res[i][j] = data[i][j] + ""; //ou ""+data[i][j] le fait de concatener une chaine de caractere meme si elle est vide à un entier , convertir le tout en string.
            }
        }
        return res;
    }


    private static int maxLength(String[][] tab) {
        int res = 0;
        for (int i = 0; i != tab.length; i++) {
            for (int j = 0; j != tab[0].length; j++) {
                res = (res > tab[i][j].length()) ? res : tab[i][j].length();
            }
        }
        return res;
    }


    private static String [][] pad(String [][] tab, int taille){

    }


    public static void main(String[] args) {
        int[][] table = {{1, 21, 2}, {4, 5675, 6}};
        String[][] test = {{"1", "21", "2"}, {"4", "567", "6"}};
        String[][] tmt = toArrayOfString(table);
        int re = maxLength(tmt);
        System.out.println(re);
    }

}

