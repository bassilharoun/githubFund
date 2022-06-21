package com.apps.coursekotlin0.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.apps.coursekotlin0.CarsApp.ui.BullsCarsActivity
import com.apps.coursekotlin0.MainActivity
import com.apps.coursekotlin0.R
import com.apps.coursekotlin0.calcapp.calcFragment
import com.apps.coursekotlin0.databinding.ActivityHomeBinding
import com.apps.coursekotlin0.resturantapp.ResturantMenuAc
import com.apps.coursekotlin0.todolistapp.ui.TodoListActivity

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCurrentFragment(TodoListActivity())
        val todoListFragment = TodoListActivity()
        val resturantFragment = ResturantMenuAc()
        val calcFragment = calcFragment()
        val bullsCarsFragment = BullsCarsActivity()

        binding.bottomNV.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miTodoList -> setCurrentFragment(todoListFragment)
                R.id.miResturant -> setCurrentFragment(resturantFragment)
                R.id.miCalc -> setCurrentFragment(bullsCarsFragment)
                R.id.miMain -> {
                    val intent = Intent(this , MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            true
        }

    }
    private fun setCurrentFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flfragmenthome, fragment)
        fragmentTransaction.commit()
    }
}