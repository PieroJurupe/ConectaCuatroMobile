package com.pixeup.conectacuatro.components.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension.Companion.preferredWrapContent
import com.pixeup.conectacuatro.ui.theme.ButtonBorder
import com.pixeup.conectacuatro.ui.theme.ButtonColor
import com.pixeup.conectacuatro.ui.theme.CircleColor
import com.pixeup.conectacuatro.ui.theme.RedToken
import com.pixeup.conectacuatro.ui.theme.Tablero
import com.pixeup.conectacuatro.ui.theme.TableroBorder
import com.pixeup.conectacuatro.ui.theme.YellowToken


@Composable
fun ConectaCuatro(modifier: Modifier) {
    val numColumnas = 7
    val numFilas = 6
    val jugadorActual = remember { mutableStateOf(RedToken) }
    val tablero = remember {
        mutableStateListOf<MutableList<MutableState<Color>>>().apply {
            repeat(numColumnas) {
                add(MutableList(numFilas) { mutableStateOf(CircleColor) })
            }
        }
    }

    ConstraintLayout(modifier.fillMaxSize()) {

        val (tableroBox,botonCount,botonGame,textoR,Spacer) = createRefs()
        val topGuide = createGuidelineFromTop(20.dp)


        Text(
            text = "<-Reiniciar->",
            modifier = Modifier
                .constrainAs(textoR)
                {
                    start.linkTo(botonCount.end)
                    end.linkTo(botonGame.start)
                    top.linkTo(botonCount.top)
                    bottom.linkTo(botonCount.bottom)
                },

            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold

        )

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(ButtonColor),
            border = BorderStroke (5.dp, ButtonBorder),
            //LA PALABRA CONTADOR ES DEMASIADO GRANDE A COMPARACION DE PARTIDA POR ESO SE CAMBIA EL VALOR DE PADDING DEL BUTON
            contentPadding = PaddingValues(horizontal = 4.dp),
            modifier = Modifier
                .constrainAs(botonCount) {
                    top.linkTo(topGuide)
                    start.linkTo(parent.start, margin = 10.dp)
                }
                .width(110.dp),
        ) {
            Text(text = "Contador", fontWeight = FontWeight.Bold,color = Color.Black,fontSize = 17.sp)
        }

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(ButtonColor),
            border = BorderStroke (5.dp, ButtonBorder),
            modifier = Modifier
                .constrainAs(botonGame) {
                    top.linkTo(topGuide)
                    end.linkTo(parent.end, margin = 10.dp)
                }
                .width(110.dp)
        ) {
            Text(text = "Partida", fontWeight = FontWeight.Bold,color = Color.Black,fontSize = 17.sp)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.65f)
                .background(Tablero)
                .border(8.dp, TableroBorder)
                .padding(10.dp, 50.dp, 10.dp, 50.dp)
                .constrainAs(tableroBox) {
                    bottom.linkTo(parent.bottom)
                }
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,

                ) {
                repeat(numColumnas) { columnaId ->
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .clickable {
                                //println("Columna $columnaId fue seleccionada")
                                for (fila in (numFilas - 1) downTo 0) {
                                    if (tablero[columnaId][fila].value == CircleColor) {
                                        tablero[columnaId][fila].value = jugadorActual.value
                                        jugadorActual.value = if (jugadorActual.value == RedToken) YellowToken else RedToken
                                        break
                                    }
                                }


                            },
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        repeat(numFilas) { filaId ->
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .border(4.dp, Color.Black, shape = CircleShape)
                                    .clip(CircleShape)
                                    .background(tablero[columnaId][filaId].value)
                            )}
                        }
                    }
                }
            }
        }
    }
