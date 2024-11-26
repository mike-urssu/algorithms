package tags.implementation

/**
 * https://www.acmicpc.net/problem/29699
 */
fun main() {
    val s = "WelcomeToSMUPC"
    val n = readln().toInt() - 1
    println(s[n % s.length])
}
