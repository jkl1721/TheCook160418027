package com.ubaya.thecook160418027.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.thecook160418027.R
import android.content.Context
import android.os.Build
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ubaya.thecook160418027.model.Databases

val DB_NAME = "resep"
fun buildDb(context: Context): Databases {
    val db = Room.databaseBuilder(context, Databases::class.java, DB_NAME).addMigrations(MIGRATION_4_6)
        .build()
    return db
}
val MIGRATION_4_6 = object : Migration(4, 6) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE resep RENAME COLUMN uid TO uuid")
    }
}

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}
@BindingAdapter("android:imageUrl","android:progressBar")
fun loadPhotoUrl(view:ImageView, url:String?, pb:ProgressBar){
    view.loadImage(url,pb)
}

fun createNotificationChannel(context: Context, importance: Int, showBadge:
Boolean, name: String, description: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelId = "${context.packageName}-$name"
        val channel = NotificationChannel(channelId, name, importance)
        channel.description = description
        channel.setShowBadge(showBadge)
        val notificationManager =
            context.getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
}