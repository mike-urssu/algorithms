package tags.string

import java.security.MessageDigest

/**
 * https://www.acmicpc.net/problem/10930
 */
fun main() {
    val s = readln()
    println(encode(s))
}

private fun encode(s: String): String {
    val md = MessageDigest.getInstance("SHA-256")
    md.update(s.toByteArray())
    return md.digest().joinToString("") { String.format("%02x", it) }
}
