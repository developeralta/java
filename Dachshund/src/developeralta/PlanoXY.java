package developeralta;

public class PlanoXY
{
 //Atributos	
  private int xMax;
  private int yMax;	
  private int deltaX;
  private int deltaY;
  private boolean plano[][];
  private int xPixeles;
  private int yPixeles;  
  
  public PlanoXY(int xMax,int yMax,int deltaX,int deltaY)
  {
   this.plano=new boolean[xMax][yMax];	  
   this.xPixeles=0;
   this.yPixeles=0;
   this.xMax=xMax;
   this.yMax=yMax;
   this.deltaX=deltaX;
   this.deltaY=deltaY;
   inicializarPlano();
  }

  private void inicializarPlano()
  {
   //Variables
 	int x,y;
   for(x=0;x<this.xMax;x=x+1)
    {
 	 for(y=0;y<this.yMax;y=y+1)
 	  this.plano[x][y]=false;
    }
  }
  
  public int obtenerXPixeles()
  {
   return(this.xPixeles);
  }
  
  public int obtenerYPixeles()
  {
   return(this.yPixeles);
  } 
  
  public boolean EstaOcupado(int x,int y)
  {
   return(this.plano[x][y]);	  
  }

  private void colocarObstaculo(int x,int y)
  {
   this.plano[x][y]=true;;
  }
  
  public void calcularPixeles(int x,int y)
  {
   this.xPixeles=y*this.deltaX+5;
   this.yPixeles=x*this.deltaY+5;
  }
    
  public void calcularCoordenada(String coordenada)
  {
   //Variables 
    int x,y;
   x=java.lang.Integer.parseInt(coordenada.substring(0, 1));
   y=java.lang.Integer.parseInt(coordenada.substring(2, 3));
   colocarObstaculo(x, y);
   calcularPixeles(x, y);
  }
    
}
