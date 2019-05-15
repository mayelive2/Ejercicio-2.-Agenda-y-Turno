/*
 * MAYELEEN RODRIGUEZ GOMEZ
   LUIS HATUM  
 */
package agendayturnos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public abstract class Agenda {
    
    protected String propietario;
    protected String descripcion;
    protected ArrayList<Turno> turno;
    HashMap<String, Turno> objTurnoUsuario = new HashMap<String, Turno>();

    public Agenda(String propietario, String descripcion) {
        this.propietario = propietario;
        this.descripcion = descripcion;
        this.turno = new ArrayList<Turno>();
    }
    
     public boolean añadirTurno(LocalDate fecha, String franja){
        Turno turno = new Turno(fecha, franja);
        boolean sw = false;
        for(Turno e : this.turno){
            if(e.equals(turno)){
                sw = true;
            }
        }
        if(!sw){
            this.turno.add(turno);
            return true;
        }else{
            return false;
        }
    }
    public void ajustarDias(int numero){
        for(Turno turno : this.turno){
            if(numero > 0){
                turno.setFecha(turno.getFecha().plusDays(numero));
            }else{
                turno.setFecha(turno.getFecha().minusDays(numero));
            }
        }
    }
    
    public ArrayList<Turno> consultarTurno(LocalDate fecha){
        ArrayList<Turno> retornar_turnos = new ArrayList<Turno>();
        for(Turno e : this.turno){
            if(e.getFecha().isEqual(fecha)){
                retornar_turnos.add(e);
            }
        }
        return retornar_turnos;
    }
    
    public boolean reservar(String usuario, Turno turno){
        boolean retorno = false;
        for(Turno e: this.turno){
            if(e.equals(turno)){
                if(!this.consultarTurno(turno)){
                    objTurnoUsuario.put(usuario, turno);
                    retorno = true;
                }
            }
        }
        return retorno;
    }
    
    protected abstract Turno reservar(String usuario);
    
    public String consultarUsuario(Turno turno){
        String usuario = null;
        for(Map.Entry<String, Turno> e : objTurnoUsuario.entrySet()){
            if(turno.equals(e.getValue())){
                usuario = e.getKey();
            }
        }
        return usuario;
    }
    public boolean consultarTurno(Turno turno){
        boolean retorno = false;
        for(Map.Entry<String, Turno> e : objTurnoUsuario.entrySet()){
            if(e.getValue().equals(turno)){
                retorno = true;
            }
        }
        return retorno;
    }
    
    public boolean cancelarReserva(Turno turno, String usuario){
        String eliminado = null;
        for(Map.Entry<String, Turno> t : objTurnoUsuario.entrySet()){
            System.out.println(t.getKey()+" = "+usuario);
            System.out.println(t.getValue().getFranja()+" = "+turno.getFranja());
            if(Objects.equals(t.getKey(), usuario) && t.getValue().equals(turno)){
                eliminado = t.getKey();
            }
        }
        if(eliminado != null){
            objTurnoUsuario.remove(eliminado);
            System.out.println("cancelado");
            return true;
        }else{
            return false;
        }
    }
    
    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Turno> getTurno() {
        return turno;
    }

    public void setTurno(ArrayList<Turno> turno) {
        this.turno = turno;
    }

   
    
}
