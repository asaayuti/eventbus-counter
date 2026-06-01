package com.sayuti.eventbus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), CounterListener {

    private lateinit var homeFragment: HomeFragment
    private lateinit var controlFragment: ControlFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        homeFragment = HomeFragment()
        controlFragment = ControlFragment()

        // Activity inject dirinya sebagai listener ke ControlFragment
        controlFragment.listener = this

        supportFragmentManager.beginTransaction()
            .add(R.id.container_home, homeFragment)
            .add(R.id.container_control, controlFragment)
            .commit()
    }

    // Activity jadi bridge: nerima dari Control, terusin ke Home
    override fun onCounterChanged(newValue: Int) {
        homeFragment.updateCounter(newValue)
    }
}