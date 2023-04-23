package tags.string

/**
 * https://www.acmicpc.net/problem/2711
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (index, str) = readln().split(" ")
        str.forEachIndexed { i, c ->
            if (i != index.toInt() - 1) {
                print(c)
            }
        }
        println()
    }
}
