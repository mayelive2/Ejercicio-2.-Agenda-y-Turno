/*
 * MAYELEEN RODRIGUEZ GOMEZ
   LUIS HATUM  
 */
package agendayturnos;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;


public class Turno {
    
    protected LocalDate fecha;
    protected String franja;

    public Turno(LocalDate fecha, String franja) {
        this.fecha = fecha;
        this.franja = franja;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getFranja() {
        return franja;
    }

    public void setFranja(String franja) {
        this.franja = franja;
    }
    public boolean equals(Turno turno) {
        if (this.fecha.equals(turno.fecha) && Objects.equals(this.franja, turno.franja)) {
            return true;
        }
        else {
        return true;
        }
    }

   @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.fecha);
        hash = 73 * hash + Objects.hashCode(this.franja);
        return hash;
    }

    
    
}
