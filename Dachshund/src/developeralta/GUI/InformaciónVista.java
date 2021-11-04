package developeralta.GUI;

import javax.swing.SwingConstants;

public class InformaciónVista extends javax.swing.JFrame{
   private static final long serialVersionUID = 1L;
  //Atributos
  private javax.swing.JPanel panelInformacion; 
  private javax.swing.ImageIcon Doky;
 public InformaciónVista(){
   panelInformacion=new javax.swing.JPanel(null);	 
   getContentPane().setLayout(new java.awt.GridLayout(1,1));
   iniciarComponentes();
   //Acción al cerrar la ventana.
   addWindowListener(new java.awt.event.WindowAdapter()
   {
    @Override
	public void windowClosing(java.awt.event.WindowEvent evt)
    {
     System.exit(0);
    }
   } 	  
  );
 }
 
 private void ejecutarInterprete()
 {	 
   InterpreteVista interprete=new InterpreteVista();   
   interprete.setVisible(true);
 }
 
 private void iniciarComponentes()
 {
   //Objetos
   javax.swing.JScrollPane dezpInf;
   javax.swing.JTextPane areaInformacion;
   javax.swing.JLabel titulo,autor,imagen;
   javax.swing.JButton continuar;
  setSize(400,680);
  setLocation(483,40); 
  this.Doky=new javax.swing.ImageIcon("./Imagenes/Doky.png"); 
  titulo=new javax.swing.JLabel("Interprete Dachshund 1.0");
  imagen=new javax.swing.JLabel(Doky);
  autor=new javax.swing.JLabel("Copyright (c) 2019 by developeralta®");
  continuar=new javax.swing.JButton("Aceptar");
  titulo.setHorizontalAlignment(SwingConstants.CENTER);
  titulo.setVerticalAlignment(SwingConstants.CENTER);
  titulo.setBounds(120, 10, 160, 20);
  
  imagen.setHorizontalAlignment(SwingConstants.CENTER);
  imagen.setVerticalAlignment(SwingConstants.CENTER);
  imagen.setBorder(new javax.swing.border.EtchedBorder());
  imagen.setBounds(100, 35, 200, 200);
  
  autor.setHorizontalAlignment(SwingConstants.CENTER);
  autor.setVerticalAlignment(SwingConstants.CENTER);
  autor.setBounds(80, 240, 240, 20); 
  
  areaInformacion=new javax.swing.JTextPane();
  areaInformacion.setEditable(false);
  areaInformacion.setBorder(new javax.swing.border.EmptyBorder(5,5,5,5));
  areaInformacion.setFont(new java.awt.Font("Courier New",java.awt.Font.BOLD, 15));
  dezpInf=new javax.swing.JScrollPane(areaInformacion);  
  dezpInf.setBounds(5, 265, 390, 360);
  //Información
  areaInformacion.setText("Es un software orientado a la enseñanza a la programación en niños implementando "
  		+ "un Lenguaje de Programación basado en las acciones de un perro llamado Doky.\n\n"
  		+ "Doky puede avanzar una casilla de acuerdo a su posición y girar hacía la derecha.\n\n"
  		+ "Usted debe escribir las instrucciones que desea que realice Doky para que pueda llegar a su hueso, de acuerdo a las siguientes palabras:\n\n"
  		+ "· Avanzar.\n"
  		+ "· GirarDerecha.\n\n"
  		+ "También es posible repetir instrucciones de acuerdo a las siguientes condiciones:\n\n"
  		+ "· No exista un obstáculo.\n\n"
  		+ "· Casilla correspondiente a la posición de Doky se encuentre libre.\n\n"
  		+ "· Un número determinado de veces.\n\n "
  		+ "Antes de colocar cualquier instrucción debe colocar la siguiente palabra: \n\n "
  		+ "· Inicio. \n\n"
  		+ "Por último, debe colocar la instrucción: \n\n"
  		+ "· Fin.\n\n"
  		+ "Veamos un pequeño ejemplo:\n\n"
  		+ "Inicio\n "
  		+ " Avanzar\n"
  		+ " Mientras(NoObstaculo)hacer\n"
  		+ " {\n"
  		+ "  Avanzar\n"
  		+ " }\n"
  		+ " Repetir 3 veces\n"
  		+ " {\n "
  		+ "   GirarDerecha\n"
  		+ " }\n"
  		+ "Fin\n\n"
  		+ "Las condiciones que entiende Doky son las siguientes:\n\n"
  		+ "· NoObstaculo.\n"
  		+ "· DerechaLibre.\n"
  		+ "· IzquierdaLibre.\n"
  		+ "· AbajoLibre.\n"
  		+ "· ArribaLibre.\n\n"
  		+ "!Bienvenido al mundo de la programación!\n\n");
  this.panelInformacion.setBorder(new javax.swing.border.EmptyBorder(10,10,10,10));
  
  continuar.setBounds(150,630,100,20);
  continuar.addActionListener(new ManejadorBoton());
  
  this.panelInformacion.add(titulo);
  this.panelInformacion.add(imagen);
  this.panelInformacion.add(autor);
  this.panelInformacion.add(dezpInf);
  this.panelInformacion.add(continuar);
  getContentPane().add(this.panelInformacion);	 
 }
 
 class ManejadorBoton implements java.awt.event.ActionListener
 {
  @Override
  public void actionPerformed(java.awt.event.ActionEvent evt)
  {
   setVisible(false);	  
   ejecutarInterprete();	  
  }
 }

}
