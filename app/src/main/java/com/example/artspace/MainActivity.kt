package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

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
    ArtSpaceImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ArtSpaceImage(
    modifier: Modifier,
) {
    val currentImage = R.drawable.lemon_tree

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFC3FBD8)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Image(
            painter = painterResource(currentImage),
            contentDescription = null,
            modifier = Modifier
                .border(10.dp, Color.White, )
                .background(Color(0xFFFED6BC))
        )
    }

}
