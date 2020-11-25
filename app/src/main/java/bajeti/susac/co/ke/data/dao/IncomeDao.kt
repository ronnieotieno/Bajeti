package bajeti.susac.co.ke.data.dao

import android.icu.util.CurrencyAmount
import androidx.room.*
import java.security.CodeSource

@Dao
interface Income {
    @Query("SELECT * FROM income_table ORDER BY id ASC")
    fun getIncome(): List<Income>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(amount: CurrencyAmount, source: CodeSource)

    @Delete
    suspend fun delete(income: Income)

    @Query("DELETE FROM income_table")
    fun deleteAll()
}