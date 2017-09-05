package abosancic.server

import java.net.ServerSocket
import java.net.Socket

class Server {
}

val port: Int = 9999

fun main(x: Array<String>): Unit {
    println("Start server")

    val serverSocket: ServerSocket = ServerSocket(port)
    while (true) {
        var client: Socket = serverSocket.accept()
        //ServerThread(client).start()
        ServerThreadProto(client).start()
    }

    println("Close server socket")
}