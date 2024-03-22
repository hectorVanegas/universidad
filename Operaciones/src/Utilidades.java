import java.util.Arrays;
import java.util.Scanner;

public class Utilidades {

	
	public class MetodoBurbuja {
		
	    public static void main(String[] args) {
	        int x[] = {1, 9, 23, 4, 55, 100, 1, 1, 23};
	        System.out.println("Antes del método de la burbuja: " + Arrays.toString(x));
	        burbuja(x);
	        	System.out.println("Después del método de la burbuja: " + Arrays.toString(x));
	        String[] nombres = {"Leon", "Chris", "Jill", "Wesker", "Ada"};
	      System.out.println("Antes del método de la burbuja: " + Arrays.toString(nombres));
	        burbujas(nombres);
	        System.out.println("Después del método de la burbuja: " + Arrays.toString(nombres));
	        
	        
	        
	        System.out.println("Ingrese la accion que quiere hacer:");
	        Scanner sc = new Scanner(System.in);
	        int p = sc.nextInt();
	        if(p == 1) {
	        	System.out.println("Ingrese el numero para saber si es primo o no" );
	        	
	        	boolean andando = esPrimo(sc.nextInt());
	        	
	        	System.out.println( andando);
	        	
	        }
	        if(p == 2) {
	        	System.out.println("Ingrese los 4 nuemros double de la operaciòn:" );
	        	
	        			double a = sc.nextDouble();
	        	double b = sc.nextDouble();
	        			double c = sc.nextDouble();
	        			double d = sc.nextDouble();
	        	
	        	System.out.println( calcularResultado(a,b,c,d) );
	        	
	        }if(p == 3) {
	        	System.out.println("La ejecuciòn ha terminado" );
	        	
	        }
	    }
	   	   private static void burbujas(String[] arreglo) {
	        for (int x = 0; x < arreglo.length; x++) {
	            // Aquí "y" se detiene antes de llegar
	            // a length - 1 porque dentro del for, accedemos
	            // al siguiente elemento con el índice actual + 1
	            for (int y = 0; y < arreglo.length - 1; y++) {
	                String elementoActual = arreglo[y],
	                        elementoSiguiente = arreglo[y + 1];
	                if (elementoActual.compareTo(elementoSiguiente) > 0) {
	                    // Intercambiar
	                    arreglo[y] = elementoSiguiente;
	                    arreglo[y + 1] = elementoActual;
	                }
	            }
	        }
	    }
	}

	    			private static void burbuja(int[] arreglo) {
	 for (int x = 0; x < arreglo.length; x++) {
	            // Aquí "y" se detiene antes de llegar
	            // a length - 1 porque dentro del for, accedemos
	            // al siguiente elemento con el índice actual + 1
	   for (int y = 0; y < arreglo.length - 1; y++) {
	                int elementoActual = arreglo[y],
	                        elementoSiguiente = arreglo[y + 1];
	         if (elementoActual > elementoSiguiente) {
	                    // Intercambiar
	                    arreglo[y] = elementoSiguiente;
	                    arreglo[y + 1] = elementoActual;
	                }
	            }       } }
	    
	     static boolean esPrimo(int a){
	    int d =   2;
	    	  boolean s=true;
	    	  while ((s) && (d!=a)){
	    	    if (a % d == 0)
	    	      s = false;
	    	    d++;
	    	  }
	    	  return s;
	    	} 

 static double calcularResultado(double a, double b, double c, double d) {
    double resultado;
    resultado = ((a + b) * (c - d)) / (a * d);
    return resultado;
}

}
