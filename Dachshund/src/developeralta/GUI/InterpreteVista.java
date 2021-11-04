package developeralta.GUI;

import developeralta.ArchivoTexto;
import developeralta.Mundo;
import developeralta.Perro;

public class InterpreteVista extends javax.swing.JFrame
{
  private static final long serialVersionUID = 1L;
  //Atributos
  private javax.swing.JMenuItem itemNuevo;
  private javax.swing.JMenuItem itemAbrir;
  private javax.swing.JMenuItem itemGuardar;
  private javax.swing.JMenuItem itemGuardarC;
  private javax.swing.JMenuItem itemCompilar;
  private javax.swing.JMenuItem itemEjecutar;
  private EditorVista editor;
  private CompilacionVista compilacion;
  private Mundo mundo;
  private ProblemaVista problema;
  private ArchivoTexto codigo;
  
  private java.io.File instrucciones;
  private char instruccionesCiclo[];
  private int topeInstrucciones;
  private int condicionCiclo;
  private java.awt.Image iconoPrograma;	
  
  //Formulario Princiapal
  public InterpreteVista()
  {  
   this.instrucciones=null;	  
   this.codigo=new ArchivoTexto();
   this.mundo=new Mundo();
   this.editor=new EditorVista();
   this.compilacion=new CompilacionVista();
   this.problema=new ProblemaVista(mundo);
   this.iconoPrograma=java.awt.Toolkit.getDefaultToolkit().getImage("./Imagenes/Doky.png");
   this.problema.setVisible(true);
   setSize(440,700);
   setLocation(40,50);
   setResizable(false);
   setIconImage(this.iconoPrograma);
   setTitle("Interprete Dachshund");
   iniciarComponentes();
  }
  
  private void iniciarComponentes()
  {
   getContentPane().setLayout(new java.awt.FlowLayout());
   //Añadir paneles al marco.
   setJMenuBar(crearMenu());
   getContentPane().add(this.editor);
   getContentPane().add(this.compilacion);
   //Acción al cerrar la ventana.
   addWindowListener(new java.awt.event.WindowAdapter()
   {
    @Override
	public void windowClosing(java.awt.event.WindowEvent evt)
    {
     salir(evt);
    }
   } 	  
  );
  }
  
  public javax.swing.JMenuBar crearMenu()
  {
   //Objetos
	javax.swing.JMenuBar menuBar;  
	javax.swing.JMenu menuP;
	javax.swing.JMenu menuE;
	ManejadorEventoMenu eventoMenu;
   //Crear el evento del menú
   eventoMenu=new ManejadorEventoMenu();	
   //Crear la barra de menú
   menuBar=new javax.swing.JMenuBar();	
   //Crear el primer menú
   menuP=new javax.swing.JMenu("Archivo");
   menuE=new javax.swing.JMenu("Ejecución");	
   //Submenús
   this.itemNuevo=new javax.swing.JMenuItem("Nuevo", 'N');
   this.itemNuevo.addActionListener(eventoMenu);
   this.itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,java.awt.event.InputEvent.CTRL_MASK));
   menuP.add(this.itemNuevo);
   menuP.add(new javax.swing.JSeparator());
   this.itemAbrir=new javax.swing.JMenuItem("Abrir Archivo...", 'F');
   this.itemAbrir.addActionListener(eventoMenu);
   this.itemAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F,java.awt.event.InputEvent.CTRL_MASK));
   menuP.add(this.itemAbrir);
   this.itemGuardar=new javax.swing.JMenuItem("Guardar", 'G');
   this.itemGuardar.addActionListener(eventoMenu);
   this.itemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G,java.awt.event.InputEvent.CTRL_MASK));
   menuP.add(this.itemGuardar);
   this.itemGuardarC=new javax.swing.JMenuItem("Guardar como...");
   this.itemGuardarC.addActionListener(eventoMenu);
   menuP.add(this.itemGuardarC);
   this.itemCompilar=new javax.swing.JMenuItem("Compilar", 'P');
   this.itemCompilar.addActionListener(eventoMenu);
   this.itemCompilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P,java.awt.event.InputEvent.CTRL_MASK));
   menuE.add(this.itemCompilar);
   menuE.add(new javax.swing.JSeparator());
   this.itemEjecutar=new javax.swing.JMenuItem("Ejecutar", 'R');
   this.itemEjecutar.addActionListener(eventoMenu);
   this.itemEjecutar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R,java.awt.event.InputEvent.CTRL_MASK));
   menuE.add(this.itemEjecutar);
   //Añadiendo al menú Bar
   menuP.addActionListener(new ManejadorEventoMenu());
   menuBar.add(menuP);
   menuBar.add(menuE);
   return(menuBar);	  
  }
  
  private void salir(java.awt.event.WindowEvent evt)
  {	 
   guardarCodigo();
   System.exit(0);
  }
  
  private void nuevoCodigo()
  { 	  
   //guardarCodigo();	  
   //codigo.cerrarArchivo();
   if(this.codigo.seleccionarArchicoG()==0)
    {
	 this.codigo.crearArchivo();
	 this.editor.obtenerAreaCodigo().setText("");
    }
  }
  
  private void abrirCodigo()
  {	  
   //guardarCodigo();	
   //codigo.cerrarArchivo();
   if(this.codigo.seleccionarArchivoA()==0)
    {   
     this.editor.obtenerAreaCodigo().setText("");
     this.editor.obtenerAreaCodigo().setText(codigo.mostrarArchivo());
    }
  }
  
  private void guardarCodigo()
  {
   if(this.codigo.obtenerNombreFisico().compareTo("")==0)
    {
	 if(this.codigo.seleccionarArchicoG()==0)
	  {
	   this.codigo.crearArchivo();
	   this.codigo.abrirEscritura();
	   this.codigo.escribirBuffer(editor.obtenerAreaCodigo().getText());
	   this.codigo.cerrarEscritura();
	  }
    }
   else
   {
	this.codigo.abrirEscritura();
	this.codigo.escribirBuffer(editor.obtenerAreaCodigo().getText());
	this.codigo.cerrarEscritura();
   }
  }
  
  private void guardarComo()
  {
   if(this.codigo.seleccionarArchicoG()==0)
	{
     this.codigo.crearArchivo();
 	 this.codigo.abrirEscritura();
 	 this.codigo.escribirBuffer(editor.obtenerAreaCodigo().getText());
 	 this.codigo.cerrarEscritura();
	}
  }
  
  private void compilar()
  {
   guardarCodigo();
   this.compilacion.obtenerAreaCompilacion().setText("");
   try 
    {  
	 Process p=Runtime.getRuntime().exec("./Compilador.exe "+codigo.obtenerNombreFisico()); 
	 java.io.InputStream is = p.getInputStream(); 
	 java.io.BufferedReader br = new java.io.BufferedReader (new java.io.InputStreamReader (is)); 
	 String aux = br.readLine();
	 while(aux!=null) 
	  { 
	   this.compilacion.obtenerAreaCompilacion().append(aux+"\n"); 
	   aux=br.readLine(); 
	  } 
    }  
   catch (Exception e) 
    { 
     e.printStackTrace(); 
    }   
  }
  
  private void ejecutar()
  {
	//Objetos
	 java.io.FileReader flujoEntrada;
	 java.io.BufferedReader buffer;
   //Variables
	 String nombreInstrucciones,instruccion;
	 boolean errorEjecucion;
	 Perro copiaDoky;
   compilar();	 
   copiaDoky=this.mundo.obtenerPerro();
   this.instruccionesCiclo=new char[50];	
   nombreInstrucciones=codigo.obtenerNombreFisico();
   if(nombreInstrucciones.compareTo("")!=0)
	nombreInstrucciones=nombreInstrucciones.substring(0, codigo.obtenerNombreFisico().length()-5)+".is";	
   this.instrucciones=new java.io.File(nombreInstrucciones);
   if(instrucciones.exists())
	{
	 errorEjecucion=false;  
	 this.compilacion.obtenerAreaCompilacion().setText("");
	 this.compilacion.obtenerAreaCompilacion().append("Ejecutando la aplicación...\n");  
	 this.compilacion.obtenerAreaCompilacion().setText("Moviendo a Doky...\n");
	 try
	  { 
	   flujoEntrada=new java.io.FileReader(instrucciones);
	   buffer=new java.io.BufferedReader(flujoEntrada);
	   instruccion=buffer.readLine();
	   while(instruccion!=null)
	    {	
		 if(instruccion.compareTo("1")==0)
		  errorEjecucion=instruccionAvanzar();
		 else
		 {	 
		  if(instruccion.compareTo("2")==0)
		   this.mundo.obtenerPerro().girarDerecha();
		  else
		   {  
			colocarInstruccioneCiclo(buffer);  
			if(instruccion.compareTo("3")==0)
			 errorEjecucion=instruccionMientras();
			else
			 errorEjecucion=instruccionRepetir();		
		   }
		 }
	     if(errorEjecucion)
	      {
	       instruccion=null;	
	       if(this.mundo.llegueMeta(copiaDoky.obtenerX(), copiaDoky.obtenerY()))
	    	{
	    	 if(javax.swing.JOptionPane.showConfirmDialog(null, "¿Quiere quedarse en este mundo?","!Felicidades, Usted Ganó!",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE)!=0)
	    	  mundo.generarMundo();
	    	}
	       else
	        javax.swing.JOptionPane.showMessageDialog(null,"Error en tiempo de ejecución...");
	       copiaDoky.colocarOrientacion(this.mundo.obtenerOrientacionMundo());
	       copiaDoky.colocarPunto(this.mundo.obtenerNoMundo(), this.mundo.obtenerNoMundo());
	      }
	     else	 
		  instruccion=buffer.readLine();	

	     this.mundo.repaint();	 

	    }
	   if(!errorEjecucion)
	    {
		 if(javax.swing.JOptionPane.showConfirmDialog(null, "¿Quiere dejar a Doky en la nueva posición?","!Usted Perdió!",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE)!=0)
		  {  
		   copiaDoky.colocarOrientacion(this.mundo.obtenerOrientacionMundo());
	       copiaDoky.colocarPunto(this.mundo.obtenerNoMundo(), this.mundo.obtenerNoMundo());
	       this.mundo.repaint();
		  }
	    }   
	   buffer.close();
	   flujoEntrada.close();
	  }
	 catch(java.io.IOException e)
	  {
	   javax.swing.JOptionPane.showMessageDialog(null,"Error al leer el programa...");
      }
	 finally
	 {
	  flujoEntrada=null;
	  buffer=null;
	  this.instruccionesCiclo=null;
	  this.instrucciones=null;
	  this.compilacion.obtenerAreaCompilacion().append("Doky se durmió...");
	 }
	}
  }
  
  private boolean instruccionAvanzar()
  {
   //Variables
	boolean error;  
    int orientacion,x,y;
   error=false; 
   orientacion=this.mundo.obtenerPerro().obtenerOrientacion();
   x=mundo.obtenerPerro().obtenerX();
   y=mundo.obtenerPerro().obtenerY();
   switch(orientacion)
    {
     case 1: //Mover Arriba
    	     if(x!=0)
    	      {
     	       if(this.mundo.obtenerPlano().EstaOcupado(x-1, y))
    	        {
     	    	 if(this.mundo.llegueMeta(x-1, y))
     	    	  mundo.obtenerPerro().moverArriba();
        	     error=true;	
    	        }
    	       else
    	        mundo.obtenerPerro().moverArriba();	
    	      }
    	     else
    	      error=true;	 
             break;
     case 2: //Mover Derecha
    	     if(y!=4)
    	      { 
               if(this.mundo.obtenerPlano().EstaOcupado(x, y+1))
   	            {
    	    	 if(this.mundo.llegueMeta(x, y+1))
    	    	  mundo.obtenerPerro().moverDerecha();
    	    	 error=true;	
   	            }
   	           else
   	            mundo.obtenerPerro().moverDerecha();
    	      }
    	     else
    	      error=true;	 
    	     break;
     case 3: //Mover Abajo
    	     if(x!=4)
    	      {
	           if(this.mundo.obtenerPlano().EstaOcupado(x+1, y))
   	            {
    	    	 if(this.mundo.llegueMeta(x+1, y))
    	    	  mundo.obtenerPerro().moverAbajo();
    	    	 error=true;
   	            }	           
	           else
   	            mundo.obtenerPerro().moverAbajo();	
    	      }
	         else
	          error=true;	 
	         break;
     case 4: //Mover Izquierda
    	     if(y!=0)
    	      {
   	           if(this.mundo.obtenerPlano().EstaOcupado(x, y-1))
   	            {
    	    	 if(this.mundo.llegueMeta(x, y-1))
    	    	  mundo.obtenerPerro().moverIzquierda();
    	    	 error=true;
   	            }
  	           else
  	            mundo.obtenerPerro().moverIzquierda();
    	      }
    	     else
    	      error=true;	 
             break;
    }  
   return(error);  
  }
  
  private boolean instruccionMientras()
  {
   //Variables
	boolean error; 
	int iI,x,y,orientacion;
   error=false;
   iI=0;
   orientacion=mundo.obtenerPerro().obtenerOrientacion();
   if(orientacion==condicionCiclo || condicionCiclo==0)
    {   
     while(iI<this.topeInstrucciones && error==false) 
      {
       if(this.instruccionesCiclo[iI]=='1')
 	    error=instruccionAvanzar();
       else
 	    this.mundo.obtenerPerro().girarDerecha();  
      }
     x=this.mundo.obtenerPerro().obtenerX();
     y=this.mundo.obtenerPerro().obtenerY();	
     if(this.condicionCiclo==0)
      {	 
	   if(orientacion==2 || orientacion==4)  
	    { 
	     if(y!=0 && y!=4 )  
	      error=false;	 
	    }
	   else
	    {
	     if(x!=0 && x!=4)
		  error=false;   
	    }
	  }
     else
      error=false;
    }
   else
	error=true;   
   return(error);   
  }
  
  private void colocarInstruccioneCiclo(java.io.BufferedReader instrucciones)
  {
   //Variables 
	String registro;
   this.topeInstrucciones=0;
   this.condicionCiclo=1;	
   try
	{ 
	 registro=instrucciones.readLine();
	 switch(registro)
	  {
	   case "NOOBSTACULO":
		  					condicionCiclo=0;
		  					break;
	   case "ARRIBALIBRE":
							condicionCiclo=1;
							break;
	   case "ABAJOLIBRE":
							condicionCiclo=3;
							break;
	   case "IZQUIERDALIBRE":
							condicionCiclo=4;
							break;
	   case "DERECHALIBRE":
							condicionCiclo=2;
		   					break;
	   default:	  
          					condicionCiclo=java.lang.Integer.parseInt(registro);
          					break;
	  } 
	 registro=instrucciones.readLine();
	 while(registro.compareTo("0")!=0)
	  {  	 
	   this.instruccionesCiclo[this.topeInstrucciones]=registro.charAt(0);	 
	   registro=instrucciones.readLine();	 
	   this.topeInstrucciones=this.topeInstrucciones+1;
	  }
	}
   catch(java.io.IOException e)
	{
	 javax.swing.JOptionPane.showMessageDialog(null,"Error al leer el programa...");  
	}	
  }
  
  private boolean instruccionRepetir()
  {
   //Variables
	boolean error;
	int iC,iI;
   error=false;
   iC=1;
   do
    {
	 iI=0;   
	 do
	  {
	   if(this.instruccionesCiclo[iI]=='1')	 
	    error=instruccionAvanzar();
	   else
		this.mundo.obtenerPerro().girarDerecha();   
	   iI=iI+1;
	  }while(iI<this.topeInstrucciones && error==false);
	 iC=iC+1;   
    }
   while(iC<=this.condicionCiclo && error==false);
   return(error); 	  
  }
  
  class ManejadorEventoMenu implements java.awt.event.ActionListener
  {
   @Override
   public void actionPerformed(java.awt.event.ActionEvent evt)
   {
    Object item=evt.getSource();
    if(item==itemNuevo)
     nuevoCodigo();
    else
     {
      if(item==itemAbrir)
       abrirCodigo();
      else
       {
        if(item==itemGuardar)
         guardarCodigo();
        else
         {
    	  if(item==itemGuardarC)
    	   guardarComo();
    	  else
    	   {
    	    if(item==itemCompilar)
    	     compilar();
    	    else
    	     ejecutar();
    	   }
         }
       }
     }
    item=null;
   }		
  }

}
