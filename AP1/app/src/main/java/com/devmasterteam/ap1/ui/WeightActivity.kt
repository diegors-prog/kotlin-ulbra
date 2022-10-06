package com.devmasterteam.ap1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.devmasterteam.ap1.R
import com.devmasterteam.ap1.data.Risk
import com.devmasterteam.ap1.databinding.ActivityWeightBinding
import com.devmasterteam.ap1.infra.HeartRiskConstants

class WeightActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityWeightBinding
    private lateinit var lifeRisk: Risk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeightBinding.inflate(layoutInflater)
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
                    handleLifeRiskPerWeight(HeartRiskConstants.WEIGHT.LESS_THAN_2_KG_OF_NORMAL_WEIGHT)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.WEIGHT.LESS_THAN_2_KG_OF_NORMAL_WEIGHT.toString()
                }
            }
            R.id.radio_2 -> {
                if (isChecked) {
                    handleLifeRiskPerWeight(HeartRiskConstants.WEIGHT.LESS_THAN_2_TO_MORE_THAN_2_KG_OF_NORMAL_WEIGHT)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.WEIGHT.LESS_THAN_2_TO_MORE_THAN_2_KG_OF_NORMAL_WEIGHT.toString()
                }
            }
            R.id.radio_3 -> {
                if (isChecked) {
                    handleLifeRiskPerWeight(HeartRiskConstants.WEIGHT.FROM_2_TO_9_KG_ABOVE_NORMAL_WEIGHT)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.WEIGHT.FROM_2_TO_9_KG_ABOVE_NORMAL_WEIGHT.toString()
                }
            }
            R.id.radio_4 -> {
                if (isChecked) {
                    handleLifeRiskPerWeight(HeartRiskConstants.WEIGHT.FROM_9_TO_16_KG_ABOVE_NORMAL_WEIGHT)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.WEIGHT.FROM_9_TO_16_KG_ABOVE_NORMAL_WEIGHT.toString()
                }
            }
            R.id.radio_5 -> {
                if (isChecked) {
                    handleLifeRiskPerWeight(HeartRiskConstants.WEIGHT.FROM_16_TO_23_KG_ABOVE_NORMAL_WEIGHT)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.WEIGHT.FROM_16_TO_23_KG_ABOVE_NORMAL_WEIGHT.toString()
                }
            }
            R.id.radio_6 -> {
                if (isChecked) {
                    handleLifeRiskPerWeight(HeartRiskConstants.WEIGHT.MORE_THAN_23_KG_OVER_NORMAL_WEIGHT)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.WEIGHT.MORE_THAN_23_KG_OVER_NORMAL_WEIGHT.toString()
                }
            }
        }
    }

    private fun handleLifeRiskPerWeight(value: Int) {
        lifeRisk.weight = value
    }

    private fun sendTheRiskToTheNextScreen() {
        if (lifeRisk.weight != null) {
            val intent = Intent(this, PhysicalActivity::class.java)
            intent.putExtra("risk", lifeRisk)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_life_risk, Toast.LENGTH_LONG).show()
        }
    }
}