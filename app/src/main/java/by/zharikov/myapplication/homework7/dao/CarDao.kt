package by.zharikov.myapplication.homework7.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.zharikov.myapplication.homework7.entity.Car

@Dao
interface CarDao {
    @Insert
    suspend fun addCar(car: Car)

    @Query("SELECT * FROM cars")
    suspend fun getCars(): List<Car>

    @Query("DELETE FROM cars WHERE id =:id")
    suspend fun deleteCar(id: Int)

    @Query("DELETE FROM cars")
    suspend fun deleteAllCars()
}