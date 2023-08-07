package tags.data_structures

/**
 * https://www.acmicpc.net/problem/9935
 */
fun main() {
    val s = readln()
    val bomb = readln()
    println(removeBombs(s, bomb))
}

private fun removeBombs(s: String, bomb: String): String {
    val deque = ArrayDeque<Char>()
    s.forEach {
        deque.addLast(it)
        if (deque.size >= bomb.length && it == bomb.last()) {
            boom(deque, bomb)
        }
    }

    return if (deque.isEmpty()) {
        "FRULA"
    } else {
        val str = StringBuilder()
        while (deque.isNotEmpty()) {
            str.append(deque.removeFirst())
        }
        str.toString()
    }
}

private fun boom(deque: ArrayDeque<Char>, bomb: String) {
    val s = StringBuilder()
    repeat(bomb.length) {
        s.append(deque.removeLast())
    }
    if (s.reverse().toString() != bomb) {
        s.forEach { deque.add(it) }
    }
}
