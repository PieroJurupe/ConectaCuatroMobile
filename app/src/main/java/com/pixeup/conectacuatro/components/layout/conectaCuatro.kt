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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension.Companion.preferredWrapContent
import com.pixeup.conectacuatro.ui.theme.ButtonBorder
import com.pixeup.conectacuatro.ui.theme.ButtonColor
import com.pixeup.conectacuatro.ui.theme.CircleColor
import com.pixeup.conectacuatro.ui.theme.RedToken
import com.pixeup.conectacuatro.ui.theme.RedTokenex
import com.pixeup.conectacuatro.ui.theme.Tablero
import com.pixeup.conectacuatro.ui.theme.TableroBorder
import com.pixeup.conectacuatro.ui.theme.YellowToken
import com.pixeup.conectacuatro.ui.theme.YellowTokenex


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

        val (tableroBox,botonCount,botonGame,textoR,turno,contRed,contYell,token) = createRefs()
        val topGuide = createGuidelineFromTop(20.dp)
        val juegoActivo = remember { mutableStateOf(true) }


        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .border(4.dp, Color.Black, shape = CircleShape)
                .constrainAs(token) {
                    start.linkTo(contRed.end)
                    end.linkTo(contYell.start)
                    top.linkTo(contRed.top)
                    bottom.linkTo(contRed.bottom)

                }
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(if (jugadorActual.value == RedToken) RedToken else YellowToken)
                    .border(10.dp, if(jugadorActual.value == RedToken) RedTokenex else YellowTokenex, shape = CircleShape)
                    .align(alignment = Alignment.Center)
            )
        }


        Text(
            text = "V:0",
            modifier = Modifier
                .constrainAs(contRed) {
                    start.linkTo(parent.start,margin = 24.dp)
                    bottom.linkTo(tableroBox.top, margin = 120.dp)
                },
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            color = RedToken
        )
        Text(
            text = "0:V",
            modifier = Modifier
                .constrainAs(contYell) {
                    bottom.linkTo(tableroBox.top, margin = 120.dp)
                    end.linkTo(parent.end,margin = 24.dp)
                },
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            color = YellowToken
        )

        Text(
            modifier = Modifier
                .constrainAs(turno)
                {
                    bottom.linkTo(tableroBox.top, margin = 10.dp)
                    end.linkTo(contYell.start)
                    start.linkTo(contRed.end)
                },
            text = buildAnnotatedString {
                append("!Es turno del \n jugador ")
                withStyle(
                    style = SpanStyle(
                        color = if (jugadorActual.value == RedToken) RedToken else YellowToken,
                    )
                ) {
                    append(if (jugadorActual.value == RedToken) "Rojo!" else "Amarillo!")

                }
            },
            fontSize = 31.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 34.sp,
            color = Color.Black )


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
            onClick = {
                for (columna in tablero){
                    for (fila in columna){
                        fila.value = CircleColor
                        juegoActivo.value = true
                    }
                }
            },
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
                                if (!juegoActivo.value) return@clickable
                                for (fila in (numFilas - 1) downTo 0) {
                                    if (tablero[columnaId][fila].value == CircleColor) {
                                        tablero[columnaId][fila].value = jugadorActual.value
                                        val ganador = verificarGanador(
                                            tablero = tablero,
                                            fila = fila,
                                            columna = columnaId,
                                            color = jugadorActual.value,
                                            numFilas = numFilas,
                                            numColumnas = numColumnas
                                        )

                                        if (ganador) {
                                            println("¡Ganó el jugador ${if (jugadorActual.value == RedToken) "Rojo" else "Amarillo"}!")
                                            juegoActivo.value = false
                                        // ACTUALIZAR ESTADO GANADOR
                                        } else {
                                            // CAMBIAR TURNO
                                            jugadorActual.value = if (jugadorActual.value == RedToken) YellowToken else RedToken
                                        }

                                       // println("Columna $columnaId fue seleccionada y la fila $fila")
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



fun verificarGanador(
    tablero: List<List<MutableState<Color>>>,
    fila: Int,
    columna: Int,
    color: Color,
    numFilas: Int,
    numColumnas: Int
): Boolean {
    return (
    cuentaConsecutivos(fila, columna, 1, 0, color, tablero, numFilas, numColumnas) >= 4 || // vertical
    cuentaConsecutivos(fila, columna, 0, 1, color, tablero, numFilas, numColumnas) >= 4 || // horizontal
    cuentaConsecutivos(fila, columna, 1, 1, color, tablero, numFilas, numColumnas) >= 4 || // diagonal ↘
    cuentaConsecutivos(fila, columna, 1, -1, color, tablero, numFilas, numColumnas) >= 4   // diagonal ↙
    )
}
fun cuentaConsecutivos(
    fila: Int,
    columna: Int,
    deltaFila: Int,
    deltaCol: Int,
    color: Color,
    tablero: List<List<MutableState<Color>>>,
    numFilas: Int,
    numColumnas: Int
): Int {
    var total = 1
    total += contarEnDireccion(fila, columna, deltaFila, deltaCol, color, tablero, numFilas, numColumnas)
    total += contarEnDireccion(fila, columna, -deltaFila, -deltaCol, color, tablero, numFilas, numColumnas)
    return total
}
fun contarEnDireccion(
    fila: Int,
    columna: Int,
    deltaFila: Int,
    deltaCol: Int,
    color: Color,
    tablero: List<List<MutableState<Color>>>,
    numFilas: Int,
    numColumnas: Int
): Int {
    var count = 0
    var f = fila + deltaFila
    var c = columna + deltaCol
    while (f in 0 until numFilas && c in 0 until numColumnas && tablero[c][f].value == color) {
        count++
        f += deltaFila
        c += deltaCol
    }
    return count
}
