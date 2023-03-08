package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2154
 */
fun main() {
    val n = readln()

    val number = StringBuilder()
    var index = 1
    while (true) {
        for (ch in index.toString()) {
            number.append(ch)
            if (number.endsWith(n)) {
                println(number.length - n.length + 1)
                return
            }
        }
        index++
    }
}
