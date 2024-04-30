package tags.implementation

/**
 * https://www.acmicpc.net/problem/5893
 */
import java.util.Stack

fun main() {
    val n = readln()
    val n2 = n + "0000"
    println(binarySum("0000${n}", n2))
}

private fun binarySum(n1: String, n2: String): String {
    val length = n1.length
    val stack = Stack<Char>()

    var bit = 0
    for (i in length - 1 downTo 0) {
        if (n1[i] == '1' && n2[i] == '1') {
            if (bit == 0) {
                bit = 1
                stack.push('0')
            } else {
                stack.push('1')
            }
        } else if (n1[i] == '0' && n2[i] == '0') {
            if (bit == 0) {
                stack.push('0')
            } else {
                bit = 0
                stack.push('1')
            }
        } else {
            if (bit == 0) {
                stack.push('1')
            } else {
                bit = 1
                stack.push('0')
            }
        }
    }

    if (bit == 1) {
        stack.push('1')
    }

    val sum = StringBuilder()
    while (stack.isNotEmpty()) {
        sum.append(stack.pop())
    }
    return sum.toString()
}
