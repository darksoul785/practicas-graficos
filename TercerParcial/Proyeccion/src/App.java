public class  App {
    
    private Frame frames;
    public static void main(String[] args) {

        new App().start();
    }
    void start(){
        frames = new Frame();
		Thread hilo = new Thread((Runnable) this);
		hilo.start();
    }

	public void run() {
		boolean exit = false;
		while (!exit) {
			try {

				if(frames.GetChange() == true) {
					frames.repaint();
					frames.SetChange(false);
				}

				Thread.sleep(100);
			} catch (InterruptedException ignored) {
				exit = true;
			}
		}
	}    
}
