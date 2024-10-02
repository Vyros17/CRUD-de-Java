package jcrud_basic;

abstract class Persona {

    String nombre, ci;
    int edad;

    public Persona(String nombre, String ci, int edad) {
        this.nombre = nombre;
        this.ci = ci;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCi() {
        return this.ci;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
