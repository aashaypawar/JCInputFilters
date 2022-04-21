package com.geeksforgeeks.jcinputfilters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Input Filter", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        var text by remember { mutableStateOf("") }
                        FilteredTextField(
                            text = text,
                            onChanged = { text = it },
                            ignoredRegex = Regex("[qwerty123]")
                        )

                    }
                }
            )
        }
    }
}

@Composable
fun FilteredTextField(
    text: String,
    onChanged: (String) -> Unit,
    ignoredRegex: Regex
) {
    TextField(value = text,
        onValueChange = {
            if (!it.contains(ignoredRegex)) onChanged(it)
        }
    )
}
