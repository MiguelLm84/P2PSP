

import java.util.List;

public class ClassB_plus implements Runnable {
	
	private ClassA_plus classA_plus;
	private ClassB_plus next;
	private List<ClassB_plus> lista;
	private boolean acceder=true;
	private Thread hilo=Thread.currentThread();

	public ClassB_plus(ClassA_plus classA_plus) {
		
		this.classA_plus=classA_plus;
	}
	
	public List<ClassB_plus> getLista() {
		return lista;
	}

	public void setLista(List<ClassB_plus> lista) {
		this.lista=lista;
	}
	
	public ClassB_plus getNext() {
		return next;
	}

	public void setNext(ClassB_plus next) {
		this.next=next;
	}
	
	@Override
	public void run() {
		
		while(acceder) {
			synchronized(lista){	
				try {	
					lista.wait();	
				} catch (InterruptedException e) {					
					hilo.interrupt();
					System.out.println("Error, hilo interrumpido.");
				}
				if (classA_plus.isFinished()) {
					acceder=false;
				} else {
					classA_plus.EnterAndWait();
				}
				lista.notifyAll();
			}
		}		
	}
}
