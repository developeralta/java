package developeralta;

import developeralta.GUI.InformaciónVista;

public class InterpretreDachshund 
{	  
  private static void crearMostrarGUI(){
   try
	{
	 //Aspecto de la interfaz grafica...
	 javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
	}
   catch(Exception e)
	{
	 javax.swing.JOptionPane.showMessageDialog(null,"No se puede establacer el aspecto deseado: "+e);
	}
    InformaciónVista informacion=new InformaciónVista();
    informacion.setVisible(true);
  }	  
  
  public static void main(String[] args){
	//Programe un trabajo para el hilo de despacho de eventos:
    //Crear y Mostrando la GUI de está aplicación
    javax.swing.SwingUtilities.invokeLater(new Runnable(){
       @Override
	public void run()
       {
        crearMostrarGUI();
       }
     });		 
  }	
}
