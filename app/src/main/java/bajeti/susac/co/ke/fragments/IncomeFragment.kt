package bajeti.susac.co.ke.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import bajeti.susac.co.ke.R
import bajeti.susac.co.ke.adapters.IncomeAdapter
import bajeti.susac.co.ke.classes.IncomeClass
import kotlinx.android.synthetic.main.fragment_income.*
import java.util.ArrayList

class IncomeFragment : Fragment() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    var incomeList: ArrayList<IncomeClass> = ArrayList()

    private lateinit var adapter: IncomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Add code
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_income, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManager = LinearLayoutManager(view.context)
        recycler_view_income.layoutManager = linearLayoutManager

        // Create a class
        for (i in 0 until 5){
            val income = IncomeClass(
                i+1,
                i * 1000,
                "Bank"
            )

            // Add classes to incomeList
            incomeList.add(income)
        }

        adapter = IncomeAdapter(incomeList)
        recycler_view_income.adapter = adapter

    }
}