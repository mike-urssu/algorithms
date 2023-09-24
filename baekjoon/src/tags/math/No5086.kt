package tags.math

/**
 * https://www.acmicpc.net/problem/5086
 */
fun main() {
    while (true) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0) {
            break
        }

        if (isFactor(a, b)) {
            println("factor")
        } else if (isMultiple(a, b)) {
            println("multiple")
        } else {
            println("neither")
        }
    }
}

private fun isFactor(a: Int, b: Int) =
    b % a == 0

private fun isMultiple(a: Int, b: Int) =
    a % b == 0
