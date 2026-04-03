package tags.string

/**
 * https://www.acmicpc.net/problem/32288
 */
fun main() {
    readln()
    val s = readln()
    val switch = s.map { c ->
        if (c in 'a'..'z') {
            c.uppercaseChar()
        } else {
            c.lowercase()
        }
    }.joinToString("")
    println(switch)
}
