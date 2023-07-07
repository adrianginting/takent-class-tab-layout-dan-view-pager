package com.adrian.takentclasstablayoutdanviewpager.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrian.takentclasstablayoutdanviewpager.R
import com.adrian.takentclasstablayoutdanviewpager.adapter.PesertaAdapter
import com.adrian.takentclasstablayoutdanviewpager.data.DataPeserta
import com.adrian.takentclasstablayoutdanviewpager.databinding.FragmentBatch7Binding


class Batch7Fragment : Fragment() {

    private var _binding: FragmentBatch7Binding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<DataPeserta>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBatch7Binding.inflate(inflater, container, false)

        binding.rvBatch7.setHasFixedSize(true)
        list.addAll(getListData())
        showRecyclerList()

        return binding.root
    }

    private fun getListData(): ArrayList<DataPeserta>{
        val dataName = resources.getStringArray(R.array.data_name_batch7)
        val dataEmail = resources.getStringArray(R.array.data_email_batch7)
        val dataMajor = resources.getStringArray(R.array.data_major_batch7)
        val dataSemester = resources.getStringArray(R.array.data_semester_batch7)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo_batch7)
        val listProfile = ArrayList<DataPeserta>()
        for (i in dataName.indices) {
            val profile = DataPeserta(dataName[i], dataEmail[i], dataMajor[i], dataSemester[i], dataPhoto.getResourceId(i, -1))
            listProfile.add(profile)
        }
        return listProfile
    }

    private fun showRecyclerList() {
        binding.rvBatch7.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val listBatch7Adapter = PesertaAdapter(list)
        binding.rvBatch7.adapter = listBatch7Adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}