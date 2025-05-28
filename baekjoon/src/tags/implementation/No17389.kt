package tags.implementation

/**
 * https://www.acmicpc.net/problem/17389
 */
fun main() {
    val n = readln().toInt()
    val s = readln()
    var sum = 0
    var bonus = 0
    if (s[0] == 'O') {
        sum++
        bonus = 1
    }
    for (i in 1 until n) {
        if (s[i] == 'O') {
            sum += i + 1 + bonus++
        } else {
            bonus = 0
        }
    }
    println(sum)
}
