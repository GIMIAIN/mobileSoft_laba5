package com.example.mobilesoft

class RightAngledTriangle(private var leg: Double? = null, private var hypotenuse: Double? = null, private var area: Double? = null) {

    fun calculateArea(): Double? {
        return if (leg != null) {
            (leg!! * leg!!) / 2
        } else if (hypotenuse != null) {
            val legValue = Math.sqrt(hypotenuse!! * hypotenuse!! / 2)
            (legValue * legValue) / 2
        } else {
            area
        }
    }

    fun calculateHypotenuse(): Double? {
        return if (leg != null) {
            Math.sqrt(2 * leg!! * leg!!)
        } else {
            hypotenuse
        }
    }

    fun calculateLeg(): Double? {
        return if (hypotenuse != null) {
            Math.sqrt(hypotenuse!! * hypotenuse!! / 2)
        } else if (area != null) {
            Math.sqrt(2 * area!!)
        } else {
            leg
        }
    }
}