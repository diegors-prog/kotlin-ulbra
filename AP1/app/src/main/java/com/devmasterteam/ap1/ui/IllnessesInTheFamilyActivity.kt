package com.devmasterteam.ap1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.devmasterteam.ap1.R
import com.devmasterteam.ap1.data.Risk
import com.devmasterteam.ap1.databinding.ActivityIllnessesInTheFamilyBinding
import com.devmasterteam.ap1.infra.HeartRiskConstants

class IllnessesInTheFamilyActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityIllnessesInTheFamilyBinding
    private lateinit var lifeRisk: Risk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIllnessesInTheFamilyBinding.inflate(layoutInflater)
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
                    handleLifeRiskPerIllnessesInTheFamily(
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY.NO_KNOWN_HISTORY_OF_HEART_DISEASE)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY.NO_KNOWN_HISTORY_OF_HEART_DISEASE.toString()
                }
            }
            R.id.radio_2 -> {
                if (isChecked) {
                    handleLifeRiskPerIllnessesInTheFamily(
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY._1_RELATIVE_WITH_HEART_DISEASE_AND_OVER_60_YEARS)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY._1_RELATIVE_WITH_HEART_DISEASE_AND_OVER_60_YEARS.toString()
                }
            }
            R.id.radio_3 -> {
                if (isChecked) {
                    handleLifeRiskPerIllnessesInTheFamily(
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY._2_RELATIVE_WITH_HEART_DISEASE_AND_OVER_60_YEARS_OLD)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY._2_RELATIVE_WITH_HEART_DISEASE_AND_OVER_60_YEARS_OLD.toString()
                }
            }
            R.id.radio_4 -> {
                if (isChecked) {
                    handleLifeRiskPerIllnessesInTheFamily(
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY._1_RELATIVE_WITH_HEART_DISEASE_AND_UNDER_60_YEARS_OLD)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY._1_RELATIVE_WITH_HEART_DISEASE_AND_UNDER_60_YEARS_OLD.toString()
                }
            }
            R.id.radio_5 -> {
                if (isChecked) {
                    handleLifeRiskPerIllnessesInTheFamily(
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY._2_RELATIVE_WITH_HEART_DISEASE_AND_UNDER_60_YEARS_OLD)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY._2_RELATIVE_WITH_HEART_DISEASE_AND_UNDER_60_YEARS_OLD.toString()
                }
            }
            R.id.radio_6 -> {
                if (isChecked) {
                    handleLifeRiskPerIllnessesInTheFamily(
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY._3_RELATIVE_WITH_HEART_DISEASE_AND_UNDER_60_YEARS_OLD)
                    binding.textChosenRadioButton.text =
                        HeartRiskConstants.ILLNESSESLNTHEFAMILY._3_RELATIVE_WITH_HEART_DISEASE_AND_UNDER_60_YEARS_OLD.toString()
                }
            }
        }
    }

    private fun handleLifeRiskPerIllnessesInTheFamily(value: Int) {
        lifeRisk.illnessesInTheFamily = value
    }

    private fun sendTheRiskToTheNextScreen() {
        if (lifeRisk.illnessesInTheFamily != null) {
            val intent = Intent(this, CholesterolLevelActivity::class.java)
            intent.putExtra("risk", lifeRisk)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_life_risk, Toast.LENGTH_LONG).show()
        }
    }
}