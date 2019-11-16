package com.kevinx8;

import java.util.Scanner;

public class Main {
    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Function.sheets.set(0, "Sheet1"); //initialise with some sheets
        Function.sheets.set(1, "Sheet2");
        Function.sheets.set(2, "Sheet3");
        Function.lastadded = 3;
        Function.amountofsheets = 3;
        int resultn;
        boolean fargactive = false,sargactive =false,targactive =false,cmdactive = false,resultb;
        Scanner inme = new Scanner(System.in);
        System.out.print("Welcome to Excel for Java! type help for info or exit to leave\n>");
        String input = inme.nextLine(), resultS;
        assert input != null;
        while (!input.startsWith("exit")) {
            String farg=null,sarg=null,targ=" ";
            if (input.contains(" ")) {
                farg = input.substring(input.indexOf(" ") + 1);
                fargactive = true;
                if (input.substring(input.indexOf(farg)).contains(" ")) {
                    farg = input.substring(input.indexOf(" ") + 1, input.indexOf(" ", input.indexOf(" ") + 1));
                    sarg = input.substring(input.indexOf(" ", input.indexOf(farg)) + 1);
                    sargactive = true;
                    if (input.substring(input.indexOf(sarg)).contains(" ")) {
                        sarg = input.substring(input.indexOf(" ", input.indexOf(farg)) + 1, input.indexOf(" ", input.indexOf(" ", input.indexOf(farg)) + 1));
                        targ = input.substring(input.indexOf(" ", input.indexOf(sarg))+1);
                        targactive = true;
                        if ((input.substring(input.indexOf(targ)).contains(" "))) {
                            System.out.println("Too many arguments");
                            input = inme.nextLine();
                        }
                    }
                }
            }
        if (input.startsWith("add") && !fargactive) {
            resultb = Function.add();
            if (resultb) {
                System.out.printf("Added %s succesfully\n", Function.sheets.get(Function.lastadded - 1));
            } else {
                System.out.println("Failed to add new sheet\n");
            }
            cmdactive = true;
        }
            if (input.contentEquals("display") && !fargactive) {
            Function.Display();
            cmdactive = true;
        }
            if (input.startsWith("remove") && fargactive && !sargactive && !isNumeric(farg)) {
                resultn = Function.remove(farg);
                if (resultn != -1) {
                    System.out.printf("removed sheet at index %d succesfully\n",resultn);
                } else {
                    System.out.println("Error with remove function\n");
                }

             } else if (input.startsWith("remove") && fargactive && !sargactive && isNumeric(farg)) {
                resultS = Function.remove(Integer.parseInt(farg));
                if (resultS != null) {
                    System.out.printf("removed sheet %s successfully\n",resultS);
                } else {
                    System.out.println("Error with remove function\n");
                }
                cmdactive = true;
            }
            if (input.startsWith("move") && fargactive && sargactive) {
                if (isNumeric(farg) && isNumeric(sarg) && targ.equalsIgnoreCase("before")) {
                    resultS = Function.move(Integer.parseInt(farg),Integer.parseInt(sarg),true);
                    if (resultS != null) {
                        System.out.printf("Sheet Successfully moved before %s\n", resultS);
                    } else {
                        System.out.println("Could not Move");
                    }
                    cmdactive = true;
                } else if (targ.equalsIgnoreCase("before")) {
                    resultn = Function.move(farg,sarg,true);
                    if (resultn != -1) {
                        System.out.printf("Sheet Successfully moved before index %d\n",resultn);
                    } else {
                        System.out.println("Could not Move");
                    }
                    cmdactive = true;
                } else if (isNumeric(farg) && isNumeric(sarg) && !targactive) {
                    resultS = Function.move(Integer.parseInt(farg),Integer.parseInt(sarg),false);
                    if (resultS != null) {
                        System.out.printf("Sheet Successfully moved after %s\n",resultS);
                    } else {
                        System.out.println("Could not Move");
                    }
                    cmdactive = true;
                } else if (!targactive) {
                    resultn = Function.move(farg,sarg,false);
                    if (resultn != -1) {
                        System.out.printf("Sheet Successfully moved after index %d\n",resultn);
                    } else {
                        System.out.println("Could not Move");
                    }
                    cmdactive = true;
                }
            }
            if (input.startsWith("moveToEnd") && fargactive && !sargactive) {
                if (isNumeric(farg)) {
                    resultS = Function.moveToEnd(Integer.parseInt(farg));
                    if (resultS != null) {
                        System.out.printf("%s moved to end successfully\n", resultS);
                    } else {
                        System.out.println("MoveToEnd error has occured");
                    }
                } else {
                    resultn = Function.moveToEnd(farg);
                    if (resultn != -1) {
                        System.out.printf("Sheet at index %d moved to end Successfully\n",resultn);
                    } else {
                        System.out.println("MoveToEnd error has occured");
                    }
                }
                cmdactive = true;
            }
            if (input.startsWith("rename") && fargactive && !targactive) {
                resultn = Function.rename(farg,sarg);
                if (resultn != -1) {
                    System.out.printf("Renamed file at index %d Successfully\n",resultn);
                    } else {
                    System.out.println("Renamed failed");
                }
                cmdactive = true;
            }
            if (input.startsWith("sheetname") && fargactive && !sargactive) {
                resultS = Function.sheetName(Integer.parseInt(farg));
                if (resultS != null) {
                    System.out.printf("Sheet name at this index is %s\n",resultS);
                } else {
                    System.out.println("Sheet not found");
                }
                cmdactive = true;
            }
            if (input.startsWith("length") && !fargactive) {
                System.out.printf("SheetPad is %d long\n",Function.length());
                cmdactive = true;
            }
            if (input.startsWith("index") && !fargactive) {
                System.out.println("index is " + Function.index(farg));
                cmdactive = true;
            }
            if (input.startsWith("help")) {
                if (fargactive && !sargactive) {
                    Function.Help(farg);
                } else if (!fargactive) {
                    Function.Help("all");
                } else {
                    System.out.println("too many arguments");
                }
                cmdactive = true;
            }
            if (!cmdactive) {
                System.out.println("Invalid command entered");
            }
            cmdactive = false;
            sargactive =false;
            targactive = false;
            fargactive = false;
            System.out.print(">");
            input = inme.nextLine();
        }
    }
}
