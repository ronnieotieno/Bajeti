package bajeti.susac.co.ke.classes

import android.util.Log
import java.io.Serializable
import java.lang.Exception

class IncomeClass(id:Int, amount: Int, source: String): Serializable {
    private var id: Int? = 0
    var amount: Int? = 0
    lateinit var source: String

    init {
        try {
            this.id = id
            this.amount = amount
            this.source = source
        } catch (e: Exception){
            Log.d("Error:", "$e")
        }
    }
}