package com.finalproject.frosch.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void insertAllNotes(Note... notes);

    @Delete
    void deleteNote(Note note);

    @Update
    void updateNote(Note note);

    @Query("SELECT * FROM Notes ORDER BY date DESC")
    List<Note> getAllNotes();

    @Query("SELECT date FROM Notes ORDER BY date DESC")
    List<Long> getAllDate();

    @Query("SELECT * FROM Notes WHERE date BETWEEN :date1 AND :date2 ORDER BY date DESC")
    List<Note> getNotesFromPeriod(Long date1, Long date2);

    @Query("SELECT DISTINCT hashTag FROM notes")
    List<String> getHashTags();
}
