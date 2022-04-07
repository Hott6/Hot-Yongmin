package thesopt.assignment.hot_yongmin.data.dao

import androidx.room.*
import thesopt.assignment.hot_yongmin.data.entity.User

@Dao
interface UserDao {
    @Insert
    fun insert(user : User)

    @Update
    fun update(user : User)

    @Query("SELECT * from user_login_table WHERE user_id = :key")
    fun get(key:String):User

    @Query("DELETE FROM user_login_table")
    fun clear()
}