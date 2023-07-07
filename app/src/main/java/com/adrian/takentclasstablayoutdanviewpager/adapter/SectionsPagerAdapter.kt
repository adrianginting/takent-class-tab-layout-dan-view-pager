package com.adrian.takentclasstablayoutdanviewpager.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.adrian.takentclasstablayoutdanviewpager.fragment.Batch7Fragment
import com.adrian.takentclasstablayoutdanviewpager.fragment.Batch8Fragment

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return  2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = Batch7Fragment()
            1 -> fragment = Batch8Fragment()
        }
        return fragment as Fragment
    }

}