

public class HospitalEmergency {
    private NodoDoble primero;
    private int tamanio;

    public HospitalEmergency() {
        this.primero = null;
        this.tamanio = 0;
    }

    public Paciente atenderSiguientePaciente() {
        if (primero == null) {
            System.out.println("No hay pacientes en espera.");
            return null;
        }

        Paciente pacienteAtendido = primero.dato;
        primero = primero.siguiente;

        if (primero != null) {
            primero.anterior = null;
        }

        tamanio--;
        System.out.println("Atendiendo a: " + pacienteAtendido.nombre);
        return pacienteAtendido;
    }

    public void insertarPorPrioridad(Paciente

                                             nuevo) {
        NodoDoble nodoNuevo = new NodoDoble(nuevo);

        if (primero == null) {
            primero = nodoNuevo;
            tamanio++;
            return;
        }

        if (nuevo.nivelPrioridad < primero.dato.nivelPrioridad) {
            nodoNuevo.siguiente =

                    primero;
            primero.anterior = nodoNuevo;
            primero = nodoNuevo;
            tamanio++;
            return;
        }

        NodoDoble actual = primero;

        while (actual.siguiente != null

                && actual.siguiente.dato.nivelPrioridad <= nuevo.nivelPrioridad) {
            actual = actual.siguiente;
        }

        nodoNuevo.siguiente = actual.siguiente;
        nodoNuevo.anterior = actual;

        if (actual.siguiente != null) {
            actual.siguiente.anterior = nodoNuevo;
        }
        actual.siguiente = nodoNuevo;


        tamanio++;
    }

    public void pacientesEnEsperaCritica(int minutosLimite) {
        System.out.println("--- Pacientes en espera crítica (más de " + minutosLimite + " min) ---");
        NodoDoble actual = primero;
        boolean hayCriticos = false;

        while (actual != null) {

            if (actual.dato.minutosEspera > minutosLimite) {
                System.out.println("- " + actual.dato.nombre + " (Espera: " + actual.dato.minutosEspera + " min)");
                hayCriticos = true;
            }
            actual = actual.siguiente;
        }

        if (!hayCriticos) {
            System.out.println("No hay pacientes en espera crítica.");
        }
    }

    public void reordenarPorTiempoEspera() {
        if (primero == null || primero.siguiente == null) {
            return;
        }

        boolean cambiado;
        do {
            cambiado = false;

            NodoDoble actual = primero;

            while (actual.siguiente != null) {
                if (actual.dato.minutosEspera < actual.siguiente.dato.minutosEspera) {

                    Paciente temp = actual.dato;
                    actual.dato =

                            actual.siguiente.dato;
                    actual.siguiente.dato = temp;

                    cambiado = true;
                }
                actual = actual.siguiente;
            }
        } while (cambiado);

        System.out.println("Lista reordenada por tiempo de espera (de mayor a menor).");
    }

    public void mostrarLista() {

        NodoDoble actual = primero;
        System.out.println("--- Estado actual de la lista ---");
        while (actual != null) {
            System.out.println(actual.dato.toString());
            actual = actual.siguiente;
        }
        System.out.println("--------------------------------");
    }
}