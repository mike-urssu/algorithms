package tags.string

import java.util.Stack

/**
 * https://www.acmicpc.net/problem/9935
 */
fun main() {
    val s1 = readln()
    val s2 = readln()
    println(replace(s1, s2))
}

private val stack = Stack<Char>()
private fun replace(s1: String, s2: String): String {
    for (ch in s1) {
        stack.push(ch)
        if (ch == s2.last()) {
            popStringIfValid(s2)
        }
    }
    return if (stack.isEmpty()) {
        "FRULA"
    } else {
        stack.joinToString("")
    }
}

private fun popStringIfValid(s: String) {
    if (stack.size < s.length) {
        return
    }

    val string = (s.indices).map { stack.pop() }.joinToString("").reversed()
    if (s != string) {
        string.forEach { stack.push(it) }
    }
}
