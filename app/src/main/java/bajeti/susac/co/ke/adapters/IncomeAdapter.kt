package bajeti.susac.co.ke.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import bajeti.susac.co.ke.R
import bajeti.susac.co.ke.classes.IncomeClass
import kotlinx.android.synthetic.main.list_item_income.view.*

class IncomeAdapter(private val incomeList: ArrayList<IncomeClass>) : RecyclerView.Adapter<IncomeAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_income, parent, false)
        return ViewHolder(inflatedView)
    }


    override fun getItemCount() = incomeList.size


    override fun onBindViewHolder(holder: IncomeAdapter.ViewHolder, position: Int) {
        val income = incomeList[position]
        holder.bindIncome(income)
    }


    //1
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            // Do stuff
            Toast.makeText(v.context, "I was clicked!!!", Toast.LENGTH_LONG).show()
        }

        fun bindIncome(incomeItem: IncomeClass) {
            view.list_item_amount.text = incomeItem.amount.toString()
        }

        companion object {
            private val PHOTO_KEY = "PHOTO"
        }
    }


}
