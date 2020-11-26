package bajeti.susac.co.ke.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import bajeti.susac.co.ke.data.dao.IncomeDao
import bajeti.susac.co.ke.data.entity.Income


@Database(entities = [Income::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val incomeDao: IncomeDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "sleep_history_database"
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