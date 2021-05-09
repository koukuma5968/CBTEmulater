package emulater.application.layout.selection.storage;

import emulater.application.bean.StorageBean;
import emulater.application.names.storage.StoragePaneNames;
import javafx.scene.layout.BorderPane;

public class ShowStoragePane extends BorderPane {

    public ShowStoragePane() {
        super();
        super.getStyleClass().add(StoragePaneNames.VIEW.getStyleName());
    }

    public void setStorage(StorageBean storage) {

        StorageAnswerPane answer = new StorageAnswerPane();
        answer.setAnswer(storage.getAnsBeans());

        super.setCenter(answer);

    }
}
