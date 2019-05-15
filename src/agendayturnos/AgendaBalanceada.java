/*
 * MAYELEEN RODRIGUEZ GOMEZ
   LUIS HATUM  
 */
package agendayturnos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AgendaBalanceada extends Agenda {
    
    private HashMap<LocalDate, Integer> balance = new HashMap<LocalDate, Integer>();

    public AgendaBalanceada(String propietario, String descripcion) {
        super(propietario, descripcion);
    }

    @Override
    public boolean añadirTurno(LocalDate fecha, String franja) {
        int contador = 0;
        if(super.añadirTurno(fecha, franja)){
            if(balance.size() > 0){
                for(Map.Entry<LocalDate, Integer> e : balance.entrySet()){
                    if(e.getKey().isEqual(fecha)){
                        balance.replace(e.getKey(), e.getValue()+1);
                        contador++;
                    }
                }
                if(contador == 0){
                    balance.put(fecha, 1);
                }
            }else{
                balance.put(fecha, 1);
            }
        }
        return true;
    }
    
    public LocalDate consultarDia(){
        
        Map.Entry<LocalDate, Integer> dia_mayor = null;
        for(Map.Entry<LocalDate, Integer> e : balance.entrySet()){
            if(dia_mayor == null){
                dia_mayor = e;
            }else{
                if(dia_mayor.getValue() <= e.getValue()){
                    dia_mayor = e;
                }
            }
        }
        return dia_mayor.getKey();
    }
    
    @Override
    protected Turno reservar(String usuario){
        Turno retornoTurno = null;
        LocalDate fecha_mayor = this.consultarDia();
        ArrayList<Turno> turnosDia = this.consultarTurno(fecha_mayor);
        for(Turno turno : turnosDia){
            if(!this.consultarTurno(turno)){
                objTurnoUsuario.put("usuario", turno);
                retornoTurno = turno;
                for(Map.Entry<LocalDate, Integer> e : balance.entrySet()){
                    if(e.getKey().isEqual(turno.getFecha())){
                        balance.replace(e.getKey(), e.getValue()-1);
                    }
                }
                break;
            }
        }
        return retornoTurno;
    }
    
}
