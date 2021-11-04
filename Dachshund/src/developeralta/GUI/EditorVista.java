package developeralta.GUI;

import javax.swing.JTextArea;

public class EditorVista extends javax.swing.JPanel{
  private static final long serialVersionUID = 1L;
  //Atributos
  private javax.swing.JTextArea areaCodigo;
  
  public EditorVista(){
   javax.swing.JScrollPane dezpCodigo; 
   //Área de Texto
   this.areaCodigo=new javax.swing.JTextArea();
   this.areaCodigo.setLineWrap(true);
   this.areaCodigo.setWrapStyleWord(true);
   this.areaCodigo.setBorder(new javax.swing.border.EmptyBorder(5,5,5,5));
   this.areaCodigo.setFont(new java.awt.Font("Courier New",java.awt.Font.BOLD, 16));
   dezpCodigo=new javax.swing.JScrollPane(this.areaCodigo); 
   setLayout(new java.awt.GridLayout(1,1));
   setPreferredSize(new java.awt.Dimension(440,445));
   setBorder(new javax.swing.border.TitledBorder("Programa"));    
   add(dezpCodigo);
  }
  
  public JTextArea obtenerAreaCodigo() {
   return(this.areaCodigo);	  
  }
}
