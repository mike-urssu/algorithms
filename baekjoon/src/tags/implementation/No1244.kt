package tags.implementation

/**
 * https://www.acmicpc.net/problem/1244
 */
fun main() {
    val n = readln().toInt()
    val switches = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }

    val m = readln().toInt()
    repeat(m) {
        val (gender, number) = readln().split(" ").map { it.toInt() }
        if (gender == 1) {
            (number..n step number).forEach { i -> switches[i]++ }
        } else {
            upsideDown(n, switches, number)
        }
    }

    (1..n).map { switches[it] % 2 }.chunked(20)
        .forEach { println(it.joinToString(" ")) }
}

private fun upsideDown(n: Int, switches: IntArray, number: Int) {
    switches[number]++
    var i = 1
    while (1 <= number - i && number + i <= n) {
        if (switches[number - i] % 2 != switches[number + i] % 2) {
            break
        }
        switches[number - i]++
        switches[number + i]++
        i++
    }
}
