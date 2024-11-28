package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void Ejercicio1(){

        Random random = new Random();
        Scanner entrada = new Scanner(System.in);

        boolean bingo= true , linea  = true;
        int cant;
        cant = random.nextInt(31)+10;

        String[][] fila = new String[3][3];
        Integer[][] carton = new Integer[3][3];
        Integer[] bolas = new Integer[cant];

        for (int i=0 ; i < cant ; i++){

            bolas[i]=random.nextInt(90)+1;

        }
            Arrays.sort(bolas);

        boolean aux;
        aux = false;

        while (!aux) {
            aux = true;

            for (int j = 0; j < bolas.length-1; j++) {
                if (Objects.equals(bolas[j], bolas[j + 1])) {
                    bolas[j + 1] = random.nextInt(90) + 1;
                    aux = false;
                }
            }

            Arrays.sort(bolas);
        }
        System.out.println(cant+" bolas extraidas hasta ahora "+ Arrays.toString(bolas));

        System.out.println("*** Introduce los datos del cartón ******");

        for (int i = 0; i < carton.length; i++) {

            System.out.println("Fila " + (i+1) + ": ");
            String numeros = entrada.next();
            if (!numeros.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}")) {
                System.out.println("ERROR.Números introducidos no siguen el formato correcto (N-N-N)");
                System.exit(1);
            } else {
                fila[i] = numeros.split("-");
            }
        }

        System.out.println("Datos del cartón introducido: ");
        for (int i=0; i < carton.length; i++){
            for (int j = 0; j < carton[i].length; j++) {
                carton[i][j] = Integer.valueOf(fila[i][j]);
                System.out.print(carton[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("PREMIOS: ");

        for (int i = 0; i < carton.length; i++){
            for (int j = 0; j < carton[i].length; j++) {
                if (Arrays.asList(bolas).contains(carton[i][j])){

                }
                else {

                    bingo=false;
                }
            }
        }

        if (bingo){
            System.out.println("HAY BINGO!!!!");
        }
        else {
            System.out.println("NO HAY BINGO....");
        }

        for (int i = 0; i < carton.length; i++) {
            linea=true;
            System.out.print("Fila"+ (i+1) + ":");
            for (int j = 0; j < carton[i].length; j++) {
                if (Arrays.asList(bolas).contains(carton[i][j])) {

                }
                else {
                    linea = false;
                }
            }
            if (linea){
                System.out.println("CORRECTA!!");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
