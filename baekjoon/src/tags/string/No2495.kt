package tags.string

/**
 * https://www.acmicpc.net/problem/2495
 */
fun main() {
    val s1 = readln()
    val s2 = readln()
    val s3 = readln()
    println(getContinuousIntervalLength(s1))
    println(getContinuousIntervalLength(s2))
    println(getContinuousIntervalLength(s3))
}

private fun getContinuousIntervalLength(s: String): Int {
    var maxLength = Int.MIN_VALUE
    var length = 0
    var previousCharacter = '-'
    for (i in s.indices) {
        if (previousCharacter == s[i]) {
            length++
        } else {
            length = 1
        }
        maxLength = maxLength.coerceAtLeast(length)
        previousCharacter = s[i]
    }
    return maxLength
}
