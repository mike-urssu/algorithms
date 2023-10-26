package tags.data_structures

/**
 * https://www.acmicpc.net/problem/9093
 */
import java.util.Stack

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val s = readln()
        println(getReversedS(s))
    }
}

private fun getReversedS(s: String): String {
    val reversedS = StringBuilder()
    var index = 0
    val stack = Stack<Char>()
    while (index < s.length) {
        while (index < s.length && s[index] != ' ') {
            stack.add(s[index])
            index++
        }
        index++

        while (stack.isNotEmpty()) {
            reversedS.append(stack.pop())
        }
        reversedS.append(" ")
    }
    return reversedS.toString()
}
