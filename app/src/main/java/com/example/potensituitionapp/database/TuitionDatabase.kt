package com.example.potensituitionapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Student::class,Course::class), version = 3, exportSchema = false)
abstract class TuitionDatabase : RoomDatabase(){
    abstract val studentDatabaseDao: StudentDatabaseDao
    abstract val courseDatabaseDao: CourseDao

    companion object {
        @Volatile
        private var INSTANCE: TuitionDatabase? = null

        fun getInstance(context: Context): TuitionDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TuitionDatabase::class.java,
                        "tuition_database")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}