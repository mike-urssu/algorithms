package tags.greedy

/**
 * https://www.acmicpc.net/problem/13413
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val actual = readln().toCharArray()
        val expected = readln().toCharArray()
        var black = 0
        var white = 0
        (0 until n).forEach { i ->
            if (actual[i] != expected[i]) {
                if (actual[i] == 'B') {
                    black++
                } else {
                    white++
                }
            }
        }
        println(maxOf(black, white))
    }
}
