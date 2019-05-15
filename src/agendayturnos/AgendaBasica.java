/*
 * MAYELEEN RODRIGUEZ GOMEZ
   LUIS HATUM  
 */
package agendayturnos;

import java.util.ArrayList;


public class AgendaBasica extends Agenda{
    
     ArrayList<String> usuariosReserva;

    public AgendaBasica(String propietario, String descripcion) {
        super(propietario, descripcion);
        this.usuariosReserva = new ArrayList<String>();
    }
    
    protected Turno reservar(String usuario){
        Turno turno_antiguo = null;
        for(Turno turno : this.turno){
            if(turno_antiguo == null){
                if(!this.consultarTurno(turno)){
                    turno_antiguo = turno;
                }
            }else if(turno_antiguo.getFecha().isAfter(turno.getFecha())){
                if(this.consultarTurno(turno)){
                    turno_antiguo = turno;
                }
            }
        }
        if(turno_antiguo != null){
            objTurnoUsuario.put(usuario, turno_antiguo);
        }
        return turno_antiguo;
    }
    
}
