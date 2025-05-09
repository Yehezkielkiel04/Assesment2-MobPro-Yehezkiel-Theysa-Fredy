package com.yehezkiel0091.mybuku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yehezkiel0091.mybuku.navigation.SetupNavGraph
import com.yehezkiel0091.mybuku.ui.theme.MyBukuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBukuTheme {
                SetupNavGraph()
            }
        }
    }
}
