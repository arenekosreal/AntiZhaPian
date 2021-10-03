package com.demo.antizha

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.navigation.fragment.NavHostFragment
import com.demo.antizha.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navView.itemBackground = null

        binding.navView.menu.forEach {
            val view = binding.navView.findViewById<View>(it.itemId)
            view.setOnLongClickListener { true }
        }

        binding.navView.setOnNavigationItemSelectedListener { item ->
            resetIcon(binding.navView)
            when (item.itemId) {
                R.id.navigation_home -> {
                    item.setIcon(R.drawable.ic_home_seled)
                    navController.navigate(R.id.navigation_home)
                    true
                }
                R.id.navigation_dashboard -> {
                    item.setIcon(R.drawable.ic_dashboard_seled)
                    navController.navigate(R.id.navigation_dashboard)
                    true
                }
                R.id.navigation_notifications -> {
                    item.setIcon(R.drawable.ic_mine_seled)
                    navController.navigate(R.id.navigation_notifications)
                    true
                }
                else -> false
            }
        }
    }

    private fun resetIcon(navView: BottomNavigationView) {
        val home = navView.menu.findItem(R.id.navigation_home)
        val dashboard = navView.menu.findItem(R.id.navigation_dashboard)
        val mine = navView.menu.findItem(R.id.navigation_notifications)
        home.setIcon(R.drawable.ic_home_unseled)
        dashboard.setIcon(R.drawable.ic_dashboard_unseled)
        mine.setIcon(R.drawable.ic_mine_unseled)
    }
}