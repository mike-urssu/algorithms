package tags.math

/**
 * https://www.acmicpc.net/problem/28702
 */
fun main() {
    val s1 = readln()
    val s2 = readln()
    val s3 = readln()

    val n = if (isNumber(s1)) {
        s1.toInt() + 3
    } else if (isNumber(s2)) {
        s2.toInt() + 2
    } else if (isNumber(s3)) {
        s3.toInt() + 1
    } else {
        0
    }

    if (n % 3 == 0 && n % 5 == 0) {
        println("FizzBuzz")
    } else if (n % 3 == 0) {
        println("Fizz")
    } else if (n % 5 == 0) {
        println("Buzz")
    } else {
        println(n)
    }
}

private fun isNumber(s: String) =
    s.all { it.isDigit() }
