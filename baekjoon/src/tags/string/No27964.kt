package tags.string

/**
 * https://www.acmicpc.net/problem/27964
 */
fun main() {
    readln()
    val s = readln().split(" ").filter { it.endsWith("Cheese") }
    val isValid = if (s.distinct().size >= 4) {
        "yummy"
    } else {
        "sad"
    }
    println(isValid)
}
