package javacode;

/*
 * Variation on Singleton
 * 
 */
public class Nton {
	

private static int n=15;
private static volatile Nton [] instanceArr;
private static int index;

private Nton() {}

public static Nton getInstance() {
		 if(instanceArr == null){
	          synchronized (Nton.class) {
	        	  instanceArr= new Nton[n];
	        	  int i=0;
	        	  while(i<n)
	        		{
	        			instanceArr[n]=new Nton();
	        			i++;
	        		}
	         }
	      }
	      return instanceArr[index++%n];
	}

}
