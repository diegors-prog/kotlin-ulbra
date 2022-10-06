package com.devmasterteam.ap1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.devmasterteam.ap1.R
import com.devmasterteam.ap1.data.Risk
import com.devmasterteam.ap1.databinding.ActivityBloodPressureBinding
import com.devmasterteam.ap1.infra.HeartRiskConstants

class BloodPressureActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityBloodPressureBinding
    private lateinit var lifeRisk: Risk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBloodPressureBinding.inflate(layoutInflater)
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
                    handleLifeRiskPerBloodPressure(HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_FROM_100_TO_119_MMHG)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_FROM_100_TO_119_MMHG.toString()
                }
            }
            R.id.radio_2 -> {
                if (isChecked) {
                    handleLifeRiskPerBloodPressure(HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_FROM_120_TO_139_MMHG)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_FROM_120_TO_139_MMHG.toString()
                }
            }
            R.id.radio_3 -> {
                if (isChecked) {
                    handleLifeRiskPerBloodPressure(HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_FROM_140_TO_159_MMHG)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_FROM_140_TO_159_MMHG.toString()
                }
            }
            R.id.radio_4 -> {
                if (isChecked) {
                    handleLifeRiskPerBloodPressure(HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_FROM_160_TO_179_MMHG)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_FROM_160_TO_179_MMHG.toString()
                }
            }
            R.id.radio_5 -> {
                if (isChecked) {
                    handleLifeRiskPerBloodPressure(HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_FROM_180_TO_199_MMHG)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_FROM_180_TO_199_MMHG.toString()
                }
            }
            R.id.radio_6 -> {
                if (isChecked) {
                    handleLifeRiskPerBloodPressure(HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_OF_200_MMHG_OR_MORE)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.BLOODPRESSURE.SYSTOLIC_OF_200_MMHG_OR_MORE.toString()
                }
            }
        }
    }

    private fun handleLifeRiskPerBloodPressure(value: Int) {
        lifeRisk.bloodPressure = value
    }

    private fun sendTheRiskToTheNextScreen() {
        if (lifeRisk.bloodPressure != null) {
            val intent = Intent(this, IllnessesInTheFamilyActivity::class.java)
            intent.putExtra("risk", lifeRisk)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_life_risk, Toast.LENGTH_LONG).show()
        }
    }
}