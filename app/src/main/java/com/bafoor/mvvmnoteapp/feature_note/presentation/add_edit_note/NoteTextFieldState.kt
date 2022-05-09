package com.bafoor.mvvmnoteapp.feature_note.presentation.add_edit_note

data class NoteTextFieldState(
    val text : String = "", // <--- for Title & Content
    val hint : String = "", // <--- for Title & Content
    val isHintVisible : Boolean = true
)