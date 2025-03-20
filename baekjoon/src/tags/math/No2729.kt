package tags.math

/**
 * https://www.acmicpc.net/problem/2729
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (b1, b2) = readln().split(" ")
        val sum = if (b1.length >= b2.length) {
            sum(b1, b2)
        } else {
            sum(b2, b1)
        }
        println(sum)
    }
}

private fun sum(b1: String, b2: String): String {
    val binary = StringBuilder()

    var i1 = b1.lastIndex
    var i2 = b2.lastIndex
    var upper = 0

    while (i2 >= 0) {
        val sum = b1[i1].digitToInt() + b2[i2].digitToInt() + upper
        binary.append(sum % 2)
        i1--
        i2--
        upper = if (sum >= 2) {
            1
        } else {
            0
        }
    }

    while (i1 >= 0) {
        val sum = b1[i1].digitToInt() + upper
        binary.append(sum % 2)
        i1--
        upper = if (sum >= 2) {
            1
        } else {
            0
        }
    }

    if (upper == 1) {
        binary.append(1)
    }

    return binary.dropLastWhile { it == '0' }.reversed().toString().ifEmpty { "0" }
}
