package tags.string

/**
 * https://www.acmicpc.net/problem/12919
 */
fun main() {
    val s = readln()
    val t = readln()
    if (canTransfer(s, t)) {
        println(1)
    } else {
        println(0)
    }
}

private fun canTransfer(s: String, t: String): Boolean {
    if (s == t) {
        return true
    }
    if (t.endsWith('A')) {
        if (canTransfer(s, t.substring(0, t.length - 1))) {
            return true
        }
    }
    if (t.startsWith('B')) {
        if (canTransfer(s, t.substring(1).reversed())) {
            return true
        }
    }
    return false
}
