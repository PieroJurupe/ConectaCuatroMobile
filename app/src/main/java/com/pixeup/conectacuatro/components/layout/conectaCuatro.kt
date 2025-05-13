package com.pixeup.conectacuatro.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
                .fillMaxHeight(0.7f)
                .background(Color.Blue)
                .border(10.dp, Color.Cyan)
                .padding(10.dp)
                .constrainAs(boxBlue) {
                bottom.linkTo(parent.bottom)
            }
        ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))
            Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))

        }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Red),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))
                Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))
                Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))
                Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))
                Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))
                Box(Modifier.height(50.dp).width(50.dp).clip(CircleShape).background(Color.LightGray))

            }

        }
    }
}