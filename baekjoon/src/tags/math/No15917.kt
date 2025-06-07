package tags.math

/**
 * https://www.acmicpc.net/problem/15917
 */
private val reader = System.`in`.bufferedReader()

fun main() {
    val output = StringBuilder()
    val q = reader.readLine().toInt()
    repeat(q) {
        val a = reader.readLine().toInt()
        if ((a and -a) == a) {
            output.append("1\n")
        } else {
            output.append("0\n")
        }
    }
    println(output)
}
