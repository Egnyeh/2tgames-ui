package com.cristina.loginkmp

import androidx.compose.runtime.Composable
import com.cristina.loginkmp.data.ApiClient
import com.cristina.loginkmp.ui.LoginScreen
import com.cristina.loginkmp.ui.LoginViewModel

@Composable
fun App() {
    val apiClient = ApiClient(baseUrl = "http://localhost:8000")
    val viewModel = LoginViewModel(apiClient)
    
    LoginScreen(viewModel)
}
