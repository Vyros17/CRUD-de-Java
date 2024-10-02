package jcrud_basic;

import java.util.Scanner;
import java.util.ArrayList;

public class JCRUD_Basic {

    public static void main(String[] args) {
        ArrayList<Estudiante> lista = new ArrayList<>();
        int opcion;
        while (true) {
            String mensaOpcion = "Eliga la opcion de su preferencia\n1)Agregar\n2)Modificar\n3)Eliminar\n4)Visualizar todo\n5)Visualizar estudiante\n6)Salir\n>";
            opcion = Validador.getInt(mensaOpcion);
            if (opcion == 6) {
                System.out.println("Hasta luego.");
                break;
            }
            switch (opcion) {
                case 1:
                    lista.add(agregar());
                    break;
                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes guardados");
                    } else {
                        System.out.print("Indique la cedula del estudiante:");
                        String ci = getString();
                        boolean val = false;
                        for (int i = 0; i < lista.size(); i++) {
                            Estudiante estudiante = lista.get(i);
                            if (ci.equals(estudiante.getCi())) {
                                String mensaEdad = "Indique la edad del estudiante:";
                                int edad = Validador.getInt(mensaEdad);
                                String mensaNota = "Indique la nota del estudiante. Ejemplo:(10.00)\n";
                                float nota = Validador.getFloat(mensaNota);
                                estudiante.setEdad(edad);
                                estudiante.setNota(nota);
                                lista.set(i, estudiante);
                                val = true;
                                break;
                            }
                        }
                        if (!val) {
                            System.out.println("Estudiante no encontrado");
                        }
                    }
                    break;
                case 3:
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes guardados");
                    } else {
                        System.out.print("Indique la cedula del estudiante:");
                        String ci = getString();
                        boolean val = false;
                        for (int i = 0; i < lista.size(); i++) {
                            Estudiante estudiante = lista.get(i);
                            if (ci.equals(estudiante.getCi())) {
                                lista.remove(i);
                                val = true;
                                break;
                            }
                        }
                        if (!val) {
                            System.out.println("Estudiante no encontrado");
                        }
                    }
                    break;
                case 4:
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes guardados");
                    } else {
                        for (Estudiante estudiante : lista) {
                            System.out.print(String.format("%s->", estudiante.getCi()));
                        }
                        System.out.print("NULL\n");
                    }
                    break;
                case 5:
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes guardados");
                    } else {
                        System.out.print("Indique la cedula del estudiante:");
                        String ci = getString();
                        for (Estudiante estudiante : lista) {
                            if (ci.equals(estudiante.getCi())) {
                                System.out.println(estudiante.toString() + "Estado: " + estudiante.evaluar() + "\n");
                                break;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Opcion no Valida");
                    break;

            }
        }
    }

    static Estudiante agregar() {
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        int edad;
        System.out.print("Indique el nombre completo del estudiante:");
        while (true) {
            try {
                nombre = sc.nextLine();
                Validador.validarLetras(nombre);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String ci;
        while (true) {
            System.out.print("Indique la cedula del estudiante:");
            ci = sc.nextLine();
            if ((ci.matches("[0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]")) || (ci.matches("[0-9]+") && ci.length() == 8)) {
                break;
            } else {
                System.out.println("Cedula no valida");
            }
        }
        while (true) {
            try {
                String mensaEdad = "Indique la edad del estudiante:";
                edad = Validador.getInt(mensaEdad);
                if (edad <= 0) {
                    throw new Exception("Edad no valida, intente de nuevo:");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String mensaNota = "Indique la nota del estudiante. Ejemplo:(10.00)\n";
        float nota = Validador.getFloat(mensaNota);
        Estudiante estu = new Estudiante(nombre, ci, edad, nota);
        return estu;
    }

    static String getString() {
        Scanner sc = new Scanner(System.in);
        String resultado = sc.nextLine();
        return resultado;
    }
}
