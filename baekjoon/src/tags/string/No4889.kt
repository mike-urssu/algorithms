package tags.string

/**
 * https://www.acmicpc.net/problem/4889
 */
fun main() {
    var index = 1
    while (true) {
        val s = readln()
        if (s.startsWith("-")) {
            break
        }
        println("${index++}. ${countChangedBrace(s)}")
    }
}

private fun countChangedBrace(s: String): Int {
    var count = 0
    val stack = java.util.Stack<Char>()
    s.forEach { brace ->
        if (brace == '{') {
            stack.push(brace)
        } else {
            if (stack.isEmpty()) {
                stack.push('{')
                count++
            } else {
                stack.pop()
            }
        }
    }
    return count + stack.size / 2
}
