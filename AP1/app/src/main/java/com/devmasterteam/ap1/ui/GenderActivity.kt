package com.devmasterteam.ap1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.devmasterteam.ap1.R
import com.devmasterteam.ap1.data.Risk
import com.devmasterteam.ap1.databinding.ActivityGenderBinding
import com.devmasterteam.ap1.infra.HeartRiskConstants

class GenderActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityGenderBinding
    private lateinit var lifeRisk: Risk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        lifeRisk = intent.getParcelableExtra<Risk>("risk")!!


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
                    handleLifeRiskPerGender(HeartRiskConstants.GENDER.FEMALE_UNDER_40)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.GENDER.FEMALE_UNDER_40.toString()
                }
            }
            R.id.radio_2 -> {
                if (isChecked) {
                    handleLifeRiskPerGender(HeartRiskConstants.GENDER.FEMALE_FROM_40_TO_50)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.GENDER.FEMALE_FROM_40_TO_50.toString()
                }
            }
            R.id.radio_3 -> {
                if (isChecked) {
                    handleLifeRiskPerGender(HeartRiskConstants.GENDER.FEMALE_OVER_50)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.GENDER.FEMALE_OVER_50.toString()
                }
            }
            R.id.radio_4 -> {
                if (isChecked) {
                    handleLifeRiskPerGender(HeartRiskConstants.GENDER.MALE)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.GENDER.MALE.toString()
                }
            }
            R.id.radio_5 -> {
                if (isChecked) {
                    handleLifeRiskPerGender(HeartRiskConstants.GENDER.SMALL_STATURE_MALE)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.GENDER.SMALL_STATURE_MALE.toString()
                }
            }
            R.id.radio_6 -> {
                if (isChecked) {
                    handleLifeRiskPerGender(HeartRiskConstants.GENDER.SMALL_AND_BALD_MALE)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.GENDER.SMALL_AND_BALD_MALE.toString()
                }
            }
        }
    }

    private fun handleLifeRiskPerGender(value: Int) {
        lifeRisk.gender = value
    }

    private fun sendTheRiskToTheNextScreen() {
        if (lifeRisk.gender != null) {
            val intent = Intent(this, WeightActivity::class.java)
            intent.putExtra("risk", lifeRisk)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_life_risk, Toast.LENGTH_LONG).show()
        }
    }
}