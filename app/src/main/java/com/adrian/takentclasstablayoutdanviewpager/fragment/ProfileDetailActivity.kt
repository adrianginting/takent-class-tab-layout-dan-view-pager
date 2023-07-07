package com.adrian.takentclasstablayoutdanviewpager.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrian.takentclasstablayoutdanviewpager.R
import com.adrian.takentclasstablayoutdanviewpager.databinding.ActivityProfileDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class ProfileDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        getData()

    }

    private fun getData() {
        val extras = intent.extras

        if (extras != null) {
            binding.tvName.text = extras.getString("name")
            binding.tvEmail.text = extras.getString("email")
            binding.tvMajor.text = extras.getString("major")
            binding.tvSemester.text = extras.getString("semester")
            val resId: Int = extras.getInt("imageUri")

            Glide.with(this)
                .load(resId)
                .transform(CenterInside(), RoundedCorners(24))
                .placeholder(R.drawable.img_logo_talenthub)
                .into(binding.imgProfile)

            // button kembali ke activity sebelumnya
            binding.buttonBack.setOnClickListener {
                onBackPressed()
            }
        }
    }
}