package thesopt.assignment.hot_yongmin.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import thesopt.assignment.hot_yongmin.data.local.dao.UserDao
import thesopt.assignment.hot_yongmin.data.local.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao : UserDao

    companion object{

        /*private var instance : UserDatabase? = null

        fun getInstance(context: Context):UserDatabase{
            return instance?: synchronized(this)<UserDatabase>{
                newInstance(context).also{instance=it}
            }
        }*/

        @Volatile
        private var INSTANCE : UserDatabase? = null

        fun getInstance(context: Context) : UserDatabase {
            synchronized(this){
                var instance = INSTANCE

                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_login_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}