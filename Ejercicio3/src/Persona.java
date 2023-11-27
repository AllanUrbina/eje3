public class Persona {
    String nombre;
    int edad;
    char sexo;

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public boolean estaDisponible() {
        return true;
    }
}