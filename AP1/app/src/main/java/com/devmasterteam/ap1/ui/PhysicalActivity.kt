package com.devmasterteam.ap1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.devmasterteam.ap1.R
import com.devmasterteam.ap1.data.Risk
import com.devmasterteam.ap1.databinding.ActivityPhysicalBinding
import com.devmasterteam.ap1.infra.HeartRiskConstants

class PhysicalActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityPhysicalBinding
    private lateinit var lifeRisk: Risk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhysicalBinding.inflate(layoutInflater)
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
                    handleLifeRiskPerPhysicalActivity(HeartRiskConstants.PHYSICAL.INTENSE_PROFESSIONAL_AND_RECREATIONAL_EFFORT)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.PHYSICAL.INTENSE_PROFESSIONAL_AND_RECREATIONAL_EFFORT.toString()
                }
            }
            R.id.radio_2 -> {
                if (isChecked) {
                    handleLifeRiskPerPhysicalActivity(HeartRiskConstants.PHYSICAL.MODERATE_PROFESSIONAL_AND_RECREATIONAL_EFFORT)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.PHYSICAL.MODERATE_PROFESSIONAL_AND_RECREATIONAL_EFFORT.toString()
                }
            }
            R.id.radio_3 -> {
                if (isChecked) {
                    handleLifeRiskPerPhysicalActivity(HeartRiskConstants.PHYSICAL.SEDENTARY_WORK_AND_INTENSE_RECREATIONAL_EFFORT)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.PHYSICAL.SEDENTARY_WORK_AND_INTENSE_RECREATIONAL_EFFORT.toString()
                }
            }
            R.id.radio_4 -> {
                if (isChecked) {
                    handleLifeRiskPerPhysicalActivity(HeartRiskConstants.PHYSICAL.SEDENTARY_WORK_AND_MODERATE_RECREATIONAL_EFFORT)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.PHYSICAL.SEDENTARY_WORK_AND_MODERATE_RECREATIONAL_EFFORT.toString()
                }
            }
            R.id.radio_5 -> {
                if (isChecked) {
                    handleLifeRiskPerPhysicalActivity(HeartRiskConstants.PHYSICAL.SEDENTARY_WORK_AND_LIGHT_RECREATIONAL_EFFORT)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.PHYSICAL.SEDENTARY_WORK_AND_LIGHT_RECREATIONAL_EFFORT.toString()
                }
            }
            R.id.radio_6 -> {
                if (isChecked) {
                    handleLifeRiskPerPhysicalActivity(HeartRiskConstants.PHYSICAL.COMPLETE_ABSENCE_OF_ANY_EXERCISE)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.PHYSICAL.COMPLETE_ABSENCE_OF_ANY_EXERCISE.toString()
                }
            }
        }
    }

    private fun handleLifeRiskPerPhysicalActivity(value: Int) {
        lifeRisk.physicalActivity = value
    }

    private fun sendTheRiskToTheNextScreen() {
        if (lifeRisk.physicalActivity != null) {
            val intent = Intent(this, SmokerActivity::class.java)
            intent.putExtra("risk", lifeRisk)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_life_risk, Toast.LENGTH_LONG).show()
        }
    }
}