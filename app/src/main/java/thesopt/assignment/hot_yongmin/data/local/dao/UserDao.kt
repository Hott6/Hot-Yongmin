package thesopt.assignment.hot_yongmin.data.local.dao

import androidx.room.*
import thesopt.assignment.hot_yongmin.data.local.entity.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user : User)

    @Update
    fun updateUser(user : User)

    @Delete
    fun deleteUser(user : User)

    @Query("SELECT * from user_login_table WHERE user_id = :key")
    fun getUser(key:String):User

    @Query("DELETE FROM user_login_table")
    fun clearUser()
}