package com.example.bmicalculator_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmicalculator_compose.ui.theme.BMICalculator_ComposeTheme
import com.example.bmicalculator_compose.ui.theme.PURPLE_40
import com.example.bmicalculator_compose.ui.theme.PURPLE_60
import com.example.bmicalculator_compose.ui.theme.WHITE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculator_ComposeTheme {
                // A surface container using the 'background' color from the theme
            CalculatorBMI()
                }
            }
        }
    }

@Composable
fun CalculatorBMI(){
    //Definir a barra superior
    Scaffold(
        //topBar nao tem retorno, como eh uma fun pode abrir e fechar chaves
        topBar = {
            TopAppBar(
                backgroundColor = PURPLE_40,
                title = {
                    Text(text = "BMI Calculator", color = WHITE)
                }
            )
        }
    ) {

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BMICalculator_ComposeTheme {
        CalculatorBMI()
    }
}