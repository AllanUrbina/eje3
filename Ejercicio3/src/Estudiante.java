
public class Estudiante extends Persona {
    double calificacion;

    public Estudiante(String nombre, int edad, char sexo, double calificacion) {
        super(nombre, edad, sexo);
        this.calificacion = calificacion;
    }

    @Override
    public boolean estaDisponible() {
        return true;
    }
}
