package emulater.layout;

import emulater.layout.Border.TreeListView;
import emulater.layout.menu.Topmenu;
import javafx.scene.layout.BorderPane;

public class EmulateBorder extends BorderPane {

	public EmulateBorder() {
		super();
		init();
	}

	private void init() {
		setMenu();
		setLeft();
	}

	private void setMenu() {
		super.setTop(new Topmenu());
	}

	private void setLeft() {

		super.setLeft(new TreeListView());

	}
}
