package com.devmasterteam.ap1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.devmasterteam.ap1.R
import com.devmasterteam.ap1.data.Risk
import com.devmasterteam.ap1.databinding.ActivitySmokerBinding
import com.devmasterteam.ap1.infra.HeartRiskConstants

class SmokerActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivitySmokerBinding
    private lateinit var lifeRisk: Risk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmokerBinding.inflate(layoutInflater)
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
                    handleLifeRiskPerSmoker(HeartRiskConstants.SMOKER.NON_SMOKING)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.SMOKER.NON_SMOKING.toString()
                }
            }
            R.id.radio_2 -> {
                if (isChecked) {
                    handleLifeRiskPerSmoker(HeartRiskConstants.SMOKER.CIGAR_AND_OR_PIPE)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.SMOKER.CIGAR_AND_OR_PIPE.toString()
                }
            }
            R.id.radio_3 -> {
                if (isChecked) {
                    handleLifeRiskPerSmoker(HeartRiskConstants.SMOKER._10_CIGARRETES_OR_LESS_PER_DAY)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.SMOKER._10_CIGARRETES_OR_LESS_PER_DAY.toString()
                }
            }
            R.id.radio_4 -> {
                if (isChecked) {
                    handleLifeRiskPerSmoker(HeartRiskConstants.SMOKER._11_TO_20_CIGARRETES_PER_DAY)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.SMOKER._11_TO_20_CIGARRETES_PER_DAY.toString()
                }
            }
            R.id.radio_5 -> {
                if (isChecked) {
                    handleLifeRiskPerSmoker(HeartRiskConstants.SMOKER._21_TO_30_CIGARRETES_PER_DAY)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.SMOKER._21_TO_30_CIGARRETES_PER_DAY.toString()
                }
            }
            R.id.radio_6 -> {
                if (isChecked) {
                    handleLifeRiskPerSmoker(HeartRiskConstants.SMOKER.MORE_THAN_31_CIGARRETES_PER_DAY)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.SMOKER.MORE_THAN_31_CIGARRETES_PER_DAY.toString()
                }
            }
        }
    }

    private fun handleLifeRiskPerSmoker(value: Int) {
        lifeRisk.smoker = value
    }

    private fun sendTheRiskToTheNextScreen() {
        if (lifeRisk.smoker != null) {
            val intent = Intent(this, BloodPressureActivity::class.java)
            intent.putExtra("risk", lifeRisk)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_life_risk, Toast.LENGTH_LONG).show()
        }
    }
}