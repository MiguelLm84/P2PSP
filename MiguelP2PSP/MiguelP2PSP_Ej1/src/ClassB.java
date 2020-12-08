

public class ClassB implements Runnable {
	
	private ClassA classA;

	public ClassB(ClassA classA) {
		
		this.classA=classA;
	}
	
	@Override
	public void run() {
		
		classA.EnterAndWait();
	}
}
