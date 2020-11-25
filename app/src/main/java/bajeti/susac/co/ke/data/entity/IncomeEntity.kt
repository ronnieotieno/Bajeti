package bajeti.susac.co.ke.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "income_table")
data class IncomeEntity (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "amount")
    val amount: Int,

    @ColumnInfo(name = "source")
    val source: String
)