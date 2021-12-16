package com.ubaya.thecook160418027.model

import androidx.room.*

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg resep:Resep)

    @Query("SELECT * FROM resep")
    suspend fun selectAllResep(): List<Resep>

    @Query("SELECT * FROM resep WHERE id= :id")
    suspend fun selectResep(id:Int): Resep

    @Query("SELECT * FROM resep WHERE uuid= :uid")
    suspend fun selectResepUser(uid:Int): List<Resep>

    @Query("SELECT * FROM resep WHERE name LIKE :text")
    suspend fun selectResepWhere(text:String): List<Resep>

    @Query("UPDATE resep SET name=:name, bahan=:bahan, langkah=:langkah, imgUrl=:imgUrl WHERE id = :id")
    suspend fun updateResep(name:String, bahan:String, langkah:Int, imgUrl:String, id:Int)

    @Delete
    suspend fun deleteResep(resep:Resep)
}
