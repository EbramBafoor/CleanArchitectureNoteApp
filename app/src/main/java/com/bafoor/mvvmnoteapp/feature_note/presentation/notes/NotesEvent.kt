package com.bafoor.mvvmnoteapp.feature_note.presentation.notes

import com.bafoor.mvvmnoteapp.feature_note.domain.model.Note
import com.bafoor.mvvmnoteapp.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}

//<-----Note State sealed class for store what action that user can do notesScreen----->

