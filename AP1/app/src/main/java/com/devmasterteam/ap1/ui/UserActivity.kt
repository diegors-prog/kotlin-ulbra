package com.devmasterteam.ap1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devmasterteam.ap1.R
import com.devmasterteam.ap1.databinding.ActivityUserBinding
import com.devmasterteam.ap1.infra.HeartRiskConstants
import com.devmasterteam.ap1.infra.SecurityPreferences

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.buttonSave.setOnClickListener(this)
        verifyUserName()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            handleSaveName()
        }
    }

    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(HeartRiskConstants.KEY.USER_NAME)
        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun handleSaveName() {
        val name = binding.editName.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString(HeartRiskConstants.KEY.USER_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, R.string.validation_life_risk, Toast.LENGTH_SHORT).show()
        }
    }
}