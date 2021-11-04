package developeralta.GUI;

import javax.swing.JTextArea;

public class CompilacionVista extends javax.swing.JPanel{
   private static final long serialVersionUID = 1L;
 //Atributos
  private javax.swing.JTextArea areaCompilacion;

  public CompilacionVista() {
   javax.swing.JScrollPane dezpCompilacion;	  
   this.areaCompilacion=new javax.swing.JTextArea();
   this.areaCompilacion.setLineWrap(true);
   this.areaCompilacion.setLineWrap(true);
   this.areaCompilacion.setEditable(false);
   this.areaCompilacion.setBorder(new javax.swing.border.EmptyBorder(5,5,5,5));
   this.areaCompilacion.setFont(new java.awt.Font("Courier New", java.awt.Font.BOLD, 12));
   dezpCompilacion=new javax.swing.JScrollPane(areaCompilacion);
   setLayout(new java.awt.GridLayout(1,1));
   setPreferredSize(new java.awt.Dimension(440,200));
   setBorder(new javax.swing.border.TitledBorder("Compilador"));
   add(dezpCompilacion);   
  }
  
  public JTextArea obtenerAreaCompilacion() {
   return(this.areaCompilacion);	  
  }
}
