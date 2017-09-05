package abosancic.client

import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket

class ClientThread(private val socket: Socket) : Runnable {

    private val out: DataOutputStream
    private val inp: DataInputStream

    init {
        out = DataOutputStream(socket.getOutputStream())
        inp = DataInputStream(socket.getInputStream())
    }

    override fun run() {
        println("Start client thread")

        val message:String = "Hello this is my message"
        val messageBytes: ByteArray = message.toByteArray()

        out.writeInt(messageBytes.size)
        out.write(messageBytes)

        val ack:Int = inp.readInt()

        println("Close client thread")
    }
}

val port: Int = 9999

fun main(x: Array<String>): Unit {
    println("Start client")

    val socket: Socket = Socket("127.0.0.1", port)

    Thread(ClientThread(socket)).start()
}