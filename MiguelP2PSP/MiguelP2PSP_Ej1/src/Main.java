import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ClassA classA=new ClassA();
		Scanner sc=new Scanner(System.in);		 		
		String opcion=null;
		int counter=0;		
		
		try {
			do {
				System.out.println("Introducir una opción");
				System.out.println("1. Valor counter\n2. Exit");
				opcion=sc.next();						
				switch(opcion) {		
				case "1":	
					System.out.println("\nIntroducir un valor para el Counter: ");
					counter=sc.nextInt();
					int aux=counter;
					if(counter>0) {
						for(int i=0;i<counter;i++) {
							ClassB classB=new ClassB(classA);
							Thread hilo=new Thread(classB);
							hilo.start();
						}
						try {
							Thread.sleep(1500*aux);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					} else {
						while(counter<=0) {
							System.out.println("Error, el valor a introducir debe ser mayor de 0.");
							System.out.println("\nIntroducir un valor para el Counter: ");
							counter=sc.nextInt();
						}						
					}
					break;
					
				case "2":
					System.out.println("La ejecución se ha terminado. Adios!!.");
					break;
					
				default:			
					System.out.println("Error, el valor introducido no es correcto.");
					break;	
				}
				
			} while(!opcion.equals("2"));
			
		} catch(InputMismatchException e) {
			System.out.println("Error, el valor introducido no es un digito.");
		}			
		sc.close();	
	}
}
