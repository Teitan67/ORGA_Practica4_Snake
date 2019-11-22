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
public class MejoresP implements Comparable<MejoresP>{
    
    String nombre;
    Integer puntos;

    public MejoresP(String nombre, Integer puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    @Override
    public int compareTo(MejoresP o) {
      return puntos.compareTo(o.getPuntos());
    }
    
    
}
