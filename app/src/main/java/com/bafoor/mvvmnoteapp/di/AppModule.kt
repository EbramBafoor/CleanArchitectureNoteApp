package com.bafoor.mvvmnoteapp.di

import android.app.Application
import androidx.room.Room
import com.bafoor.mvvmnoteapp.feature_note.data.data_source.NoteDataBase
import com.bafoor.mvvmnoteapp.feature_note.data.repository.NoteRepositoryImpl
import com.bafoor.mvvmnoteapp.feature_note.domain.repository.NoteRepository
import com.bafoor.mvvmnoteapp.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDateBase(app : Application) : NoteDataBase{
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(dao : NoteDataBase) : NoteRepository{
        return NoteRepositoryImpl(dao.noteDao)
    }

    @Provides
    @Singleton
    fun provideUseCases(noteRepository: NoteRepository) : NoteUseCase {
        return NoteUseCase(
            getNotesUseCase = GetNotesUseCase(noteRepository),
            deleteNoteUseCase = DeleteNoteUseCase(noteRepository),
            insertNoteUseCase = InsertNoteUseCase(noteRepository),
            getNoteUseCase = GetNoteUseCase(noteRepository)
        )
    }

}