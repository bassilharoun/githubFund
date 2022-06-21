package com.apps.coursekotlin0.resturantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.apps.coursekotlin0.databinding.ActivityResturantMenuBinding

class ResturantMenuAc : Fragment() {
    private lateinit var binding: ActivityResturantMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityResturantMenuBinding.inflate(inflater,container,false)
        val view = binding.root
        binding.btnOrder.setOnClickListener {
            val checkedRbId = binding.rgMeals.checkedRadioButtonId
            val kindOfBurger = view?.findViewById<RadioButton>(checkedRbId)
            val cheese = binding.chkCheese.isChecked
            val salad = binding.chkSalad.isChecked
            val tahini = binding.chkTahini.isChecked
            val totalOrder =  "You order ${kindOfBurger?.text} burger with " + (if (cheese)"Cheese" else "") +
                    (if (salad)"Salad" else "") +
                    (if (tahini)"Tahini" else "")
            binding.tvTotal.text = totalOrder
        }
        return view
    }



}