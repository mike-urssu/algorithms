package tags.string

/**
 * https://www.acmicpc.net/problem/14726
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val creditNumbers = readln()
        val v = if (isValid(creditNumbers)) {
            "T"
        } else {
            "F"
        }
        println(v)
    }
}

private fun isValid(creditNumbers: String): Boolean {
    return creditNumbers.mapIndexed { index, c ->
        val n = c.digitToInt()
        if (index % 2 == 0) {
            (n * 2) / 10 + (n * 2) % 10
        } else {
            n
        }
    }.sum() % 10 == 0
}
