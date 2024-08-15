package tags.binary_search

/**
 * https://www.acmicpc.net/problem/3651
 */
import java.math.BigInteger

fun main() {
    val pairs = mutableSetOf<Pair<Long, Long>>()

    val m = readln().toLong()
    (1..27L).forEach { r ->
        var low = r shl 1 - 1
        var high = m + 1
        while (low + 1 < high) {
            val mid = (low + high) shr 1
            val v = combination(mid, r)
            if (v == m.toBigInteger()) {
                pairs.add(mid to r)
                pairs.add(mid to mid - r)
                high = mid
            } else if (v < m.toBigInteger()) {
                low = mid
            } else {
                high = mid
            }
        }
    }

    println(pairs.size)
    pairs
        .sortedWith { it, other ->
            val c1 = it.first.compareTo(other.first)
            if (c1 == 0) {
                it.second.compareTo(other.second)
            } else {
                c1
            }
        }
        .forEach { (n, r) -> println("$n $r") }
}

private fun combination(n: Long, r: Long): BigInteger {
    var v = BigInteger.ONE
    (n downTo n - r + 1).forEach { v *= BigInteger.valueOf(it) }
    (r downTo 1).forEach { v /= BigInteger.valueOf(it) }
    return v
}
