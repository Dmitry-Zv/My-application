package by.zharikov.myapplication.homework7

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.zharikov.myapplication.homework7.dao.CarDao
import by.zharikov.myapplication.homework7.entity.Car

@Database(entities = arrayOf(Car::class), version = 1)
abstract class CarDb:RoomDatabase() {
    abstract fun carDao():CarDao
}
object Db{
fun getDb(context:Context)= Room.databaseBuilder(context,CarDb::class.java, "CarDatabase").build()
}