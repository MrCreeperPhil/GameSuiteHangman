package ui;

public class LauncherApp {
	public static void main(String[] args) {
		LaunchHangman launcher = new LaunchHangman();
		launcher.start();
		while (launcher.run());
	}
}
