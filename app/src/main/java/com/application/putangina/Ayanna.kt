package com.application.putangina

import android.app.AlertDialog
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import com.application.putangina.utilss.Johnny

class Ayanna(context: Context): ContextWrapper(context) {

    private var activityResult: ActivityResultLauncher<Array<String>>? = null

    fun isLackPermissions(): Boolean {
        return Johnny.PERMISSIONS.all {
            ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
        }
    }

    fun requestPermissions(activityResult: ActivityResultLauncher<Array<String>>) {
        this.activityResult = activityResult
        activityResult.launch(Johnny.PERMISSIONS.toTypedArray())
    }

    fun hasAllPermissionsGranted(): Boolean {
        return isLackPermissions()
    }

    fun showDialog() {
        val permissionDialog = AlertDialog.Builder(this)
        permissionDialog.setTitle("Permission Needed")
            .setMessage("Some permission needed to proceed. Please allow permission needed.")
            .setPositiveButton("OK"){
                dialog, _ ->
                dialog.dismiss()
                activityResult?.launch(Johnny.PERMISSIONS.toTypedArray())
            }
            .setNegativeButton("Cancel"){
                dialog, _ ->
                dialog.dismiss()
            }.create()

        permissionDialog.show()
    }
}