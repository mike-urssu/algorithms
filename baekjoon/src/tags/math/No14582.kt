package tags.math

/**
 * https://www.acmicpc.net/problem/14582
 */
fun main() {
    val score1 = readln().split(" ").map { it.toInt() }
    val score2 = readln().split(" ").map { it.toInt() }

    var isUpset = false
    var sum1 = 0
    var sum2 = 0
    for (i in 0 until 9) {
        sum1 += score1[i]
        if (sum1 > sum2) {
            isUpset = true
            break
        }
        sum2 += score2[i]
    }

    if (isUpset) {
        println("Yes")
    } else {
        println("No")
    }
}
