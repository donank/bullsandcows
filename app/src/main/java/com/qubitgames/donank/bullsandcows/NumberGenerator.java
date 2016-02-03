package com.qubitgames.donank.bullsandcows;

import java.util.Random;


public class NumberGenerator {
    public static String number_generate(){

        Random gen= new Random();
        int target;
        while(hasDupes(target= (gen.nextInt(9000) + 1000)));
        String targetStr;
        targetStr = target +"";
        return targetStr;
    }

    public static boolean hasDupes(int num){
        boolean[] digs = new boolean[10];
        while(num > 0){
            if(digs[num%10]) return true;
            digs[num%10] = true;
            num/= 10;
        }
        return false;
    }

}