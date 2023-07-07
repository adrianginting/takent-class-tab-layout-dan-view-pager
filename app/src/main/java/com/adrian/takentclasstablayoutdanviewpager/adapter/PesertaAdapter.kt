package com.adrian.takentclasstablayoutdanviewpager.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.adrian.takentclasstablayoutdanviewpager.data.DataPeserta
import com.adrian.takentclasstablayoutdanviewpager.databinding.ItemRowProfileBinding
import com.adrian.takentclasstablayoutdanviewpager.fragment.ProfileDetailActivity

class PesertaAdapter (private val listProfile: ArrayList<DataPeserta>): RecyclerView.Adapter<PesertaAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, email, major, semester, photo) = listProfile[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemEmail.text = email
        holder.binding.tvItemMajor.text = major
        holder.binding.tvItemSemester.text = "Semester $semester"

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Membuka Profile $name", Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context, ProfileDetailActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("major", major)
            intent.putExtra("semester", semester)
            intent.putExtra("imageUri", photo)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listProfile.size

    class ListViewHolder(var binding: ItemRowProfileBinding) : RecyclerView.ViewHolder(binding.root)

}