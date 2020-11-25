package bajeti.susac.co.ke.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import bajeti.susac.co.ke.data.dao.IncomeDao
import bajeti.susac.co.ke.data.entity.IncomeEntity

@Database(entities = [IncomeEntity::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun incomeDao(): IncomeDao

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
                        "bajeti_database"
                    )
                        .addCallback(roomCallback)
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(INSTANCE!!)
            }
        }

        private fun populateDatabase(db: AppDatabase) {
            val dao = db.incomeDao()

            dao.insert(IncomeEntity(1, 1000, "Cash"))
            dao.insert(IncomeEntity(2, 1500, "Cash"))
            dao.insert(IncomeEntity(3, 600, "Fiverr"))
        }

    }
}