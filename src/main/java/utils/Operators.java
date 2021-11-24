package utils;

import java.util.ArrayList;

public class Operators {


    public static ArrayList<String> getOperators(){
        ArrayList<String> operators = new ArrayList<String>();
        operators.add("-");
        operators.add("+");
        operators.add("/");
        operators.add("*");
        return operators;

    }
    public static String getOperator(){

        String randomOperator = getOperators().get((int) (Math.random() * (3 + 1)));
        return randomOperator;
    }

    public static boolean isDivider(String operator){
        boolean isDivider = false;
        String divide = "/";
        if(divide.equals(operator))
            isDivider=true;

        return isDivider;
    }
}