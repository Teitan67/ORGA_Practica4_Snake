/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author vanes
 */
public class Mejores implements Comparable<Mejores> {
    String nombre;
    Integer tiempo;
    Integer puntos;

    public Mejores(String nombre,int tiempo, int puntos) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    @Override
    public int compareTo(Mejores o) {
       return tiempo.compareTo(o.getTiempo());
    }
    
    
}
