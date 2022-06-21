package com.apps.coursekotlin0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apps.coursekotlin0.databinding.ActivityCorotuineExBinding
import kotlinx.coroutines.*
import kotlin.math.log

class CorotuineEx : AppCompatActivity() {
    lateinit var binding: ActivityCorotuineExBinding
    val tag = "CorotuineExample"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCorotuineExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch(Dispatchers.IO) {
            val result1 = async { doNetworkCall1() }
            val result2 = async { doNetworkCall2() }
            Log.d(tag,"Result 1 equal to : ${result1.await()}")
            Log.d(tag,"Result 2 equal to : ${result2.await()}")
        }


    }
    suspend fun doNetworkCall1():String{
        delay(3000L)
        return "Networ call result 1"
    }
    suspend fun doNetworkCall2():String{
        delay(3000L)
        return "Networ call result 2"
    }

}