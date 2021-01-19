package emulater.layout;

import emulater.layout.Border.ItemView;
import emulater.layout.Border.TreeListView;
import emulater.layout.menu.Topmenu;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class EmulateBorder extends BorderPane {

	public EmulateBorder() {
		super();
		super.getStyleClass().add("emulater-pane");
		init();
	}

	private void init() {
		setMenu();
		setLeft();
		setCenter();
	}

	private void setMenu() {
		Topmenu top = new Topmenu();
		super.setTop(top);
		super.setAlignment(top, Pos.CENTER_RIGHT);
	}

	private void setLeft() {
		super.setLeft(new TreeListView());
	}

	private void setCenter() {
		super.setCenter(new ItemView());
	}

}
