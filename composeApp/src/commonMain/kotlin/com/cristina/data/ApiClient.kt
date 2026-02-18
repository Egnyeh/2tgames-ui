package com.cristina.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import io.ktor.client.request.forms.*


class ApiClient(private val baseUrl: String = "http://localhost:8080/api") {
    
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }
    
    suspend fun login(username: String, password: String): Result<LoginResponse> {
        return try {
            val response = client.post("$baseUrl/users/login/") {
                contentType(ContentType.Application.FormUrlEncoded)
                setBody(FormDataContent(Parameters.build {
                    append("username", username)
                    append("password", password)
                }))
            }
            
            if (response.status.isSuccess()) {
                Result.success(response.body<LoginResponse>())
            } else {
                Result.failure(Exception("Error ${response.status.value}: ${response.status.description}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    fun close() {
        client.close()
    }
}
