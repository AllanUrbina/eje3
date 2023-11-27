class Profesor extends Persona {
    String asignatura;

    public Profesor(String nombre, int edad, char sexo, String asignatura) {
        super(nombre, edad, sexo);
        this.asignatura = asignatura;
    }

    @Override
    public boolean estaDisponible() {
        return true;
    }
}
