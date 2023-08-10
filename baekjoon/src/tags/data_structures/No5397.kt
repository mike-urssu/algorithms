package tags.data_structures

/**
 * https://www.acmicpc.net/problem/5397
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val s = readln()
        println(getPassword(s))
    }
}

private fun getPassword(s: String): String {
    val front = ArrayDeque<Char>()
    val back = ArrayDeque<Char>()
    s.forEach {
        when (it) {
            '<' -> {
                if (front.isNotEmpty()) {
                    back.addFirst(front.removeLast())
                }
            }

            '>' -> {
                if (back.isNotEmpty()) {
                    front.addLast(back.removeFirst())
                }
            }

            '-' -> {
                if (front.isNotEmpty()) {
                    front.removeLast()
                }
            }

            else -> {
                front.addLast(it)
            }
        }
    }
    return merge(front, back)
}

private fun merge(front: ArrayDeque<Char>, back: ArrayDeque<Char>): String {
    val password = StringBuilder()
    while (front.isNotEmpty()) {
        password.append(front.removeFirst())
    }
    while (back.isNotEmpty()) {
        password.append(back.removeFirst())
    }
    return password.toString()
}
