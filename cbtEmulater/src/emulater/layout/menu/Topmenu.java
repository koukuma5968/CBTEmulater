package emulater.layout.menu;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class Topmenu extends MenuBar {

	public Topmenu() {
		super();
		init();
	}

	private void init() {

		Menu system = new Menu("ファイル");
		MenuItem close = new MenuItem("終了");
		close.setOnAction(e -> {
			Platform.exit();
	        System.exit(0);
		});
		system.getItems().add(close);

		super.getMenus().add(system);

	}
}
