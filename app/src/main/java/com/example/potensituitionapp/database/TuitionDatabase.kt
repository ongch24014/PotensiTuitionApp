package com.example.potensituitionapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Student::class,Course::class,Teacher::class,Attendance::class
,Timetable::class,Enrollment::class,Payment::class,Admin::class,ClassRecord::class
,Chapter::class,TeacherEnroll::class,Revision::class), version = 14, exportSchema = false)
abstract class TuitionDatabase : RoomDatabase(){

    abstract val studentDatabaseDao: StudentDatabaseDao
    abstract val courseDatabaseDao: CourseDao
    abstract val teacherDatabaseDao: TeacherDao
    abstract val attendanceDatabaseDao: AttendanceDao
    abstract val timetableDatabaseDao: TimetableDao
    abstract val enrollmentDatabaseDao: EnrollmentDao
    abstract val paymentDatabaseDao: PaymentDao
    abstract val adminDatabaseDao: AdminDao
    abstract val classRecordDatabaseDao: ClassRecordDao
    abstract val chapterDatabaseDao: ChapterDao
    abstract val teacherEnrollDatabaseDao: TeacherEnrollDao
    abstract val revisionDao: RevisionDao
    
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