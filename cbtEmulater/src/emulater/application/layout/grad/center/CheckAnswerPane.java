package emulater.application.layout.grad.center;

import emulater.application.names.grad.CheckAnswerNames;
import emulater.application.names.problem.CheckAnswerBean;
import emulater.event.EventListener;
import emulater.event.review.CheckAnswerReviewEventHandler;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class CheckAnswerPane extends HBox {

    public CheckAnswerPane() {
        super();
        super.getStyleClass().add(CheckAnswerNames.VIEW.getStyleName());
    }

    public void setAnswer(ObservableList<CheckAnswerBean> beanList) {

        SolutionsNumBox numBox = new SolutionsNumBox();
        numBox.setNumBox(beanList);

        HBox.setHgrow(numBox, Priority.ALWAYS);
        super.getChildren().add(numBox);

        TableView<CheckAnswerBean> anstable = new TableView<CheckAnswerBean>();

        anstable.getColumns().add(getTableColumn("番号", "number"));
        anstable.getColumns().add(getTableColumn("正答", "solution"));
        anstable.getColumns().add(getTableColumn("選択した解答", "userSel"));
        anstable.getColumns().add(getTableColumn("正誤", "correction"));

        anstable.setItems(beanList);

        for (EventListener handler : CheckAnswerReviewEventHandler.values()) {
            anstable.addEventHandler(handler.getEventType(), handler.getEvent());
        }
        super.getChildren().add(anstable);

    }

    private TableColumn<CheckAnswerBean, ?> getTableColumn(String title, String property) {

        TableColumn<CheckAnswerBean, String> col = new TableColumn<CheckAnswerBean, String>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property));
        col.setResizable(false);

        return col;
    }
}
