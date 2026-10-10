
public class Main {
    public static void main(String[] args) {
        HospitalEmergency hospital = new HospitalEmergency();

        System.out.println("Insertando pacientes...");
        hospital.insertarPorPrioridad(new

                Paciente("H001", "Juan", 2, 30));
        hospital.insertarPorPrioridad(new Paciente("H002", "Maria", 5, 10));
        hospital.insertarPorPrioridad(new Paciente("H003", "Pedro", 1, 60));
        hospital.insertarPorPrioridad(new Paciente("H004", "Ana", 4, 15));

        hospital.mostrarLista();

        hospital.pacientesEnEsperaCritica(20);

        hospital.reordenarPorTiempoEspera();
        hospital.mostrarLista(); //

        hospital.atenderSiguientePaciente();

        hospital.mostrarLista();
    }
}