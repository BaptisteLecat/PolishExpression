package utils;

import java.util.ArrayList;
import java.util.Stack;

public class GetRandomPolishExpression {

    //return polishExpression in []
    public static String[] getExpression() {
        int randomInt = (int) (Math.random() * (9 + 1));
        int randomInt2 = (int) (Math.random() * (9 + 1));

        String[] polishInt = {Integer.toString(randomInt), Integer.toString(randomInt2)};


        String[] polishExpression = {polishInt[0], polishInt[1], Operators.getOperator()};
        return polishExpression;
    }
    //return result of polishExpression
    public static String calculPolish(String[] polishExpression){
        String res;
        Stack<String> stackPolish = new Stack<String>();
        for(String val : polishExpression){
            int calcul;
            switch(val) {
                case "+":
                    calcul = Integer.parseInt(stackPolish.pop()) + Integer.parseInt(stackPolish.pop());
                    res = Integer.toString(calcul);
                    stackPolish.push(res);
                    break;

                case "-":
                    calcul = Integer.parseInt(stackPolish.pop()) - Integer.parseInt(stackPolish.pop());
                    res = Integer.toString(calcul);
                    stackPolish.push(res);
                    break;

                case "/":
                    if(checkIfDividerWorks(polishExpression)){
                        calcul = Integer.parseInt(stackPolish.pop()) / Integer.parseInt(stackPolish.pop());
                        res = Integer.toString(calcul);
                        stackPolish.push(res);
                    }
                    else{
                        //remplacer expression error par new expression
                        polishExpression = getExpression();
                        calcul = Integer.parseInt(stackPolish.pop()) / Integer.parseInt(stackPolish.pop());
                        res = Integer.toString(calcul);
                        stackPolish.push(res);


                    }


                    break;
                case "*":
                    calcul = Integer.parseInt(stackPolish.pop()) * Integer.parseInt(stackPolish.pop());
                    res = Integer.toString(calcul);
                    stackPolish.push(res);

                    break;
                default:
                    System.out.println(val);
                    stackPolish.push(val);
                    break;
            }
        }
        return stackPolish.peek();
    }
        static boolean checkIfDividerWorks(String[] expression) {
            Stack<String> stackValue = new Stack<String>();
            boolean checkIfWorks = false;
            for(String val: expression){
                //check if divide is possible
                if(Operators.isDivider(val)&&Integer.parseInt(stackValue.peek())!=0){
                    checkIfWorks = true;
                }
                else{
                    stackValue.push(val);
                }
            }
            return checkIfWorks;
        }

/*
check si nombre
    si nbr stack.push
    sinon check which operator
        use operateur with 2 stack.pop
        */

}

