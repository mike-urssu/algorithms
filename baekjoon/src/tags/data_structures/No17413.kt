package tags.data_structures

/**
 * https://www.acmicpc.net/problem/17413
 */
fun main() {
    val s = readln()
    val reversedS = StringBuilder()
    val deque = ArrayDeque<Char>()
    var isOpen = false
    s.forEach {
        when (it) {
            '<' -> {
                while (deque.isNotEmpty()) {
                    reversedS.append(deque.removeLast())
                }
                deque.addLast('<')
                isOpen = true
            }

            '>' -> {
                deque.addLast('>')
                while (deque.isNotEmpty()) {
                    reversedS.append(deque.removeFirst())
                }
                isOpen = false
            }

            ' ' -> {
                if (!isOpen) {
                    while (deque.isNotEmpty()) {
                        reversedS.append(deque.removeLast())
                    }
                    reversedS.append(' ')
                } else {
                    deque.addLast(' ')
                }
            }

            else -> {
                deque.addLast(it)
            }
        }
    }
    while (deque.isNotEmpty()) {
        reversedS.append(deque.removeLast())
    }
    println(reversedS.toString())
}
