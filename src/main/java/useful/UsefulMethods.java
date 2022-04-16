package main.java.useful;

public class UsefulMethods {
    public static int fact(int x) {
        if(x < 0){
            throw new IllegalArgumentException("please, put correct value: argument must be more than 0: " + x);
        }
        int res = 1;
        if(x != 0) {
            for (int i = 1; i <= x; i++) {
                res = res * (i);
            }
        }
        //System.out.println(res);
        return res;
    }
}
