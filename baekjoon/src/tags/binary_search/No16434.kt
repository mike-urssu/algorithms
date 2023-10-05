package tags.binary_search

/**
 * https://www.acmicpc.net/problem/16434
 */
fun main() {
    val (n, defaultAttack) = readln().split(" ").map { it.toInt() }
    val rooms = Array(n) { readln().split(" ").map { it.toLong() }.toLongArray() }
    println(getMinimumHP(rooms, defaultAttack.toLong()))
}

private fun getMinimumHP(rooms: Array<LongArray>, a: Long): Long {
    var low = 0L
    var high = Long.MAX_VALUE
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (isValid(rooms, mid, a)) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun isValid(rooms: Array<LongArray>, maxHp: Long, a: Long): Boolean {
    var h1 = maxHp
    var a1 = a
    for ((t, a2, h2) in rooms) {
        if (t == 1L) {
            h1 = fight(h1, a1, h2, a2)
            if (h1 <= 0) {
                return false
            }
        } else {
            a1 += a2
            h1 = maxHp.coerceAtMost(h1 + h2)
        }
    }
    return true
}

private fun fight(h1: Long, a1: Long, h2: Long, a2: Long): Long {
    val countOfAttack = (h2 + a1 - 1) / a1
    return h1 - (countOfAttack - 1) * a2
}
