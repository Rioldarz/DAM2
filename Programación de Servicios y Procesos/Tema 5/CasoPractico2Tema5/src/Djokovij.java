
public class Djokovij extends Thread {
	public void run() {
		while (true) {
			System.out.println("YIAAA");
			Thread.yield();
			try {
				Thread.sleep(NORM_PRIORITY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Fin try
		} // Fin Mientras
	}// Fin Procedimiento
}
