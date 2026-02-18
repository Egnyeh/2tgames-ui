package com.cristina.ui

import com.cristina.data.ApiClient
import com.cristina.data.LoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val response: LoginResponse) : LoginState()
    data class Error(val message: String) : LoginState()
}

class LoginViewModel(private val apiClient: ApiClient) {
    
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()
    
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()
    
    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()
    
    fun onUsernameChange(value: String) {
        _username.value = value
    }
    
    fun onPasswordChange(value: String) {
        _password.value = value
    }
    
    suspend fun login() {
        if (_username.value.isBlank() || _password.value.isBlank()) {
            _loginState.value = LoginState.Error("Por favor, rellena todos los campos")
            return
        }
        
        _loginState.value = LoginState.Loading
        
        val result = apiClient.login(_username.value, _password.value)

        _loginState.value = result.fold(
            onSuccess = { response ->
                LoginState.Success(response)  // Si llega respuesta, fue exitoso
            },
            onFailure = { exception ->
                LoginState.Error(exception.message ?: "Error de conexión")
            }
        )

    }
    
    fun resetState() {
        _loginState.value = LoginState.Idle
    }
}
