package com.example.columnapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewContainer()
        }
    }
}

@Preview
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        content = { padding -> Content(padding) },
        floatingActionButton = { FAB() },
        floatingActionButtonPosition = FabPosition.End
    )
}

@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Suscríbete", Toast.LENGTH_SHORT).show()
    }) {
        Text("X")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = {
            Text(
                text = "Luiwi Profile",
                color = colorResource(id = R.color.white)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.black)
        )
    )
}

@Composable
fun Content(padding: PaddingValues) {
    var counter by remember { mutableIntStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(Color.Cyan)
            .padding(16.dp)
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                painter = painterResource(id = R.drawable.lyxan_logo),
                contentDescription = "Logo"
            )
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_android_black_24dp),
                    contentDescription = "Android",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Text(
                text = "Luiwi",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Hola",
                color = Color.Black
            )
            Text(
                text = "Mundo",
                color = Color.Black
            )
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                item {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(text = "Stack:", color = Color.Black)
                        Text(text = "Java", color = Color.Black)
                        Text(text = "KOTLIN", color = Color.Black)
                        Text(text = "SUSCRIBETE", color = Color.Black)
                        Text(text = "SUSCRIBETE", color = Color.Black)
                    }
                }
            }
        }
    }
}