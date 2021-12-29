package utils;
import java.util.*;

import java.lang.Math;

public class CreateCalcul {

    public static void main(String[] args){
        String[] operateur = {"/", "*", "-", "+"};
        int goodRep = 0;
        int rangeNb = 9;
        int rangeOp = 4;

        for (int i = 0; i < 10; i++){
            //initialisation des 3 chiffres aléatoire
            int nbRandom1 = (int) (Math.random()*rangeNb);
            int nbRandom2 = (int) (Math.random()*rangeNb);
            int nbRandom3 = (int) (Math.random()*rangeNb);

            //Récupération des 2 opérateurs aléatoirement
            int indexOp1 = (int) (Math.random()*rangeOp);
            int indexOp2 = (int) (Math.random()*rangeOp);
            String op1 = operateur[indexOp1];
            String op2 = operateur[indexOp2];

            //System.out.println(nbRandom1);
            //System.out.println(op1);
            //System.out.println(op2);
            String operation = nbRandom1 + " " + nbRandom2 + " " + op1 + " " + nbRandom3 + " " + op2;
            //System.out.println(operation);


        }
        //calcul();
    }

    public static void calcul(){
        Stack<String> op = new Stack<>();
        Stack<Integer> nb = new Stack<>();
        String[] operateur = {"/", "*", "-", "+"};

        for (int i = 0; i <= 29; i++) {

            int nbRandom = (int) (Math.random()*10);
            nb.push(nbRandom);

        }
        System.out.println(nb);
        for (int i = 0; i <= 19; i++) {

            int indexOp1 = (int) (Math.random()*4);
            String opRandom = operateur[indexOp1];
            op.push(opRandom);

        }
        System.out.println(op);

        for (int i = 0; i < 10; i++) {
            int nb1 = nb.pop();
            int nb2 = nb.pop();
            int nb3 = nb.pop();
            String op1 = op.pop();
            String op2 = op.pop();

            String operation = nb1 + op1 + nb2 + op2 + nb3;
            System.out.println(operation);

        }


    }

}
