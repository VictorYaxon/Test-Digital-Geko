package test.victoryaxon.org.test.Models;

/**
 * Created by User on 02/04/2017.
 */
public class Football {
    String nombre_equipo;
    Double goles_favor;
    Double goles_contra;
    Double diferencia;

    public Football(String nombre_equipo, Double goles_favor, Double goles_contra, Double diferencia) {
        this.nombre_equipo = nombre_equipo;
        this.goles_favor = goles_favor;
        this.goles_contra = goles_contra;
        this.diferencia = diferencia;
    }

    public Football() {
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public Double getGoles_favor() {
        return goles_favor;
    }

    public void setGoles_favor(Double goles_favor) {
        this.goles_favor = goles_favor;
    }

    public Double getGoles_contra() {
        return goles_contra;
    }

    public void setGoles_contra(Double goles_contra) {
        this.goles_contra = goles_contra;
    }

    public Double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(Double diferencia) {
        this.diferencia = diferencia;
    }
}