package md.utm.cloudapp.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress


/**
 * Function for System Name
 */
fun getSystemName(): String? {
    return try {
        InetAddress.getLocalHost().hostName
    } catch (E: Exception) {
        System.err.println("System Name Exp : " + E.message)
        null
    }
}

@RestController
class MainController {

    @GetMapping("/")
    fun main(): String {
        // Call Function to get Computer System Name
        val systemName = getSystemName()

        // Print Computer Name
        println("Computer Name : $systemName")


        return "Hello Prasada! $systemName"
    }
}
