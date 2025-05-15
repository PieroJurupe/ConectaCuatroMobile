package com.pixeup.conectacuatro.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pixeup.conectacuatro.ui.theme.CircleColor
import com.pixeup.conectacuatro.ui.theme.Tablero
import com.pixeup.conectacuatro.ui.theme.TableroBorder

@Composable
fun ConectaCuatro(modifier: Modifier) {
    val numColumnas = 7
    val numFilas = 6
    val jugadorActual = remember { mutableStateOf(Color.Red) }
    val tablero = remember {
        mutableStateListOf<MutableList<MutableState<Color>>>().apply {
            repeat(numColumnas) {
                add(MutableList(numFilas) { mutableStateOf(CircleColor) })
            }
        }
    }



    ConstraintLayout(modifier.fillMaxSize()) {


        val tableroBox = createRef()
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
                                        jugadorActual.value = if (jugadorActual.value == Color.Red) Color.Yellow else Color.Red
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
