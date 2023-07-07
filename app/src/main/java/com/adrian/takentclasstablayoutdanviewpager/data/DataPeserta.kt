package com.adrian.takentclasstablayoutdanviewpager.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPeserta(
      val name: String,
      val email: String,
      val major: String,
      val semester: String,
      val photo: Int
): Parcelable
