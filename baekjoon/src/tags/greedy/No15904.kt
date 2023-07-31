package tags.greedy

/**
 * https://www.acmicpc.net/problem/15904
 */
fun main() {
    val ucpc = charArrayOf('U', 'C', 'P', 'C')
    var index = 0
    val s = readln()
    for (i in s.indices) {
        if (s[i] == ucpc[index]) {
            index++
            if (index == 4) {
                break
            }
        }
    }
    if (index == ucpc.size) {
        println("I love UCPC")
    } else {
        println("I hate UCPC")
    }
}
