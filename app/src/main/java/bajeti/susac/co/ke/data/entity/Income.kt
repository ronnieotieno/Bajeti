package bajeti.susac.co.ke.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "income_table")
data class Income (
    @ColumnInfo(name = "income_source") var incomeSource: String,
    @ColumnInfo(name = "income_amount") var incomeAmount: Int,
    @ColumnInfo(name="id") @PrimaryKey(autoGenerate = true) var id: Long = 0
)