package tags.string

/**
 * https://www.acmicpc.net/problem/8958
 */
fun main() {
    val testCase = readln().toInt()
    repeat(testCase) {
        var score = 0
        val sum = readln().map {
            score = if (it == 'O') {
                score + 1
            } else {
                0
            }
            score
        }.sum()
        println(sum)
    }
}
