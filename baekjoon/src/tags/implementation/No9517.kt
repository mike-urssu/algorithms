package tags.implementation

/**
 * https://www.acmicpc.net/problem/9517
 */
fun main() {
    var k = readln().toInt()
    val n = readln().toInt()
    val timesAndAnswers = (0 until n).map {
        val (t, a) = readln().split(" ")
        t.toInt() to a[0]
    }

    var sum = 0
    for (i in 0 until n) {
        val (t, a) = timesAndAnswers[i]
        sum += t
        if (sum >= 210) {
            break
        }

        if (a == 'T') {
            k++
            if (k == 9) {
                k = 1
            }
        }
    }
    println(k)
}
