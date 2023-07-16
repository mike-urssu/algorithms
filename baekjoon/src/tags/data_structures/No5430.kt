package tags.data_structures

/**
 * https://www.acmicpc.net/problem/5430
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val p = readln().toCharArray()
        readln()
        val s = readln()
        val numbers = if (s == "[]") {
            emptyList()
        } else {
            s.substring(1, s.length - 1).split(",").map { it.toInt() }
        }
        println(ac(p, numbers))
    }
}

private fun ac(p: CharArray, numbers: List<Int>): String {
    val deque = ArrayDeque<Int>().apply { this.addAll(numbers) }
    var isInOrder = true
    for (c in p) {
        if (c == 'R') {
            isInOrder = !isInOrder
        } else {
            if (deque.isEmpty()) {
                return "error"
            }
            if (isInOrder) {
                deque.removeFirst()
            } else {
                deque.removeLast()
            }
        }
    }
    return if (isInOrder) {
        "[${deque.joinToString(",")}]"
    } else {
        "[${deque.reversed().joinToString(",")}]"
    }
}
