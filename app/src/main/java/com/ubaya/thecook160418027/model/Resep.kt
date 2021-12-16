package com.ubaya.thecook160418027.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Resep(
    @ColumnInfo(name="name")
    val name:String?,
    @ColumnInfo(name="bahan")
    val bahan:String?,
    @ColumnInfo(name="langkah")
    val langkah:String?,
    @ColumnInfo(name="imgUrl")
    val imgUrl:String?,
    @ColumnInfo(name="uuid")
    val uid:Int=1
)  {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}