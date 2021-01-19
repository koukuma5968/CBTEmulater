package emulater.layout.Border;

import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ItemView extends VBox {

	public ItemView() {
		super();
		init();
	}

	private void init() {

		super.getStyleClass().add("itemview-pane");

		setAccordion("認定資格名称", "Oracle Certified Java Programmer, Bronze SE 7/8", Priority.NEVER);
		setAccordion("資格概要", "試験番号：1Z0-808\n試験時間：60分", Priority.NEVER);
		setTableContents();

	}

	private void setAccordion(String title, String text, Priority pri) {

		final Accordion accordion = new Accordion();

		TitledPane tps = new TitledPane();
		tps.getStyleClass().add("titled-pane");
		tps.setText(title);
		accordion.getPanes().addAll(tps);
		accordion.setExpandedPane(tps);
//		accordion.setPrefHeight(80);

		TextArea text1 = new TextArea(text);
		text1.setPrefHeight(100);
		tps.setContent(text1);
		tps.setPrefHeight(BASELINE_OFFSET_SAME_AS_HEIGHT);

		super.setVgrow(accordion, pri);
		super.getChildren().add(accordion);

	}

	private void setTableContents() {

		TitledPane tps = new TitledPane();
		tps.getStyleClass().add("titled-pane");
		tps.setText("目次");

		super.getChildren().add(tps);

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));

		TreeView<String> tree = new TreeView<String>();
		TreeItem<String> chapter = new TreeItem<String>("第1章");
		TreeItem<String> part = new TreeItem<String>("変数");
		chapter.getChildren().add(part);

		tree.setRoot(chapter);

		grid.add(tree, 0, 0);

		super.getChildren().add(grid);

	}

}
