package com.duytien.youtobepre

import HomeFragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.duytien.youtobepre.button_navigation.ExploreFragment

import com.duytien.youtobepre.button_navigation.LibraryFragment
import com.duytien.youtobepre.button_navigation.SubscriptionsFragment
import com.duytien.youtobepre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener  {item->
            when(item.itemId){
                R.id.navigation_home ->{
                    openFragment(HomeFragment())
                    true
                }
                R.id.navigation_explore ->{
                    openFragment(ExploreFragment())
                    true
                }
                R.id.navigation_subscriptions ->{
                    openFragment(SubscriptionsFragment())
                    true
                }
                R.id.navigation_library ->{
                    openFragment(LibraryFragment())
                    true
                }
                else -> false
            }

        }


        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigation_home
        }
    }

    private fun openFragment(fragment: Fragment){
        supportFragmentManager.commit {
            replace(R.id.nav_host_fragment, fragment)

            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
}