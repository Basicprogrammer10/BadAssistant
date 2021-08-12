package com.connorcode.assistant.app

import javafx.geometry.Pos
import javafx.scene.control.ListCell

class Response(private val response: String) : Displayable {
    override fun update(cell: ListCell<Displayable?>?) {
        if (cell != null) {
            cell.alignment = Pos.CENTER_RIGHT
            cell.text = response
        }
    }
}