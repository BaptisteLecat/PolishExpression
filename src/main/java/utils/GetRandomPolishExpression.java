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
                    int val1= Integer.parseInt(stackPolish.pop());
                    int val2= Integer.parseInt(stackPolish.pop());
                    calcul = val2 - val1;
                    if (calcul <0){
                        res = "-"+ Integer.toString(calcul);
                    }
                    res = Integer.toString(calcul);

                    stackPolish.push(res);
                    break;

                case "/":
                    if(checkIfDividerWorks(polishExpression)){
                        float val3= Integer.parseInt(stackPolish.pop());
                        float val4= Integer.parseInt(stackPolish.pop());
                        float calculD;
                        if(val3!=0 && val4!=0){
                            calculD = val4 / val3;

                            res = Float.toString(calculD);
                            stackPolish.push(res);
                        }
                      else{
                            //remplacer expression error par new expression
                            polishExpression = getExpression();
                            calculPolish(polishExpression);
                            System.out.println("génération new calc 1");
                            //res = Integer.toString(calcul);
                            //stackPolish.push(res);
                        }
                    }
                    else{
                        //remplacer expression error par new expression
                        polishExpression = getExpression();
                        calculPolish(polishExpression);
                        System.out.println("génération new calc 2");
                        //calcul = Integer.parseInt(stackPolish.pop()) / Integer.parseInt(stackPolish.pop());
                       // res = Integer.toString(calcul);
                      //  stackPolish.push(res);
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
      /* static boolean checkIfDividerWorks(String[] expression) {
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
        String resultatCalcul = stackPolish.peek();
        return resultatCalcul;
    }*/


    static boolean checkIfDividerWorks(String[] expression) {
        Stack<String> stackValue = new Stack<String>();
        boolean checkIfWorks = false;
        for(String val: expression){
            //check if divide is possible
            if(Operators.isDivider(val)&&Integer.parseInt(stackValue.peek())!=0){
                checkIfWorks = true;
            }
            if(val=="0"){
                checkIfWorks = false;
            }
            else{
                stackValue.push(val);
            }
        }
        return checkIfWorks;
    }


    /*public void setPolishExpression() {
        this.polishExpression = polishExpression;
    }*/



/*
check si nombre
    si nbr stack.push
    sinon check which operator
        use operateur with 2 stack.pop
        */

}

