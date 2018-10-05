package com.example.aroras.palan.Activity

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.example.aroras.palan.Fragments.MainScreenFragment
import com.example.aroras.palan.Adapters.NavigationDrawerAdapter
import com.example.aroras.palan.R

class MainActivity : AppCompatActivity() {

    var navigationDrawericonList :ArrayList<String> = arrayListOf()

    var images_for_navdrawer = intArrayOf(R.drawable.icon_home,R.drawable.icon_women,R.drawable.icon_men,
            R.drawable.icon_accessories,R.drawable.icon_themestore,R.drawable.icon_karmabucket,
            R.drawable.icon_ngo,R.drawable.icon_yourorders,R.drawable.icon_youraccount,R.drawable.icon_aboutus)

    object Statified{
    var drawerLayout : DrawerLayout ?=null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar =findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        MainActivity.Statified.drawerLayout = findViewById(R.id.drawer_layout)

        navigationDrawericonList.add("Home")
        navigationDrawericonList.add("Women")
        navigationDrawericonList.add("Men")
        navigationDrawericonList.add("Accessories")
        navigationDrawericonList.add("Theme Store")
        navigationDrawericonList.add("Karma Bucket")
        navigationDrawericonList.add("NGOs")
        navigationDrawericonList.add("Your Orders")
        navigationDrawericonList.add("Your Account")
        navigationDrawericonList.add("About Us")


        val toggle  = ActionBarDrawerToggle(this@MainActivity, Statified.drawerLayout,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        MainActivity.Statified.drawerLayout?.addDrawerListener(toggle)

        toggle.syncState()

        val mainScreenFragment= MainScreenFragment()

        this.supportFragmentManager.beginTransaction().
                add(R.id.details_fragment,mainScreenFragment,"MainScreenFragment").commit()


        val _navigationAdapter= NavigationDrawerAdapter(navigationDrawericonList, images_for_navdrawer
                , this)

        _navigationAdapter.notifyDataSetChanged()

        val navigation_recycler_view  =findViewById<RecyclerView>(R.id.navigation_recycler_view)

        navigation_recycler_view.layoutManager=LinearLayoutManager(this)
        navigation_recycler_view.itemAnimator=DefaultItemAnimator()
        navigation_recycler_view.adapter=_navigationAdapter
        navigation_recycler_view.setHasFixedSize(true)

    }

    override fun onStart() {
        super.onStart()
    }
}
