package thesopt.assignment.hot_yongmin.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_login_table")
data class User(
    @PrimaryKey
    val name : String,
    @ColumnInfo(name = "user_id")
    val id : String,
    @ColumnInfo(name = "user_pw")
    val pw : String
)
