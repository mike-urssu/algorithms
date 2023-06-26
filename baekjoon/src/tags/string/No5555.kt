package tags.string

/**
 * https://www.acmicpc.net/problem/5555
 */
fun main() {
    val word = readln()
    val n = readln().toInt()
    val count = (1..n).count {
        val s = readln()
        (s + s).contains(word)
    }
    println(count)
}
