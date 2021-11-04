package developeralta;

public class Perro{
 //Atributos
  private int orientacion;
  private int x;
  private int y;

 public Perro(int x,int y,int orientacion)
 {	 
  this.x=x;
  this.y=y;
  this.orientacion=orientacion;	 
 }
 
 public void colocarOrientacion(int x)
 {
  this.orientacion=x;	 
 }
 
 public int obtenerOrientacion()
 {
  return(this.orientacion);	 
 }
 
 public void colocarPunto(int x,int y)
 {
  this.x=x;
  this.y=y;
 }
 
 public void moverDerecha()
 {
  this.y=this.y+1;
 }
 
 public void moverIzquierda()
 {
  this.y=this.y-1;
 }
 
 public void moverArriba()
 {
  this.x=this.x-1;
 }
 
 public void moverAbajo()
 {
  this.x=this.x+1;
 }
 
 public void girarDerecha()
 {
  if(this.orientacion==4)
   this.orientacion=1;
  else
   this.orientacion=this.orientacion+1;
 }
 
 public int obtenerX()
 {
  return(this.x);	 
 }
 
 public int obtenerY()
 {
  return(this.y);	 
 }
}
