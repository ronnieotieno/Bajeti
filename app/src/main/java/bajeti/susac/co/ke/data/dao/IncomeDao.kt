package bajeti.susac.co.ke.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import bajeti.susac.co.ke.data.entity.Income

@Dao
interface IncomeDao {

    @Query("SELECT * FROM income_table")
    fun getAll(): List<Income>

    @Query("SELECT * FROM income_table")
    fun getAllLiveData(): LiveData<List<Income>>

    @Insert
    fun insertAll(vararg incomeList: Income)

    @Insert
    fun insert(income: Income)
}