package tags.string

/**
 * https://www.acmicpc.net/problem/10823
 */
fun main() {
    val numbers = StringBuilder()
    while (true) {
        val s = readlnOrNull() ?: break
        numbers.append(s)
    }
    val sum = numbers.split(",").sumOf { it.toInt() }
    println(sum)
}
