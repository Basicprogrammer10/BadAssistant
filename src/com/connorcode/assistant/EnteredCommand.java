package com.connorcode.assistant;

import com.connorcode.assistant.app.Displayable;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;


record EnteredCommand(String command) implements Displayable {

    public void update(ListCell<Displayable> cell) {
        cell.setText("> " + command);
        cell.setAlignment(Pos.CENTER_LEFT);
    }
}
