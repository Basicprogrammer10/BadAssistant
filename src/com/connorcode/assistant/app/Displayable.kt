package com.connorcode.assistant.app

import javafx.scene.control.ListCell

interface Displayable {
    fun update(cell: ListCell<Displayable?>?)
}