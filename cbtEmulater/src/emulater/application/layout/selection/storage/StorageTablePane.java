package emulater.application.layout.selection.storage;

import emulater.application.bean.CheckAnswerBean;
import emulater.application.names.storage.StoragePaneNames;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class StorageTablePane extends BorderPane {

    public void setTableView(ObservableList<CheckAnswerBean> beanList) {

        TableView<CheckAnswerBean> anstable = new TableView<CheckAnswerBean>();
        anstable.getStyleClass().add(StoragePaneNames.CHECK_TABLE.getStyleName());

        anstable.getColumns().add(getTableColumn("番号", "number"));
        anstable.getColumns().add(getTableColumn("正答", "solution"));
        anstable.getColumns().add(getTableColumn("選択した解答", "userSel"));
        anstable.getColumns().add(getTableColumn("正誤", "correction"));

        anstable.setItems(beanList);

        super.setCenter(anstable);
    }

    private TableColumn<CheckAnswerBean, ?> getTableColumn(String title, String property) {

        TableColumn<CheckAnswerBean, String> col = new TableColumn<CheckAnswerBean, String>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property));
        col.setResizable(false);

        return col;
    }

}
