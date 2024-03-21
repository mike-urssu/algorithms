package tags.implementation

/**
 * https://www.acmicpc.net/problem/27918
 */
fun main() {
    val n = readln().toInt()
    val winners = BooleanArray(n) { readln() == "D" }

    var d = 0
    var p = 0
    for (i in 0 until n) {
        if (d - p == 2 || d - p == -2) {
            break
        }

        if (winners[i]) {
            d++
        } else {
            p++
        }
    }

    println("$d:$p")
}
