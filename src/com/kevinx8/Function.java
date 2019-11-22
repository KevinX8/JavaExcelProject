package com.kevinx8;

public class Function {
    public static String[] sheets = new String[256];
    public static int lastadded = 0, amountofsheets = 0;

    public static boolean add() {
        if (amountofsheets <= 256) {
            sheets[lastadded] = "Sheet" + (lastadded + 1);
            amountofsheets++;
            lastadded++;
            return true;
        } else {
            return false;
        }
    }
    public static int remove(String sheetName) {

    }
    public static int move(String from, String to,)

    public static int index(String sheetName) {
        int i = 0;
        int index = 0;
        for (i = 0; i < sheets.length; i++) {
            if (sheets[i].equalsIgnoreCase(sheetName)) {
                index = i;
                return index;
            } else {
                index = -1;
            }
        }
        return index;
    }
}
