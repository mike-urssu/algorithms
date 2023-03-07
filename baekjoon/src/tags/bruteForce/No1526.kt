package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1526
 */
fun main() {
    val n = readln().toInt()
    for (i in n downTo 4) {
        if (consistsOf4or7(i)) {
            println(i)
            return
        }
    }
}

private val list = listOf('4', '7')
private fun consistsOf4or7(n: Int) =
    n.toString().all { it in list }
