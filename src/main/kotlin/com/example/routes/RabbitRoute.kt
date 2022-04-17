package com.example.routes

import com.example.data.model.Rabbit
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


private const val BASE_URL =
    "http://192.168.1.111:8100" // for running in emulator - change of IP => Local System IP or Emulator IP

// for localhost BASE_URL = "http://localhost:8100"; // localhost IP
// for real device BASE_URL = "http://YOUR_IP_ADRESS:8100"; // real device IP


private val rabbits = listOf(
    Rabbit("Rabbit_Yogesh", description = "A cute brown Rabbit", imageURL = "$BASE_URL/rabbits/rabbit1.jpg"),
    Rabbit("Rabbit_Danush", description = "Danush like eat apples", imageURL = "$BASE_URL/rabbits/rabbit2.jpg"),
    Rabbit("Rabbit_Sriram", description = "Sriram is always hungry", imageURL = "$BASE_URL/rabbits/rabbit3.jpg"),
    Rabbit(
        "Rabbit_Vishal",
        description = "Vishal likes climbing mountains",
        imageURL = "$BASE_URL/rabbits/rabbit4.jpg"
    ),
    Rabbit("Rabbit_Soori", description = "Soori is a true beauty", imageURL = "$BASE_URL/rabbits/rabbit5.jpg")
)

fun Route.randomRabbit() {
    get("/random-rabbit") {
//  to call particular Rabbit using ID from client
        //  call.parameters["rabbitId"]

        call.respond(
            HttpStatusCode.OK,
            rabbits.random()
        )

    }

}