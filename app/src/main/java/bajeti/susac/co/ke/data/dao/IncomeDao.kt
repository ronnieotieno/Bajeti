package bajeti.susac.co.ke.data.dao

import android.icu.util.CurrencyAmount
import androidx.lifecycle.LiveData
import androidx.room.*
import bajeti.susac.co.ke.data.entity.IncomeEntity
import kotlinx.coroutines.flow.Flow
import java.security.CodeSource
import java.sql.RowId

@Dao
interface IncomeDao {

    @Query("SELECT * FROM income_table ORDER BY id ASC")
    fun getAllItems(): Flow<List<IncomeEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(incomeEntity: IncomeEntity)

    @Update
    fun update(vararg income: IncomeEntity)

    @Query("DELETE FROM income_table")
    suspend fun deleteAll()

    @Delete
    fun delete(income: IncomeEntity)
}