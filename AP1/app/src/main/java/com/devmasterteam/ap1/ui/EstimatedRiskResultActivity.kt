package com.devmasterteam.ap1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.devmasterteam.ap1.R
import com.devmasterteam.ap1.data.Risk
import com.devmasterteam.ap1.databinding.ActivityEstimatedRiskResultBinding
import com.devmasterteam.ap1.infra.HeartRiskConstants
import com.devmasterteam.ap1.infra.SecurityPreferences

class EstimatedRiskResultActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityEstimatedRiskResultBinding
    private lateinit var lifeRisk: Risk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEstimatedRiskResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        handleUserName()
        lifeRisk = intent.getParcelableExtra<Risk>("risk")!!
        resultRisk()

        binding.buttonFinish.setOnClickListener(this)
        binding.buttonBackInitial.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_finish) {
            finish()
        } else if (view.id == R.id.button_back_initial) {
            goToHomeScreen()
        }
    }

    private fun goToHomeScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(HeartRiskConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, $name!"
    }

    private fun resultRisk() {
        var result = lifeRisk.gender!! + lifeRisk.age!! + lifeRisk.weight!! + lifeRisk.physicalActivity!! + lifeRisk.smoker!! + lifeRisk.bloodPressure!! + lifeRisk.illnessesInTheFamily!! + lifeRisk.cholesterolLevel!!
        binding.textFinalResult.text = result.toString()
    }
}