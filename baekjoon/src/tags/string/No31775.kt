package tags.string

/**
 * https://www.acmicpc.net/problem/31775
 */
fun main() {
    val s1 = readln()
    val s2 = readln()
    val s3 = readln()

    val sum = indexOf(s1[0]) + indexOf(s2[0]) + indexOf(s3[0])
    if (sum == 111) {
        println("GLOBAL")
    } else {
        println("PONIX")
    }
}

private fun indexOf(char: Char) = when (char) {
    'l' -> 1
    'k' -> 10
    'p' -> 100
    else -> -100
}
