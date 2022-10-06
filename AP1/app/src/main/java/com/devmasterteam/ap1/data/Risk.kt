package com.devmasterteam.ap1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Risk(
    var age: Int?,
    var gender: Int?,
    var weight: Int?,
    var physicalActivity: Int?,
    var smoker: Int?,
    var bloodPressure: Int?,
    var illnessesInTheFamily: Int?,
    var cholesterolLevel: Int?): Parcelable