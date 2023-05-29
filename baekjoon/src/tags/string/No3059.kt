package tags.string

/**
 * https://www.acmicpc.net/problem/3059
 */
fun main() {
    val t = readln().toInt()
    val total = ('A'..'Z').sumOf { it.code }
    repeat(t) {
        val sum = readln().toCharArray().toSet().sumOf { it.code }
        println(total - sum)
    }
}
