package tags.ad_hoc

/**
 * https://www.acmicpc.net/problem/10158
 */
fun main() {
    val (w, h) = readln().split(" ").map { it.toInt() }
    val (p, q) = readln().split(" ").map { it.toInt() }
    val t = readln().toInt()

    var x = (p + t) % (w * 2)
    var y = (q + t) % (h * 2)
    if (x > w) {
        x = w - (x % w)
    }
    if (y > h) {
        y = h - (y % h)
    }
    println("$x $y")
}
