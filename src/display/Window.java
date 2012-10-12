package display;

public class Window {
	
	public static void main(String[] args) {
		Thread.currentThread().setName("Thread principal") ;
		FirstWindow sim = new FirstWindow() ;
	}

}
