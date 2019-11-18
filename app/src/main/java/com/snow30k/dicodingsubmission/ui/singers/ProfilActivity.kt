package com.snow30k.dicodingsubmission.ui.singers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.snow30k.dicodingsubmission.R

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "My Profil"
        }
    }
}
