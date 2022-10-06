package com.devmasterteam.ap1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.devmasterteam.ap1.infra.HeartRiskConstants
import com.devmasterteam.ap1.R
import com.devmasterteam.ap1.data.Risk
import com.devmasterteam.ap1.databinding.ActivityMainBinding
import com.devmasterteam.ap1.infra.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var lifeRisk: Risk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        lifeRisk = Risk(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null)

        handleUserName()

        //eventos
        binding.radio1.setOnCheckedChangeListener(this)
        binding.radio2.setOnCheckedChangeListener(this)
        binding.radio3.setOnCheckedChangeListener(this)
        binding.radio4.setOnCheckedChangeListener(this)
        binding.radio5.setOnCheckedChangeListener(this)
        binding.radio6.setOnCheckedChangeListener(this)

        binding.buttonNext.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_next) {
            sendTheRiskToTheNextScreen()
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.radio_1 -> {
                if (isChecked) {
                    handleLifeRiskPerAge(HeartRiskConstants.AGE.FROM_10_TO_20)
                    binding.textChosenRadioButton.text = HeartRiskConstants.AGE.FROM_10_TO_20.toString()
                }
            }
            R.id.radio_2 -> {
                if (isChecked) {
                    handleLifeRiskPerAge(HeartRiskConstants.AGE.FROM_21_TO_30)
                    binding.textChosenRadioButton.text = HeartRiskConstants.AGE.FROM_21_TO_30.toString()
                }
            }
            R.id.radio_3 -> {
                if (isChecked) {
                    handleLifeRiskPerAge(HeartRiskConstants.AGE.FROM_31_TO_40)
                    binding.textChosenRadioButton.text = HeartRiskConstants.AGE.FROM_31_TO_40.toString()
                }
            }
            R.id.radio_4 -> {
                if (isChecked) {
                    handleLifeRiskPerAge(HeartRiskConstants.AGE.FROM_41_TO_50)
                    binding.textChosenRadioButton.text = HeartRiskConstants.AGE.FROM_41_TO_50.toString()
                }
            }
            R.id.radio_5 -> {
                if (isChecked) {
                    handleLifeRiskPerAge(HeartRiskConstants.AGE.FROM_51_TO_60)
                    binding.textChosenRadioButton.text = HeartRiskConstants.AGE.FROM_51_TO_60.toString()
                }
            }
            R.id.radio_6 -> {
                if (isChecked) {
                    handleLifeRiskPerAge(HeartRiskConstants.AGE.OVER_61)
                    binding.textChosenRadioButton.text = HeartRiskConstants.AGE.OVER_61.toString()
                }
            }
        }
    }

    private fun handleLifeRiskPerAge(value: Int) {
        lifeRisk.age = value
    }

    private fun sendTheRiskToTheNextScreen() {
        if (lifeRisk.age != null) {
            val intent = Intent(this, GenderActivity::class.java)
            intent.putExtra("risk", lifeRisk)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_life_risk, Toast.LENGTH_LONG).show()
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(HeartRiskConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, $name!"
    }
}