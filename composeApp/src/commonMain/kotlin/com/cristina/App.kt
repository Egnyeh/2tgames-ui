package com.cristina

import androidx.compose.runtime.Composable
import com.cristina.data.ApiClient
import com.cristina.ui.LoginScreen
import com.cristina.ui.LoginViewModel

@Composable
fun App() {
    val apiClient = ApiClient(baseUrl = "http://localhost:8000")
    val viewModel = LoginViewModel(apiClient)
    
    LoginScreen(viewModel)
}
