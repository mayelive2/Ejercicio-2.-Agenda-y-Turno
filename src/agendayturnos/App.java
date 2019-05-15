/*
 * MAYELEEN RODRIGUEZ GOMEZ
   LUIS HATUM  
 */
package agendayturnos;

import java.time.LocalDate;
import java.util.ArrayList;


public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AgendaBasica basica = new AgendaBasica("Propietario: Enrique", "Descripcion: Tutorias");
        basica.añadirTurno(LocalDate.of(2018 , 12, 12), "09:30 – 10:00 y 10:30 – 11:00");
        basica.añadirTurno(LocalDate.of(2018 , 12, 13), "10:30 – 11:00");
        
        AgendaBalanceada balanceada = new AgendaBalanceada("Propietario: Enrique", "Descripcion: Revision de examen");
        balanceada.añadirTurno(LocalDate.of(2018 , 12, 12), "12:00 – 12:30 y 13:30 – 14:00");
        balanceada.añadirTurno(LocalDate.of(2018 , 12, 13), "11:00 – 11:30, 12:30 – 13:00 y 13:00 –13:30");
        
        ArrayList<Agenda> agendas = new ArrayList<Agenda>();
        agendas.add(basica);
        agendas.add(balanceada);
        for(Agenda agenda : agendas){
            System.out.println("Descripcion: " + agenda.getDescripcion());
            System.out.println("Numero de Turnos: " + agenda.consultarTurno(LocalDate.of(2018 , 12, 13)).size());
            System.out.println("Turno: "+agenda.reservar("Juan").getFranja());
            System.out.println("Turno: "+agenda.reservar("Juan").getFranja());
            for(Turno t : agenda.getTurno()){
                if(agenda.consultarTurno(t)){
                    System.out.println("Ocupado: " + t.getFranja());
                }
            }
            agenda.cancelarReserva(agenda.objTurnoUsuario.get(agenda.objTurnoUsuario.keySet().toArray()[0]), "Juan");
        }
    }
}
    

