package bajeti.susac.co.ke.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import bajeti.susac.co.ke.R
import bajeti.susac.co.ke.classes.IncomeClass
import bajeti.susac.co.ke.data.entity.Income
import bajeti.susac.co.ke.fragments.IncomeFragment
import kotlinx.android.synthetic.main.list_item_income.view.*

class IncomeRoomAdapter() :
    RecyclerView.Adapter<IncomeRoomAdapter.ViewHolder>() {

    private val incomeList: ArrayList<Income> = arrayListOf()

    //setting new list, avoid passing list as constructor

    fun setList(newList: ArrayList<Income>) {

        incomeList.clear()
        incomeList.addAll(newList)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IncomeRoomAdapter.ViewHolder {
        val inflatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_income, parent, false)
        return IncomeRoomAdapter.ViewHolder(inflatedView)
    }

    override fun getItemCount() = incomeList.size


    override fun onBindViewHolder(holder: IncomeRoomAdapter.ViewHolder, position: Int) {
        val income = incomeList[position]
        holder.bindIncome(income)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            // Do stuff
            Toast.makeText(v.context, "I was clicked!!!", Toast.LENGTH_LONG).show()
        }

        fun bindIncome(incomeItem: Income) {
            view.list_item_amount.text = incomeItem.incomeAmount.toString()
        }

        companion object {
            // Add companion objects such as: private val PHOTO_KEY = "PHOTO"
        }
    }
}