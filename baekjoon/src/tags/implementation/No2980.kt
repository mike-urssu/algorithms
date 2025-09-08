package tags.implementation

/**
 * https://www.acmicpc.net/problem/2980
 */
fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    val traffics = Array(n) {
        val (d, r, g) = readln().split(" ").map { it.toInt() }
        Triple(d, r, g)
    }

    var s = 0
    var p = 0
    traffics.forEach { (d, r, g) ->
        val distance = (d - p)
        p = d
        s += distance
        s += wait(s, r, g)
    }
    s += l - p
    println(s)
}

private fun wait(s: Int, r: Int, g: Int): Int {
    val t = s % (r + g)
    return if (t in 0..r) {
        r - t
    } else {
        0
    }
}
