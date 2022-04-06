package thesopt.assignment.hot_yongmin.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user_login_data")
data class User(
    @PrimaryKey
    val name : String,
    @ColumnInfo(name = "id")
    val id : String,
    @ColumnInfo(name = "password")
    val pw : String
)
