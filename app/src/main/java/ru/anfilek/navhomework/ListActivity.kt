package ru.anfilek.navhomework

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.Manifest.permission.CAMERA as CAMERA_PERMISSION

class ListActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        findViewById<FloatingActionButton>(R.id.fabStartCamera).setOnClickListener {
            startCameraFeature()
        }

        findViewById<Button>(R.id.buttonItem).setOnClickListener {
            startItemActivity()
        }

    }
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 123
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun startCameraFeature() {
            handleCheckResult(checkPermission(CAMERA_PERMISSION), CAMERA_PERMISSION)
    }


    private fun checkPermission(permission: String): CheckPermissionResult {
        return when {
            Build.VERSION.SDK_INT < Build.VERSION_CODES.M -> CheckPermissionResult.GRANTED

            ContextCompat.checkSelfPermission(this, permission)
                    == PackageManager.PERMISSION_GRANTED -> CheckPermissionResult.GRANTED

            else -> CheckPermissionResult.DENIED
        }
    }

    private fun handleCheckResult(result: CheckPermissionResult, permission: String) {
        when(result){
            CheckPermissionResult.GRANTED -> startCameraActivity()
            CheckPermissionResult.DENIED -> failedGracefully(permission)
        }
    }

    private fun startCameraActivity(){
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }


    private fun failedGracefully(permission: String){
        AlertDialog.Builder(this)
                .setTitle("Camera permission")
                .setMessage("Camera permission was not granted. We respect your decision.")
                .setNegativeButton("Ok"){_, _ -> showOptionsPositive(permission)}
                .setPositiveButton("I changed my mind"){_, _ -> showOptionsNegative(permission)}
                .show()
    }

    private fun startItemActivity() {
        val intent = Intent(this, ItemActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showOptionsNegative(permission: String) {
        Toast.makeText(this, "No permission to use the camera", Toast.LENGTH_SHORT)
                .show()
    }

    private fun showOptionsPositive(permission: String){
        ActivityCompat.requestPermissions(this, arrayOf(permission), LOCATION_PERMISSION_REQUEST_CODE)
    }

}
enum class CheckPermissionResult {
    GRANTED,
    DENIED
}