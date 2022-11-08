//public class MultithreadThing extends Thread {
	public class MultithreadThing implements Runnable {
	private int threadNumber;
	
	public MultithreadThing (int threadNumber) {
		this.threadNumber = threadNumber;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + " del hilo " + this.threadNumber);
			
//			if(this.threadNumber == 3) {
//				throw new RuntimeException();
//			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}//Fin try
		}//Fin Para
	}//Fin Procedimiento
}
