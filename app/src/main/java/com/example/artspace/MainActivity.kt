package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
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
    var clickResult by remember {
        mutableStateOf(0)
    }

    if (clickResult >= 3) clickResult = 3
    if (clickResult <= 0) clickResult = 0

    val actualImage = when (clickResult) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val canvasInfoBanner = when (actualImage) {
        R.drawable.lemon_tree -> stringResource(R.string.Lemon_tree)
        R.drawable.lemon_squeeze -> stringResource(R.string.Lemon_squeeze)
        R.drawable.lemon_drink -> stringResource(R.string.Lemonade_cup)
        R.drawable.lemon_restart -> stringResource(R.string.Lemonade_drink)
        else -> "The End"
    }

    val parsingCanvasInfoBanner = canvasInfoBanner.split(";")

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
                painter = painterResource(actualImage),
                contentDescription = null,
            )
        }

        Spacer(
            modifier = Modifier
                .height(150.dp)
        )

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
                text = parsingCanvasInfoBanner[0],
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
                text = "${parsingCanvasInfoBanner[1]} (${parsingCanvasInfoBanner[2]})",
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(
            modifier = Modifier
                .height(80.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = { clickResult-- },
                modifier = Modifier
                    .padding(25.dp)
                    .height(35.dp)
                    .width(120.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5394bd),
                )

            ) {

                Text(
                    text = "Previous",
                )
            }

            Button(
                onClick = { clickResult++ },
                modifier = Modifier
                    .padding(25.dp)
                    .height(35.dp)
                    .width(120.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5394bd),
                )

            ) {

                Text(
                    text = "Next",
                )
            }

        }
    }

}

