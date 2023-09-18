package com.example.bmicalculator_compose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalculator_compose.calculo.CalcularBMI
import com.example.bmicalculator_compose.ui.theme.PURPLE_40
import com.example.bmicalculator_compose.ui.theme.PURPLE_60
import com.example.bmicalculator_compose.ui.theme.WHITE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // A surface container using the 'background' color from the theme
            CalculatorBMI()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CalculatorBMI() {

    //para pegar o context da nossa tela no compose
    val context = LocalContext.current
    val calcularBMI = CalcularBMI()

    //Criando os estados da minha aplicacao
    var peso by remember {
        //para trabalhar com estados dentro da nossa aplicacao
        mutableStateOf("") //comeca vazia, mas pode alterar a qq momento atraves da caixa de texto
    }

    var altura by remember {
        mutableStateOf("")
    }

    var resultado by remember {
        mutableStateOf("")
    }

    //Definir a barra superior
    Scaffold(
        //topBar nao tem retorno, como eh uma fun pode abrir e fechar chaves
        topBar = {
            TopAppBar(
                backgroundColor = PURPLE_40,
                title = {
                    Text(text = "BMI Calculator", color = WHITE)
                },
                actions = {

                    IconButton(
                        onClick = {
                            peso = ""
                            altura = ""
                            resultado = ""
                        }
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_refresh),
                            contentDescription = "Reset Icon a"
                        )
                        
                    }



                }
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "BMI Calculator",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = PURPLE_60,
                modifier = Modifier.padding(50.dp)

            )
            //caixa de texto "edit text"
            OutlinedTextField(
                value = peso,
                onValueChange = {
                    peso = it
                },
                label = {
                    Text(text = "Weight (Kg)")
                },
                colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = PURPLE_40,
                    focusedLabelColor = PURPLE_40,
                    textColor = PURPLE_60,
                    focusedBorderColor = PURPLE_60
                ),
                textStyle = TextStyle(PURPLE_60, 18.sp),
                maxLines = 1,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 0.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            OutlinedTextField(
                value = altura,
                onValueChange = {
                    altura = it
                },
                label = {
                    Text(text = "Height (cm)")
                },
                colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = PURPLE_40,
                    focusedLabelColor = PURPLE_40,
                    textColor = PURPLE_60,
                    focusedBorderColor = PURPLE_60
                ),
                textStyle = TextStyle(PURPLE_60, 18.sp),
                maxLines = 1,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            Button(
                onClick = {
                    if (peso.isEmpty() || altura.isEmpty()) {
                        Toast.makeText(context, "Fill in all fields", Toast.LENGTH_SHORT).show()
                    } else {
                        calcularBMI.bmiCalculate(peso, altura)
                        //recuperando o resultado do BMI qdo chamo a fun bmiResult///////////////////
                        resultado = calcularBMI.bmiResult()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PURPLE_40,
                    contentColor = WHITE,
                )


            ) {
                Text(
                    text = "BMI Calculator",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }


            Text(
                text = resultado,
                fontSize = 18.sp,
                color = PURPLE_60,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

    }
}


