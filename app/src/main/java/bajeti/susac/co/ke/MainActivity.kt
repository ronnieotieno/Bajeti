package bajeti.susac.co.ke

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import bajeti.susac.co.ke.classes.IncomeClass
import bajeti.susac.co.ke.data.db.AppDatabase
import bajeti.susac.co.ke.data.entity.IncomeEntity
import bajeti.susac.co.ke.fragments.ExpensesFragment
import bajeti.susac.co.ke.fragments.HomeFragment
import bajeti.susac.co.ke.fragments.IncomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set initial fragment
        replaceFragment(HomeFragment())



        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.action_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.action_income -> {
                    replaceFragment(IncomeFragment())
                    true
                }
                R.id.action_expenses -> {
                    replaceFragment(ExpensesFragment())
                    true
                }
                else -> false
            }
        }
        bottom_navigation.setOnNavigationItemReselectedListener { item ->
            //Do nothing to avoid constant reloading
        }
    }

    private fun AppCompatActivity.replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}