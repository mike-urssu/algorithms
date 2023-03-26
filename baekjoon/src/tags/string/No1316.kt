package tags.string

/**
 * https://www.acmicpc.net/problem/1316
 */
fun main() {
    val n = readln().toInt()
    var count = 0
    repeat(n) {
        val s = readln()
        if (isValid(s)) {
            count++
        }
    }
    println(count)
}

private fun isValid(s: String): Boolean {
    for (character in s) {
        val substring = s.substring(s.indexOf(character), s.lastIndexOf(character) + 1)
        if (substring.groupBy { it }.size != 1) {
            return false
        }
    }
    return true
}
