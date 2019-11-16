package com.kevinx8;

 public class test {
    public static void main(String[] args) {
        String input = "move Sheet4 Sheet2 before";
        System.out.println(input.substring(input.indexOf(" "), input.indexOf(" ",5)));
    }
//      if (isNumeric(input.substring(input.indexOf(" "),input.indexOf(input.indexOf(" "), input.indexOf(" ")+1))) && input.lastIndexOf("before") != -1) {
//          arg1n = Integer.parseInt(input.substring(input.indexOf(" "),input.indexOf(input.indexOf(" "), input.indexOf(" ")+1)));
//          arg2n = Integer.parseInt(input.substring(input.indexOf(" ",arg1n),input.indexOf(" ",input.indexOf(" ",arg1n) + 1)));
//          Function.move(arg1n,arg2n,true);
//      } else if (input.lastIndexOf("before") != -1){
//          arg1s = input.substring(input.indexOf(" "),input.indexOf(input.indexOf(" "), input.indexOf(" ")+1));
//          arg2s = input.substring(input.indexOf(" ",input.indexOf(arg1s)),input.indexOf(" ",input.indexOf(" ",input.indexOf(arg1s) + 1)));
//          Function.move(arg1s,arg2s,true);
//      } else if (isNumeric(input.substring(input.indexOf(" "),input.indexOf(input.indexOf(" "), input.indexOf(" ")+1)))) {
//          arg1n = Integer.parseInt(input.substring(input.indexOf(" "),input.indexOf(input.indexOf(" "), input.indexOf(" ")+1)));
//          arg2n = Integer.parseInt(input.substring(input.indexOf(" ",arg1n)));
//          Function.move(arg1n,arg2n,false);
//      } else {
//          arg1s = input.substring(input.indexOf(" "),input.indexOf(input.indexOf(" "), input.indexOf(" ")+1));
//          arg2s = input.substring(input.indexOf(" ",input.indexOf(arg1s)));
//          Function.move(arg1s,arg2s,false);
//      }
//  }
  }
