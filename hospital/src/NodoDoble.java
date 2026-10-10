
public class NodoDoble {
    public Paciente dato; // Aquí guardamos el objeto Paciente
    public NodoDoble siguiente; // Apunta al nodo de adelante
    public NodoDoble anterior;  // Apunta al nodo de atrás

    // Constructor del nodo
    public NodoDoble(Paciente p) {
        this.dato = p;
        this.siguiente = null;
        this.anterior = null;
    }
}