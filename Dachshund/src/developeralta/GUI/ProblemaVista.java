package developeralta.GUI;

import developeralta.Mundo;

public class ProblemaVista extends javax.swing.JFrame{
   private static final long serialVersionUID = 1L;
  //Atributos
  private Mundo mundo; 
  
 public ProblemaVista(Mundo mundoElegido){
  this.mundo=mundoElegido;
  setSize(800,650);
  setLocation(525,50);
  setUndecorated(true);
  getContentPane().setLayout(new java.awt.GridLayout(1,1));
  getContentPane().add(mundo);	
 }
}
