package tags.string

/**
 * https://www.acmicpc.net/problem/5026
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val line = readln()
        if (line == "P=NP") {
            println("skipped")
        } else {
            val (a, b) = line.split("+").map { it.toInt() }
            println(a + b)
        }
    }
}
