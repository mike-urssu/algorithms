package tags.math

/**
 * https://www.acmicpc.net/problem/2729
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (b1, b2) = readln().split(" ")
        println(sum(b1, b2))
    }
}

private fun sum(b1: String, b2: String): String {
    val binary = StringBuilder()

    var i = b1.lastIndex
    var j = b2.lastIndex
    var carry = 0

    while (i >= 0 || j >= 0 || carry > 0) {
        val bit1 = if (i >= 0) {
            b1[i] - '0'
        } else {
            0
        }
        val bit2 = if (j >= 0) {
            b2[j] - '0'
        } else {
            0
        }
        val sum = bit1 + bit2 + carry

        binary.append(sum % 2)
        i--
        j--
        carry = sum / 2
    }

    return binary.dropLastWhile { it == '0' }.reversed().toString().ifEmpty { "0" }
}
