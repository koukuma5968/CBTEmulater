package emulater.layout.tree.menu;

import emulater.event.EventListener;
import emulater.event.arrivals.ArrivalsEventHandler;
import emulater.event.exam.ExaminationEventHandler;
import emulater.event.storage.StorageEventHandler;

public enum SubMenuItemNames {

    STORAGE("storage-button", "試験成績", StorageEventHandler.values()),
    EXAM("exam-button", "試験一覧", ExaminationEventHandler.values()),
    NARRIVALS("arrivals-button", "新着問題", ArrivalsEventHandler.values());

    private SubMenuItemNames(String styleName, String text, EventListener[] handler) {
        this.styleName = styleName;
        this.text = text;
        this.handler = handler;
    }

    private String styleName;

    private String text;

    private EventListener[] handler;

    public String getStyleName() {
        return styleName;
    }

    public String getText() {
        return text;
    }

    public EventListener[] getHandler() {
        return  handler;
    }

}