package developeralta;

public class Mundo extends javax.swing.JPanel{
  private static final long serialVersionUID = 1L;
 //Atributos
  private java.io.File mundo;
  private PlanoXY plano;
  private Perro doky;
  private int xHueso;
  private int yHueso;
  private int noMundo;
  private int orientacionMundo; 
  private java.awt.image.BufferedImage imagenDoky;
  private java.awt.image.BufferedImage imagenCasa;
  private java.awt.image.BufferedImage imagenHueso;
  private java.awt.image.BufferedImage[] imgObstaculos;
  
  //Formulario Mundo
 public Mundo()
 { 	  
  this.plano=new PlanoXY(5, 5, 160, 130);;
  this.imgObstaculos=new java.awt.image.BufferedImage[5];	
  generarMundo();
  this.doky=new Perro(0, 0, orientacionMundo);
  iniciarComponentes();	 
 }
 
 public void generarMundo()
 {
  this.noMundo=(int)(Math.random()*5);
  //this.noMundo=0;	 
  this.orientacionMundo=(int)(Math.random()*3+1);	 
 }
 
 private void iniciarComponentes()
 {
  setSize(800,650);
  setLayout(new java.awt.GridLayout(1,1));
 } 

 public Perro obtenerPerro()
 {
  return(this.doky);	 
 }
 
 @Override
public void paint(java.awt.Graphics g)
 { 
  cargarImagenes();	 
  dibujarPlano(g);
  colocarDoky(g);
  crearMundo(g);
 }
 
 public PlanoXY obtenerPlano()
 {
  return(this.plano);
 }
 
 public int obtenerOrientacionMundo()
 {
  return(this.orientacionMundo);	  
 }
 
 public void colocarNoMundo(int numero)
 {
  this.noMundo=numero;	  
 }
 
 public boolean llegueMeta(int x,int y)
 {
   //Variables
	boolean llegue;
  llegue=false;
  if(x==xHueso && y==yHueso)
	llegue=true;   
  return(llegue);	  
 }
 
 public int obtenerNoMundo()
 {
  return(this.noMundo);	  
 }
 
 
 private void cargarDoky(int posicion)
 {
  imagenDoky=null;
  try
   {
    switch(posicion){ 
      case 1: imagenDoky=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Arriba.png"));
              break;
      case 2: imagenDoky=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Derecha.png"));
      		  break;
      case 3: imagenDoky=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Abajo.png"));
      		  break;
      case 4: imagenDoky=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Izquierda.png"));
      		  break;	
      case 5: imagenDoky=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Doky.png"));
		      break;		  
     }
   }
  catch(java.io.IOException e)
   {
	javax.swing.JOptionPane.showMessageDialog(null,"Error al cargar a Doky...");  
   }
 }
 
 private void cargarImagenes()
 {
  imagenHueso=null;
  imagenCasa=null;
  imgObstaculos[0]=null;
  imgObstaculos[1]=null;
  imgObstaculos[2]=null;
  imgObstaculos[3]=null;
  imgObstaculos[4]=null;
  try
   {
    imagenHueso=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Carne.png"));
    imagenCasa=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Casa.jpg"));
    imgObstaculos[0]=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Tree.png"));
    imgObstaculos[1]=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Balon.png"));
    imgObstaculos[2]=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Futbol.png"));
    imgObstaculos[3]=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Poop.png"));
    imgObstaculos[4]=javax.imageio.ImageIO.read(new java.io.File("./Imagenes/Obstaculo.jpg"));
   }
  catch(java.io.IOException e)
   {
    javax.swing.JOptionPane.showMessageDialog(null,"Error al cargar elementos del mundo...");  
   }  
 }
 
 private void crearMundo(java.awt.Graphics g)
 {
  //Variables
   String registro; 
   int contador;
   java.io.FileReader flujoEntrada;
   java.io.BufferedReader buffer;  
  contador=1;
  mundo=new java.io.File("./Mundos/Mundo"+noMundo+".dach");	
  try
   {  
    flujoEntrada=new java.io.FileReader(mundo);
    buffer=new java.io.BufferedReader(flujoEntrada);
    registro=buffer.readLine();
    while(registro!=null)
     {	  		
      plano.calcularCoordenada(registro);
      if(contador==1)
       {
   	    xHueso=(plano.obtenerYPixeles()-5)/130;
   	    yHueso=(plano.obtenerXPixeles()-5)/160;
   	    g.drawImage(imagenHueso, plano.obtenerXPixeles(), plano.obtenerYPixeles(), 150, 120, null);
       }
      else
       {
        if(contador==2)
         g.drawImage(imagenCasa, plano.obtenerXPixeles(), plano.obtenerYPixeles(), 150, 120, null);
        else
         g.drawImage(imgObstaculos[noMundo], plano.obtenerXPixeles(), plano.obtenerYPixeles(), 145, 115, null);	
       }
      registro=buffer.readLine();
      contador=contador+1;
     }
    buffer.close();
   }
  catch(java.io.IOException e)
   {
    javax.swing.JOptionPane.showMessageDialog(null,"Error al cargar el mundo...");
   } 
 }

 private void colocarDoky(java.awt.Graphics g)
 { 
  cargarDoky(doky.obtenerOrientacion());
  plano.calcularPixeles(doky.obtenerX(), doky.obtenerY());
  g.drawImage(imagenDoky,plano.obtenerXPixeles(), plano.obtenerYPixeles(), 150, 120, null);
 }
 
 private void dibujarPlano(java.awt.Graphics g)
 {
   //Variables
	int x;	 
  g.setColor(java.awt.Color.BLACK); 
  //Dibujamos las líneas horizontales
  x=0;
  do
   {	  
	g.drawLine(0, x, 800, x);
	x=x+130;
   }while(x<650);
  //Dibujamos las líneas verticales
  x=0;
  do
   {
	x=x+160;
	g.drawLine(x, 0, x, 672);
   }while(x<800);	 
 }  

 
}
