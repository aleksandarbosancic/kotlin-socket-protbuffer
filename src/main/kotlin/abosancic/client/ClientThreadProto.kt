package abosancic.client

import abosancic.domain.AddressBookProtos
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket
import abosancic.domain.AddressBookProtos.Person
import java.io.Console


class ClientThreadProto(private val socket: Socket) : Runnable {

    private val out: DataOutputStream
    private val inp: DataInputStream

    init {
        out = DataOutputStream(socket.getOutputStream())
        inp = DataInputStream(socket.getInputStream())
    }

    override fun run() {
        println("Start client thread")

        //while (true) {
        //    val input: String = readLine() as String
        //    if (input.equals("end")) break

            val message: Person = Person.newBuilder()
                    .setId(1234)
                    .setName("John Doe")
                    .setEmail("jdoe@example.com")
                    .addPhones(
                            Person.PhoneNumber.newBuilder()
                                    .setNumber("555-4321")
                                    .setType(Person.PhoneType.HOME))
                    .build()

            val messageBytes: ByteArray = message.toByteArray()

            out.writeInt(messageBytes.size)
            out.write(messageBytes)
//        }

        println("Close client thread")
    }
}

fun main(x: Array<String>): Unit {
    println("Start client")

    val socket: Socket = Socket("127.0.0.1", port)

    Thread(ClientThreadProto(socket)).start()
}