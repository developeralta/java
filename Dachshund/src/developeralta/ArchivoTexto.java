package developeralta;

public class ArchivoTexto extends javax.swing.JPanel
{
  private static final long serialVersionUID = 1L;
//Constantes 
  private final String path=".";	
  //Declarar
   //Atributos
   private String nombreFisico;
   private java.io.File archivoTxt;
   private java.io.FileWriter flujoSalida;
   private javax.swing.JFileChooser selectorArchivo;
   private javax.swing.filechooser.FileNameExtensionFilter filtro;

 //Metodo Constructor
 public ArchivoTexto(){
  this.selectorArchivo=new javax.swing.JFileChooser(path);
  this.filtro=new javax.swing.filechooser.FileNameExtensionFilter("Archivos de Dachshund", "dach");
  this.selectorArchivo.setFileFilter(filtro);
  this.selectorArchivo.setAcceptAllFileFilterUsed(true);	 
  this.nombreFisico="";
 }
 
 public ArchivoTexto(String nombre){
  this.selectorArchivo=new javax.swing.JFileChooser(this.path);
  this.filtro=new javax.swing.filechooser.FileNameExtensionFilter("Archivos de Dachshund", "dach");
  this.selectorArchivo.setFileFilter(filtro);
  this.selectorArchivo.setAcceptAllFileFilterUsed(true);	 
  this.nombreFisico=nombre;
  this.archivoTxt=new java.io.File(this.nombreFisico);
 }

 //Metodos
 public void asignarArchivo(){
  this.archivoTxt=null;	 
  this.archivoTxt=new java.io.File(this.nombreFisico);
 }
 
 public void colocarNombreFisico(String nombre){
  this.nombreFisico=nombre;
 }

 public String obtenerNombreFisico(){
  return(this.nombreFisico);
 }
 
 public boolean verificarArchivo(){
  return(this.archivoTxt.exists());
 }
 
 public int seleccionarArchicoG() 
 {
  //Variables
	 int resultado;
  resultado=this.selectorArchivo.showSaveDialog(null);
  if(resultado==javax.swing.JFileChooser.APPROVE_OPTION)
   { 	
    this.nombreFisico=this.selectorArchivo.getSelectedFile().getName();
    asignarArchivo();
    if(this.archivoTxt.exists())
     resultado=javax.swing.JOptionPane.showConfirmDialog(null, "¿Quiere sobreescribir el archivo?","Sobreescritura de Archivo",javax.swing.JOptionPane.YES_NO_CANCEL_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);			 
   }

  return resultado;	 
 }

 public void crearArchivo(){
  //Declarar
   //Objetos
	 java.io.FileWriter flujoSalida;
  try
   {
	flujoSalida=new java.io.FileWriter((this.archivoTxt));
	flujoSalida.close();
   }
  catch(java.io.IOException e)
   {
	javax.swing.JOptionPane.showMessageDialog(null,"Error al crear el archivo.");
   }
 }
   
 
 public int seleccionarArchivoA()
 {
  //Variables
   int resultado;
  resultado=selectorArchivo.showOpenDialog(null); 
  if(resultado==javax.swing.JFileChooser.APPROVE_OPTION) 
   {     
	this.nombreFisico=this.selectorArchivo.getSelectedFile().getName();
	asignarArchivo();
   }	
  return resultado;
 }
 
 public void abrirEscritura(){
  //Declarar
   //Variables
   //String registro;
  try{
	  this.flujoSalida=new java.io.FileWriter(archivoTxt);
   }
  catch(java.io.IOException e){
    javax.swing.JOptionPane.showMessageDialog(null,"Error al abrir el archivo");
   } 
  /*Se cambia por el parametro true...
  Mientras(NO(FDA(archivoTxt))) 
   Leer(archivoTxt,registro);*/
 }	
	
 public void escribirBuffer(String registro)
 {
  try
   {
	this.flujoSalida.write(registro);
   }
  catch(java.io.IOException e)
   {
    javax.swing.JOptionPane.showMessageDialog(null,"Error al escribir en el buffer");
   }
 }
	
 public String mostrarArchivo()
 {
  //Declarar
   //Variables
    String registro="",contenido="";
   //Objetos
    java.io.FileReader flujoEntrada;
    java.io.BufferedReader buffer;  
  try
   {  
    flujoEntrada=new java.io.FileReader(this.archivoTxt);
    buffer=new java.io.BufferedReader(flujoEntrada);
    registro=buffer.readLine();
    while(registro!=null)
     {
	  contenido=contenido+registro+"\n";	  
      registro=buffer.readLine();
     }
    buffer.close();
   }
  catch(java.io.IOException e)
   {
    javax.swing.JOptionPane.showMessageDialog(null,"Error al leer el archivo");
   }
  return(contenido);
 }  

 public void cerrarEscritura(){
  try
   {
	this.flujoSalida.flush();
	this.flujoSalida.close();
	this.flujoSalida=null;
   }
  catch(java.io.IOException e)
   {
    javax.swing.JOptionPane.showMessageDialog(null,"Error al cerrar el archivo");
   } 
 }
 
 public void cerrarArchivo(){
  this.nombreFisico="";
  asignarArchivo(); 
 }    
}
