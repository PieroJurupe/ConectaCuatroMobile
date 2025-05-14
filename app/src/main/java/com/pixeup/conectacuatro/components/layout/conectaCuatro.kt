package com.pixeup.conectacuatro.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConectaCuatro(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {

        val boxBlue = createRef()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.65f)
                .background(Color.Blue)
                .border(8.dp, Color.Cyan)
                .padding(10.dp, 60.dp, 10.dp, 60.dp)
                .constrainAs(boxBlue) {
                bottom.linkTo(parent.bottom)
            }
        ) {
        Row(
            modifier=Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
                horizontalArrangement = Arrangement.SpaceEvenly,


            ){

        Column(
             modifier = Modifier
                .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))

        }
        Column(
                modifier = Modifier
                .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))

            }
        Column(
                modifier = Modifier
                .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black, shape = CircleShape).clip(CircleShape).background(Color.LightGray))

            }
        Column(
                modifier = Modifier
                .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))

            }
        Column(
                modifier = Modifier
                .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))

            }
        Column(
                modifier = Modifier
                .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))

            }
        Column(
                modifier = Modifier
                .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).border(4.dp,Color.Black,shape=CircleShape).clip(CircleShape).background(Color.LightGray))

            }
        }
    }
}
}