package tags.string

/**
 * https://www.acmicpc.net/problem/4458
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val s = readln()
        println("${s.first().uppercase()}${s.substring(1)}")
    }
}
