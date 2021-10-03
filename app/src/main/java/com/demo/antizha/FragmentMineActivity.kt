package com.demo.antizha

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.antizha.databinding.FragmentMineBinding

class FragmentMineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=FragmentMineBinding.inflate(layoutInflater)
        val dictChars = mutableListOf<Char>().apply { "123456789".forEach { this.add(it) } }
        val prefix = (130..159).random()
        var suffix= StringBuilder().apply { (1..2).onEach { append(dictChars.random()) } }
        var finalStr="您好, ${prefix}******${suffix}"
        binding.phoneNumber.text=finalStr
    }
}