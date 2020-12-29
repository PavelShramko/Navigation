package ru.anfilek.navhomework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ItemActivity : AppCompatActivity() {

    private val userLogin: UserLogin by lazy { UserLogin(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        findViewById<Button>(R.id.startAgainButton).setOnClickListener {
            startMeAgain()
        }

        findViewById<Button>(R.id.logout).setOnClickListener {
            logout()
        }

        renderItemId(intent.getIntExtra("tvItemId", 0))
    }

    private fun renderItemId(number: Int) {
        findViewById<TextView>(R.id.tvItemId).text = "$number"
    }

    private fun startMeAgain() {
        val intent = Intent(this, ItemActivity::class.java)
        val tvItemId = findViewById<TextView>(R.id.tvItemId).text.toString()
        intent.putExtra("tvItemId", tvItemId.toInt() + 1)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun logout() {
        userLogin.setUserLoggedOut()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}