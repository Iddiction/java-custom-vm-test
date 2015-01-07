package test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class.getName());


	private Main() {
	}

	private static Main instance = new Main();

	public static Main instance() {
		return instance;
	}

	private List<Container> containers = new ArrayList<>(1_000_000);

	public int list() {
		return containers.size();
	}

	public void add(int num) {
		try {
			for (int i = 0; i < num; i++) {
				Container ctr = new Container();
				containers.add(ctr);
			}
		} catch (Exception err) {

			Runtime.getRuntime().exit(1);
		}
	}


	public void clear() {
		containers.clear();
	}

}
