package abosancic.server

import abosancic.domain.AddressBookProtos
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket

class ServerThreadProto(private val socket: Socket) : Thread() {

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

        val peson = AddressBookProtos.Person.parseFrom(message)

        println("Message: " + peson)

        println("Close connection")
    }

}