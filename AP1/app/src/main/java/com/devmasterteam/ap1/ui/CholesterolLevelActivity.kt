package com.devmasterteam.ap1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.devmasterteam.ap1.R
import com.devmasterteam.ap1.data.Risk
import com.devmasterteam.ap1.databinding.ActivityCholesterolLevelBinding
import com.devmasterteam.ap1.infra.HeartRiskConstants

class CholesterolLevelActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityCholesterolLevelBinding
    private  lateinit var lifeRisk: Risk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCholesterolLevelBinding.inflate(layoutInflater)
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
                    handleLifeRiskPerCholesterolLevel(
                        HeartRiskConstants.CHOLESTEROLLEVEL.BELOW_180_OR_THE_DIET_DOES_NOT_CONTAIN_ANIMAL_FATS)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.CHOLESTEROLLEVEL.BELOW_180_OR_THE_DIET_DOES_NOT_CONTAIN_ANIMAL_FATS.toString()
                }
            }
            R.id.radio_2 -> {
                if (isChecked) {
                    handleLifeRiskPerCholesterolLevel(
                        HeartRiskConstants.CHOLESTEROLLEVEL.FROM_181_TO_205_OR_THE_DIET_CONTAINS_10_PERCENT_ANIMAL_FATS)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.CHOLESTEROLLEVEL.FROM_181_TO_205_OR_THE_DIET_CONTAINS_10_PERCENT_ANIMAL_FATS.toString()
                }
            }
            R.id.radio_3 -> {
                if (isChecked) {
                    handleLifeRiskPerCholesterolLevel(
                        HeartRiskConstants.CHOLESTEROLLEVEL.FROM_206_TO_230_OR_THE_DIET_CONTAINS_20_PERCENT_ANIMAL_FATS)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.CHOLESTEROLLEVEL.FROM_206_TO_230_OR_THE_DIET_CONTAINS_20_PERCENT_ANIMAL_FATS.toString()
                }
            }
            R.id.radio_4 -> {
                if (isChecked) {
                    handleLifeRiskPerCholesterolLevel(
                        HeartRiskConstants.CHOLESTEROLLEVEL.FROM_231_TO_255_OR_THE_DIET_CONTAINS_30_PERCENT_ANIMAL_FATS)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.CHOLESTEROLLEVEL.FROM_231_TO_255_OR_THE_DIET_CONTAINS_30_PERCENT_ANIMAL_FATS.toString()
                }
            }
            R.id.radio_5 -> {
                if (isChecked) {
                    handleLifeRiskPerCholesterolLevel(
                        HeartRiskConstants.CHOLESTEROLLEVEL.FROM_256_TO_280_OR_THE_DIET_CONTAINS_40_PERCENT_ANIMAL_FATS)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.CHOLESTEROLLEVEL.FROM_256_TO_280_OR_THE_DIET_CONTAINS_40_PERCENT_ANIMAL_FATS.toString()
                }
            }
            R.id.radio_6 -> {
                if (isChecked) {
                    handleLifeRiskPerCholesterolLevel(
                        HeartRiskConstants.CHOLESTEROLLEVEL.ABOVE_281__OR_THE_DIET_CONTAINS_50_PERCENT_ANIMAL_FATS)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.CHOLESTEROLLEVEL.ABOVE_281__OR_THE_DIET_CONTAINS_50_PERCENT_ANIMAL_FATS.toString()
                }
            }
        }
    }

    private fun handleLifeRiskPerCholesterolLevel(value: Int) {
        lifeRisk.cholesterolLevel = value
    }

    private fun sendTheRiskToTheNextScreen() {
        if (lifeRisk.cholesterolLevel != null) {
            val intent = Intent(this, EstimatedRiskResultActivity::class.java)
            intent.putExtra("risk", lifeRisk)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_life_risk, Toast.LENGTH_LONG).show()
        }
    }
}