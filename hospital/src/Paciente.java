
public class Paciente {
    // Datos
    public String historialClinico;
    public String nombre;
    public int nivelPrioridad; // Del 1 al 5
    public int minutosEspera;

    // Constructor
    public Paciente(String historial, String nombre, int prioridad, int espera) {
        this.historialClinico = historial;
        this.nombre = nombre;
        this.nivelPrioridad = prioridad;
        this.minutosEspera = espera;

    }

    // Imprimir
    @Override
    public String toString() {
        return "Paciente: " + nombre + " | Prioridad: " + nivelPrioridad + " | Espera: " + minutosEspera + " min";
    }
}