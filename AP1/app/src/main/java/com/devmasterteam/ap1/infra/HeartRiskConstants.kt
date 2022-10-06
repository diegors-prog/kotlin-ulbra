package com.devmasterteam.ap1.infra

class HeartRiskConstants private constructor() {

    object KEY {
        const val USER_NAME = "USER_NAME"
    }

    object AGE {
        const val FROM_10_TO_20 = 1
        const val FROM_21_TO_30 = 2
        const val FROM_31_TO_40 = 3
        const val FROM_41_TO_50 = 4
        const val FROM_51_TO_60 = 6
        const val OVER_61 = 8
    }

    object GENDER {
        const val FEMALE_UNDER_40 = 1
        const val FEMALE_FROM_40_TO_50 = 2
        const val FEMALE_OVER_50 = 3
        const val MALE = 4
        const val SMALL_STATURE_MALE = 6
        const val SMALL_AND_BALD_MALE = 7
    }

    object WEIGHT {
        const val LESS_THAN_2_KG_OF_NORMAL_WEIGHT = 0
        const val LESS_THAN_2_TO_MORE_THAN_2_KG_OF_NORMAL_WEIGHT = 1
        const val FROM_2_TO_9_KG_ABOVE_NORMAL_WEIGHT = 2
        const val FROM_9_TO_16_KG_ABOVE_NORMAL_WEIGHT = 3
        const val FROM_16_TO_23_KG_ABOVE_NORMAL_WEIGHT = 5
        const val MORE_THAN_23_KG_OVER_NORMAL_WEIGHT = 7
    }

    object PHYSICAL {
        const val INTENSE_PROFESSIONAL_AND_RECREATIONAL_EFFORT = 1
        const val MODERATE_PROFESSIONAL_AND_RECREATIONAL_EFFORT = 2
        const val SEDENTARY_WORK_AND_INTENSE_RECREATIONAL_EFFORT = 3
        const val SEDENTARY_WORK_AND_MODERATE_RECREATIONAL_EFFORT = 5
        const val SEDENTARY_WORK_AND_LIGHT_RECREATIONAL_EFFORT = 6
        const val COMPLETE_ABSENCE_OF_ANY_EXERCISE = 8
    }

    object SMOKER {
        const val NON_SMOKING = 0
        const val CIGAR_AND_OR_PIPE = 1
        const val _10_CIGARRETES_OR_LESS_PER_DAY = 2
        const val _11_TO_20_CIGARRETES_PER_DAY = 4
        const val _21_TO_30_CIGARRETES_PER_DAY = 6
        const val MORE_THAN_31_CIGARRETES_PER_DAY = 10
    }

    object BLOODPRESSURE {
        const val SYSTOLIC_FROM_100_TO_119_MMHG = 1
        const val SYSTOLIC_FROM_120_TO_139_MMHG = 2
        const val SYSTOLIC_FROM_140_TO_159_MMHG = 3
        const val SYSTOLIC_FROM_160_TO_179_MMHG = 4
        const val SYSTOLIC_FROM_180_TO_199_MMHG = 6
        const val SYSTOLIC_OF_200_MMHG_OR_MORE = 8
    }

    object ILLNESSESLNTHEFAMILY {
        const val NO_KNOWN_HISTORY_OF_HEART_DISEASE = 1
        const val _1_RELATIVE_WITH_HEART_DISEASE_AND_OVER_60_YEARS = 2
        const val _2_RELATIVE_WITH_HEART_DISEASE_AND_OVER_60_YEARS_OLD = 3
        const val _1_RELATIVE_WITH_HEART_DISEASE_AND_UNDER_60_YEARS_OLD = 4
        const val _2_RELATIVE_WITH_HEART_DISEASE_AND_UNDER_60_YEARS_OLD = 6
        const val _3_RELATIVE_WITH_HEART_DISEASE_AND_UNDER_60_YEARS_OLD = 7
    }

    object CHOLESTEROLLEVEL {
        const val BELOW_180_OR_THE_DIET_DOES_NOT_CONTAIN_ANIMAL_FATS = 1
        const val FROM_181_TO_205_OR_THE_DIET_CONTAINS_10_PERCENT_ANIMAL_FATS = 2
        const val FROM_206_TO_230_OR_THE_DIET_CONTAINS_20_PERCENT_ANIMAL_FATS = 3
        const val FROM_231_TO_255_OR_THE_DIET_CONTAINS_30_PERCENT_ANIMAL_FATS = 4
        const val FROM_256_TO_280_OR_THE_DIET_CONTAINS_40_PERCENT_ANIMAL_FATS = 5
        const val ABOVE_281__OR_THE_DIET_CONTAINS_50_PERCENT_ANIMAL_FATS = 7
    }
}