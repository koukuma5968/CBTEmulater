package emulater.layout.Border;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import emulater.layout.xml.tree.Category;
import emulater.layout.xml.tree.Item;
import emulater.layout.xml.tree.LeftViewItem;
import emulater.util.JAXBUtil;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TreeListView extends TreeView<String> {

	private static TreeItem<String> mtree = new TreeItem<String>();
	private static List<TreeItem<String>> itemTreeList = new ArrayList<TreeItem<String>>();

	public TreeListView() {

		super();
		mtree.setValue("一覧");
		setItems();

		setRoot(mtree);

	}

	protected void setItems() {

		try (BufferedReader br = Files.newBufferedReader(Paths.get("prop/ItemList.xml"))) {
			LeftViewItem itemBean = (LeftViewItem) JAXBUtil.getXMLReder(LeftViewItem.class, br);
			for (Category items : itemBean.getCategorys()) {
				TreeItem<String> cate = new TreeItem<String>(items.getCategory());
				for (Item item : items.getItems()) {
					TreeItem<String> name = new TreeItem<String>(item.getName());
					for (String value : item.getValue()) {
						name.getChildren().add(new TreeItem<String>(value));
					}
					cate.getChildren().add(name);
				}
				mtree.getChildren().add(cate);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		itemTreeList.add(mtree);

	}
}
