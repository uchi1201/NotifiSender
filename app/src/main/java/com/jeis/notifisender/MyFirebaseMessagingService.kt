package com.jeis.notifisender

import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        showNotification(
            remoteMessage.notification?.title,
            remoteMessage.notification?.body
        )
    }

    override fun onNewToken(token: String) {
        Log.i("FIREBASE", "[SERVICE] Token = $token")
    }

    fun showNotification(title: String?, message: String?) {
        val builder = NotificationCompat.Builder(this, "MyNotification").apply {
            setContentTitle(title)
            setAutoCancel(true)
            setContentText(message)
        }
        NotificationManagerCompat.from(this).notify(999, builder.build())
    }
}