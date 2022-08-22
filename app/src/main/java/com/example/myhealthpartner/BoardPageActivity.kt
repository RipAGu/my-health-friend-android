package com.example.myhealthpartner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerAdap(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    val tab1Fragment = BoardPageMyTownFragment()
    val tab2Fragment = BoardPageExerciseFragment()
    override fun getItemCount(): Int {
        return 2
    }


    override fun createFragment(position: Int): Fragment {
        if(position == 0) return tab1Fragment
        else return tab2Fragment
    }
}

class BoardPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.board_page_layout)

        val viewPager2 = findViewById<ViewPager2>(R.id.fragmentBox)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val viewPagerFragment = ViewPagerAdap(this)
        viewPager2.adapter = viewPagerFragment

        val tabTitle = listOf("우리동네 게시판", "운동TIp 게시판")
        TabLayoutMediator(tabLayout, viewPager2, {tab, position -> tab.text = tabTitle[position]}).attach()
        initEvent()
    }

    fun navEvent(){
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navBtn = findViewById<ImageButton>(R.id.navBtn)
        val navProfileBtn = findViewById<TextView>(R.id.navProfileBtn)
        val navmatchingBtn = findViewById<TextView>(R.id.navMatchingBtn)
        val navBoardBtn = findViewById<TextView>(R.id.navBoardBtn)
        val navHistoryBtn = findViewById<TextView>(R.id.navHistoryBtn)
        navBtn.setOnClickListener{
            drawerLayout.openDrawer(GravityCompat.START)
        }
        navProfileBtn.setOnClickListener{
            val intent = Intent(applicationContext, MyProfilePageActivity::class.java)
            startActivity(intent)
        }

        navHistoryBtn.setOnClickListener{
            val intent = Intent(applicationContext, MatchingHistoryActivity::class.java)
            startActivity(intent)
            finish()
        }

        navmatchingBtn.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        navBoardBtn.setOnClickListener{
            val intent = Intent(applicationContext, BoardPageActivity::class.java)
            startActivity(intent)
        }
    }

    fun initEvent(){
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navBtn = findViewById<ImageButton>(R.id.navBtn)
        navEvent()


    }

}