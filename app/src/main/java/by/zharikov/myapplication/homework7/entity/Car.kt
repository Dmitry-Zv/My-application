package by.zharikov.myapplication.homework7.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cars")
data class Car(
    @ColumnInfo(name = "brand_cars")
    val brand: String,
    @ColumnInfo(name = "max_speed")
    val maxSpeed: Double,
    @ColumnInfo(name = "fuel_consumption")
    val fuelConsumption: Double
):Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}