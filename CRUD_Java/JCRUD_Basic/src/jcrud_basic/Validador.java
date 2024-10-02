package jcrud_basic;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Validador {

    public static String validarLetras(String nombre) {
        if (!nombre.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Nombre no valido, intente de nuevo:");
        } else {
            return nombre;
        }
    }

    static int getInt(String Mensaje) {
        while (true) {
            System.out.print(Mensaje);
            Scanner sc = new Scanner(System.in);
            int resultado = 0;
            try {
                resultado = sc.nextInt();
                return resultado;
            } catch (InputMismatchException e) {
                System.out.println("Numero no valido, por favor solo introduzca un numero:");
            }
        }
    }

    static float getFloat(String Mensaje) {
        while (true) {
            System.out.print(Mensaje);
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            try {
                float resultado = Float.parseFloat(input);
                if (resultado < 0 || resultado > 20) {
                    throw new InputMismatchException("Nota no valida, intente de nuevo");
                }
                return resultado;
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Numero no valido, intente de nuevo:");
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
