package com.ubaya.thecook160418027.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ubaya.thecook160418027.util.MIGRATION_4_6

@Database(entities = arrayOf(Resep::class), version =  6)
abstract class Databases: RoomDatabase() {
    abstract fun todoDao(): DAO

    companion object {
        @Volatile private var instance: Databases ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                Databases::class.java,
                "resep").addMigrations(MIGRATION_4_6)
                .build()
        operator fun invoke(context:Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }

    }

}