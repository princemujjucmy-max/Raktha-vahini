package com.mindmatrix.rakta.data

/** The eight standard ABO/Rh blood groups. */
enum class BloodGroup(val label: String) {
    A_POS("A+"), A_NEG("A-"),
    B_POS("B+"), B_NEG("B-"),
    AB_POS("AB+"), AB_NEG("AB-"),
    O_POS("O+"), O_NEG("O-");

    companion object {
        fun fromLabel(label: String): BloodGroup =
            entries.first { it.label == label }
    }
}
