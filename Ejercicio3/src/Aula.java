public class Aula {
    int identificador;
    int maxEstudiantes;
    String asignaturaDestinada;
    Profesor profesor;
    Persona[] estudiantes;
    int totalEstudiantes;

    public Aula(int identificador, int maxEstudiantes, String asignaturaDestinada, Profesor profesor) {
        this.identificador = identificador;
        this.maxEstudiantes = maxEstudiantes;
        this.asignaturaDestinada = asignaturaDestinada;
        this.profesor = profesor;
        this.estudiantes = new Persona[maxEstudiantes];
        this.totalEstudiantes = 0;
    }

    public boolean puedeImpartirseClase() {
        int contador = 0;
        for (Persona estudiante : estudiantes) {
            if (estudiante != null) {
                contador++;
            }
        }
        return contador > (maxEstudiantes / 2) && profesor.estaDisponible();
    }

    public int contarAprobados() {
        int aprobados = 0;
        for (Persona estudiante : estudiantes) {
            if (estudiante instanceof Estudiante) {
                Estudiante e = (Estudiante) estudiante;
                if (e.calificacion >= 5.0) {
                    aprobados++;
                }
            }
        }
        return aprobados;
    }
}
