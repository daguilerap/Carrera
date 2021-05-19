/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Carrera  extends Observable implements Runnable{
    private String nombre;

    public Carrera (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

   

    @Override
    public void run() {
      int porcentaje =0;
      int numeroAleatorio;
      try {
      
      while (porcentaje < 100){
          numeroAleatorio = (int) aleatorio();
          System.out.println("hilo " +nombre+ " ha aumentado " +numeroAleatorio);
          porcentaje +=numeroAleatorio;
          
          this.setChanged();
          this.notifyObservers(porcentaje);
          this.clearChanged();
          Thread.sleep(250);
            }
          } catch (InterruptedException ex) {
             System.out.println("hilo fallido");
          }
               
      }
    
  
    
    public long aleatorio(){
        long alea= (long) (Math.random() * 10 + 1);
        
        return alea;
    }   
    
}
