package tags.implementation

/**
 * https://www.acmicpc.net/problem/16017
 */
fun main() {
    val digits = IntArray(4) { readln().toInt() }
    if (matches(digits)) {
        println("ignore")
    } else {
        println("answer")
    }
}

private fun matches(digits: IntArray): Boolean {
    if (digits[0] != 8 && digits[0] != 9) {
        return false
    }
    if (digits[3] != 8 && digits[3] != 9) {
        return false
    }
    return digits[1] == digits[2]
}
