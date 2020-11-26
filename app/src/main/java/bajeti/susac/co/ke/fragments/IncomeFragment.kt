package bajeti.susac.co.ke.fragments

import android.content.Context
import android.content.DialogInterface
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import bajeti.susac.co.ke.R
import bajeti.susac.co.ke.adapters.IncomeAdapter
import bajeti.susac.co.ke.classes.IncomeClass
import bajeti.susac.co.ke.data.adapter.IncomeRoomAdapter
import bajeti.susac.co.ke.data.dao.IncomeDao
import bajeti.susac.co.ke.data.db.AppDatabase
import bajeti.susac.co.ke.data.entity.Income
import kotlinx.android.synthetic.main.fragment_income.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

class IncomeFragment : Fragment() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var incomeList: ArrayList<Income> = ArrayList()


    private lateinit var incomeRoomAdapter: IncomeRoomAdapter

    private lateinit var appDatabase: AppDatabase
    private lateinit var incomeDao: IncomeDao

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

        // Set up database
        appDatabase = AppDatabase.getInstance(view.context)
        incomeDao = appDatabase.incomeDao


        // Set up adapter
        incomeRoomAdapter = IncomeRoomAdapter(incomeList)
        recycler_view_income.adapter = incomeRoomAdapter


        // Add on click listener to addNewIncome button
        add_income.setOnClickListener {
            Toast.makeText(context, "Data added", Toast.LENGTH_LONG).show()
            val income = Income("Hustle", 1000)
            incomeList.add(income)

            // Save to db
            AsyncTask.execute {
                incomeDao.insert(income)
                incomeList = incomeDao.getAll() as ArrayList<Income>

            }
            incomeRoomAdapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        AsyncTask.execute {
            incomeList = incomeDao.getAll() as ArrayList<Income>
        }
        incomeRoomAdapter.notifyDataSetChanged()
    }
}
