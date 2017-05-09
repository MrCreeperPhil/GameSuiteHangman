package ui;

public class LauncherApp {
	public static void main(String[] args) {
		Launcher launcher = new Launcher();
		launcher.start();
		while (launcher.run())
			;

	}
}
