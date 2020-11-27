package bajeti.susac.co.ke

import android.content.Context
import android.widget.Toast


//Extension functions
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}