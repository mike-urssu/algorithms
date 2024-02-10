package tags.implementation

/**
 * https://www.acmicpc.net/problem/10214
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        var yonsei = 0
        var korea = 0
        repeat(9) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            yonsei += a
            korea += b
        }
        if (yonsei > korea) {
            println("Yonsei")
        } else if (yonsei == korea) {
            println("Draw")
        } else {
            println("Korea")
        }
    }
}
