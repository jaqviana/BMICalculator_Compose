package com.example.bmicalculator_compose.calculo

import java.text.DecimalFormat

class CalcularBMI {

    private var bmiResult = ""
    fun bmiCalculate(peso: String, altura: String) {

        val weightToDouble = peso.toDouble()
        val heightToDouble = altura.toDouble()
        val result: String

        val imc = weightToDouble/ (heightToDouble  * heightToDouble)
        val decimalFormat = DecimalFormat("0.00")

        result = if (imc <= 18.5) {
            "Underweight \n BMI: ${decimalFormat.format(imc)}"
        } else if (imc <= 24.9) {
            "Normal \n BMI: ${decimalFormat.format(imc)}"
        } else if (imc <= 29.9) {
            "Overweight \n BMI: ${decimalFormat.format(imc)}"
        } else if (imc <= 34.9) {
            "Obese \n BMI: ${decimalFormat.format(imc)}"
        } else if (imc <= 39.9) {
            "Severely Obese \n BMI: ${decimalFormat.format(imc)}"
        } else {
            "Morbidly Obese \n BMI: ${decimalFormat.format(imc)}"
        }
        bmiResult = result
    }

    fun bmiResult(): String{
        return bmiResult
    }

}