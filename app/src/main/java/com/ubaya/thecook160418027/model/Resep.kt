package com.ubaya.thecook160418027.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Resep(
    @ColumnInfo(name="name")
    var name:String?,
    @ColumnInfo(name="bahan")
    var bahan:String?,
    @ColumnInfo(name="langkah")
    var langkah:String?,
    @ColumnInfo(name="imgUrl")
    var imgUrl:String?,
    @ColumnInfo(name="uuid")
    var uid:Int=1
)  {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}