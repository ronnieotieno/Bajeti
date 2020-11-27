package bajeti.susac.co.ke.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bajeti.susac.co.ke.R
import bajeti.susac.co.ke.data.entity.Income
import bajeti.susac.co.ke.databinding.FragmentIncomeBinding
import bajeti.susac.co.ke.databinding.ListItemIncomeBinding
import kotlinx.android.synthetic.main.list_item_income.view.*

class IncomeRoomAdapter(private val sendClicked: (String) -> Unit) :
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
    ): ViewHolder {
        return ViewHolder(
            ListItemIncomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = incomeList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val income = incomeList[position]
        holder.bindIncome(income, sendClicked)
    }

    class ViewHolder(private val binding: ListItemIncomeBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bindIncome(incomeItem: Income, sendClicked: (String) -> Unit) {

            binding.apply {
                listItemAmount.text = incomeItem.incomeAmount.toString()

                root.setOnClickListener {

                    sendClicked.invoke("I was clicked")

                }
            }

        }


    }
}