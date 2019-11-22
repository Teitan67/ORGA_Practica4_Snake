/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Rectangle;
import javax.swing.JLabel;

/**
 *
 * @author vanes
 */
public class Serpiente {
    JLabel cuerpo;
    Rectangle interseccion;

    public Serpiente(JLabel cuerpo, Rectangle interseccion) {
        this.cuerpo = cuerpo;
        this.interseccion = interseccion;
    }

    public JLabel getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(JLabel cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Rectangle getInterseccion() {
        return interseccion;
    }

    public void setInterseccion(Rectangle interseccion) {
        this.interseccion = interseccion;
    }
    
    
    
    
}
