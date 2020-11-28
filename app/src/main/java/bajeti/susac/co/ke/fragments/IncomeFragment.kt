package bajeti.susac.co.ke.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import bajeti.susac.co.ke.R
import bajeti.susac.co.ke.data.adapter.IncomeRoomAdapter
import bajeti.susac.co.ke.data.dao.IncomeDao
import bajeti.susac.co.ke.data.db.AppDatabase
import bajeti.susac.co.ke.data.entity.Income
import bajeti.susac.co.ke.databinding.FragmentIncomeBinding
import bajeti.susac.co.ke.toast
import kotlinx.android.synthetic.main.fragment_income.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.collections.ArrayList


/**
 * I have tried commenting, the following should atleast introduce you to livedata, higher order functions, extensions and viewbinding
 * Check changes in this class, adapter, in the dao, in the fragment_income xml, adapter item xml and gradle.
 */
class IncomeFragment : Fragment(R.layout.fragment_income) {
    //Kotlin higher order function, normally we don't want to perform lots of things in Adapter
    //so we pass the function as this
    private val incomeRoomAdapter = IncomeRoomAdapter { clicked: String -> toastClicked(clicked) }
    private lateinit var appDatabase: AppDatabase
    private lateinit var incomeDao: IncomeDao
    private lateinit var binding: FragmentIncomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentIncomeBinding.bind(view)

        appDatabase = AppDatabase.getInstance(requireContext())
        incomeDao = appDatabase.incomeDao

        binding.recyclerViewIncome.adapter = incomeRoomAdapter

        //initial initiation. just retrieving data without adding a new one, we have one function for both.
        //accessDbInBackground(null)

        //startObserving the Db for changes
        observeDb()

        // Add on click listener to addNewIncome button
        binding.addIncome.setOnClickListener {
            requireContext().toast("Data added")
            val income = Income("Hustle", 1000)
            accessDbInBackground(income)

        }
    }

    private fun observeDb() {
        //Any changes made will be accounted for
        //Set once and forget
        incomeDao.getAllLiveData().observe(viewLifecycleOwner, Observer {
            incomeRoomAdapter.setList(it as ArrayList<Income>)

        })
    }

    private fun accessDbInBackground(income: Income) {

        //Dispatchers.Main = MainThread
        //Dispatchers.Default = Background
        //Dispatchers.IO = When  making network call

        lifecycleScope.launch(Dispatchers.Default) {

            //we don't need to check this now
//            income?.let {
//
//            }
            incomeDao.insert(income)

            //we don't need this either, livedata will automatically update
            //incomeDao.getAll() as ArrayList<Income>

            //Now Switch to MainThread
            withContext(Dispatchers.Main) {
                //I have added livedata to  handle this
                // incomeRoomAdapter.setList(incomeList)
            }


        }
    }

    private fun toastClicked(clicked: String) {

        requireContext().toast(clicked)

    }
}
