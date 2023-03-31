package tags.string

/**
 * https://www.acmicpc.net/problem/2935
 */
fun main() {
    val a = readln()
    val operation = readln()
    val b = readln()
    val value = if (operation == "+") {
        if (a.length > b.length) {
            a.substring(0, a.length - b.length) + b
        } else if (a.length == b.length) {
            a.replace("1", "2")
        } else {
            b.substring(0, b.length - a.length) + a
        }
    } else {
        a + b.removePrefix("1")
    }
    println(value)
}
