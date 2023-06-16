package com.example.artspace

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerDefaults.containerColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceLayout()
            }
        }
    }
}

@Preview
@Composable
fun ArtSpaceLayout() {
    ArtSpace(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ArtSpace(
    modifier: Modifier,
) {
    val currentImage = R.drawable.lemon_tree

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(
            modifier = Modifier
                .height(100.dp)
        )

        Column(
            modifier = Modifier
                .shadow(
                    elevation = 10.dp,
                )
                .background(Color.White)
        ) {
            Image(
                modifier = Modifier
                    .padding(50.dp)
                    .background(color = Color.LightGray),
                painter = painterResource(currentImage),
                contentDescription = null,  /*stringResource(R.string.Lemonade_tree)*/
            )
        }

        Spacer(
            modifier = Modifier
                .height(150.dp)
        )

        CanvasInfo("Lemon Tree", "Empty Author", 2023)

        Spacer(
            modifier = Modifier
                .height(80.dp)
        )

        NextPrevButton("Previous", "Next")
    }

}

@Composable
fun CanvasInfo(
    canvasName: String,
    author: String,
    date: Short,
) {

    Row(
        modifier = Modifier
            .width(270.dp)
            .height(50.dp)
            .background(Color(0xFFece8ff))
            .padding(7.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            text = "$canvasName",
            fontSize = 30.sp,
        )
    }

    Row(
        modifier = Modifier
            .width(270.dp)
            .height(35.dp)
            .background(Color(0xFFece8ff))
            .padding(7.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            text = "$author ($date)",
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun NextPrevButton(
    buttonTextPrev: String,
    buttonTextNext: String,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Button(
            onClick = {},
            modifier = Modifier
                .padding(25.dp)
                .height(35.dp)
                .width(120.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5394bd),
            )

        ) {

            Text(
                text = buttonTextPrev
            )

        }

        Button(
            onClick = {},
            modifier = Modifier
                .padding(25.dp)
                .height(35.dp)
                .width(120.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5394bd),
            )
        ) {

            Text(
                text = buttonTextNext
            )

        }
    }
}