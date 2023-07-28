package tags.greedy

/**
 * https://www.acmicpc.net/problem/12904
 */
fun main() {
    val s = readln()
    val t = readln()
    if (isValid(s, t)) {
        println(1)
    } else {
        println(0)
    }
}

private fun isValid(s: String, t: String): Boolean {
    val deque = ArrayDeque<Char>()
        .apply { t.forEach { this.add(it) } }
    var isInOrder = true

    while (deque.size != s.length) {
        if (isInOrder) {
            if (deque.last() == 'A') {
                deque.removeLast()
            } else {
                deque.removeLast()
                isInOrder = false
            }
        } else {
            if (deque.first() == 'A') {
                deque.removeFirst()
            } else {
                deque.removeFirst()
                isInOrder = true
            }
        }
    }

    return if (isInOrder) {
        s == deque.joinToString("")
    } else {
        s == deque.joinToString("").reversed()
    }
}
