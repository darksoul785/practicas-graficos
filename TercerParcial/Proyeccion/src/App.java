public class App {

	private Frame frames;

	public static void main(String[] args) {

		new App().start();
	}

	void start() {
		frames = new Frame();
		Thread thread = new Thread((Runnable) this);
		thread.start();
	}

	public void run() {
		boolean exit = false;
		while (!exit) {
			try {

				if (frames.GetChange() == true) {
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
