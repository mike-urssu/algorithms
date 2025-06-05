package tags.string

/**
 * https://www.acmicpc.net/problem/17094
 */
fun main() {
    val n = readln().toInt()
    val s = readln()
    val countE = s.count { it == 'e' }
    if (countE > n - countE) {
        println('e')
    } else if (countE == n - countE) {
        println("yee")
    } else {
        println(2)
    }
}
