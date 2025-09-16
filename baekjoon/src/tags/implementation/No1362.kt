package tags.implementation

/**
 * https://www.acmicpc.net/problem/1362
 */
fun main() {
    var scenario = 1
    while (true) {
        var (o, w) = readln().split(" ").map { it.toInt() }
        if (w == 0 && o == 0) {
            break
        }

        var isDead = false
        while (true) {
            val (c, n) = readln().split(" ")
            if (c == "#" && n == "0") {
                break
            }
            if (c == "E") {
                w -= n.toInt()
                if (w <= 0) {
                    isDead = true
                }
            } else {
                w += n.toInt()
            }
        }

        val result = if (isDead) {
            "RIP"
        } else if (0.5 * o.toDouble() < w.toDouble() && w.toDouble() < 2.0 * o.toDouble()) {
            ":-)"
        } else {
            ":-("
        }
        println("${scenario++} $result")
    }
}
