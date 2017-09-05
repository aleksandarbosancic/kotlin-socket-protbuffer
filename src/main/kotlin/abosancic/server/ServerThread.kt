package abosancic.server

import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket

class ServerThread(private val socket: Socket) : Thread() {

    private val out:DataOutputStream
    private val inp:DataInputStream

    init {
        println("Start server thread")
        out = DataOutputStream(socket.getOutputStream())
        inp = DataInputStream(socket.getInputStream())
    }

    override fun run() {
        println("Read size")
        val size:Int = inp.readInt()
        println("message length: " + size)
        val message:ByteArray = ByteArray(size)
        inp.readFully(message, 0, size)
        println("Message: " + String(message))

        out.writeInt(size)

        println("Close connection")
    }

}