package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/19532
 */
fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    val a = numbers[0]
    val b = numbers[1]
    val c = numbers[2]
    val d = numbers[3]
    val e = numbers[4]
    val f = numbers[5]

    for (x in -999..999) {
        for (y in -999..999) {
            if (a * x + b * y == c && d * x + e * y == f) {
                println("$x $y")
                return
            }
        }
    }
}
