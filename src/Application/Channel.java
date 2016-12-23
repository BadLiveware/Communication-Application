package Application;

public class Channel implements Comparable<Channel>, Runnable {

	// FIXME FOR TESTING ONLY
	private static int ID = 0;

	private synchronized int getID() {
		return ID;
	}

	private synchronized void incrementID() {
		ID++;
	}

	private String comID;
	private boolean running;

	private Connection con;
	private IO inOut;

	/**
	 * Handles Connections and IO operations.
	 * 
	 * @param Con
	 *            connection between two devices
	 * @param inOut
	 *            IPC between two processes
	 */
	public Channel(Connection con, IO inOut) {
		// FIXME FOR TESTING ONLY
		comID = Integer.toString(getID());
		incrementID();

		this.con = con;
		this.inOut = inOut;
	}

	@Override
	public void run() {
		running = true;
		new Thread(con).start();
		while (running) {

		}
	}

	@Override
	public int compareTo(Channel c) {
		return comID.equals(c.getComID()) ? 1 : 0;
	}

	public String getComID() {
		return comID;
	}

	public void exit() {
		con.close();
		// io.close();
	}
}
