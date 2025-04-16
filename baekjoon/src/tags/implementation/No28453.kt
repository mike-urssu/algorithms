package tags.implementation

/**
 * https://www.acmicpc.net/problem/28453
 */
fun main() {
    readln()
    val levels = readln().split(" ").map { it.toInt() }
    println(levels.joinToString(" ") { level ->
        if (level == 300) {
            "1"
        } else if (level in 275 until 300) {
            "2"
        } else if (level in 250 until 275) {
            "3"
        } else {
            "4"
        }
    })
}
