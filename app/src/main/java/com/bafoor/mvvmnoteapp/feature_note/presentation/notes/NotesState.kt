package com.bafoor.mvvmnoteapp.feature_note.presentation.notes

import com.bafoor.mvvmnoteapp.feature_note.domain.model.Note
import com.bafoor.mvvmnoteapp.feature_note.domain.util.NoteOrder
import com.bafoor.mvvmnoteapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes : List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible : Boolean = false
)


//<-----Note State Data class for store what user will see in notesScreen----->
