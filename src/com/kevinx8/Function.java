package com.kevinx8;

import java.util.Arrays;

public class Function {
    public static String[] sheets = new String[256];
    public static int lastadded = 0, amountofsheets = 0;

    public static boolean add() {
        if (amountofsheets <= 256) {
            while (Function.index("Sheet" + (lastadded + 1)) != -1) {
                lastadded++;
            }
            sheets[amountofsheets] = "Sheet" + (lastadded + 1);
            amountofsheets++;
            lastadded++;
            return true;
        } else {
            return false;
        }
    }
    public static int move(String from, String to,boolean before) {
        return -1;

    }
    public static String move(int from, int to, boolean before) {
        return null;

    }
    public static int moveToEnd(String from) {
        return -1;

    }
    public static String moveToEnd(int from) {
        return null;

    }
    public static int rename(String currentName, String newName) {
        return -1;

    }
    public static String sheetName(int index){
        if(index >= 0 && index < sheets.length){
            return sheets[index];
        } else {
            return null;
        }
    }

    public static int index(String sheetName){
        int i;
        int index = -1;
        for(i = 0; i < amountofsheets; i++){
            if (sheets[i].equalsIgnoreCase(sheetName)) {
                return i;
            }
        }
        return -1;
    }

    public static void Display(){
        System.out.println(Arrays.asList(sheets));
    }

    public static String remove(int index){
        int i;
        String temp = sheetName(index);
        if (amountofsheets > 1 && Function.sheetName(index) !=null) {
            for(i=index; i < amountofsheets; i++ ) {
                sheets[i] = sheets[i+1];
            }
            amountofsheets--;
            sheets[i+1] = null;
            return temp;
        }else {
            return null;
        }
    }
    public static int remove(String sheetName) {
        return -1;

    }
    public static int length() {
        return amountofsheets;
    }
    public static void Help(String arg) {

    }
}
