package com.apps.coursekotlin0.CarsApp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.apps.coursekotlin0.CarsApp.utils.BullsCarsViewPagerAdapter
import com.apps.coursekotlin0.R
import com.apps.coursekotlin0.databinding.ActivityBullsCarsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class BullsCarsActivity : Fragment() {
    lateinit var binding: ActivityBullsCarsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityBullsCarsBinding.inflate(inflater,container,false)
        val view = binding.root
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPagerCars)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayoutCars)

        val listOfImages = listOf(R.drawable.ic_main,R.drawable.ic_archive,R.drawable.ic_calculate,R.drawable.ic_resturant)

        val myAdapter = BullsCarsViewPagerAdapter(listOfImages)
        binding.viewPagerCars.adapter = myAdapter
        TabLayoutMediator(tabLayout,viewPager){ tab , position ->
            tab.text = "Tab ${position + 1}"
        }.attach()
        return view
    }
    }
