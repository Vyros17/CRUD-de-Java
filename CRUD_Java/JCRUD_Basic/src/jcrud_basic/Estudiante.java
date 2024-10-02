package jcrud_basic;

public class Estudiante extends Persona implements Evaluacion {

    float nota;

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Estudiante(String nombre, String ci, int edad, float nota) {
        super(nombre, ci, edad);
        this.nota = nota;
    }

    @Override
    public String evaluar() {
        if (this.nota >= 10) {
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

    @Override
    public String toString() {
        return String.format("ESTUDIANTE:\nCedula: %s\nNombre: %s\nEdad:%d\nNota: %.2f\n", this.ci, this.nombre, this.edad, this.nota);
    }

}
