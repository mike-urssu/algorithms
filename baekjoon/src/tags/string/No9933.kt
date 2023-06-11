package tags.string

/**
 * https://www.acmicpc.net/problem/9933
 */
fun main() {
    val n = readln().toInt()
    val passwords = Array(n) { readln() }
    for (i in passwords.indices) {
        for (j in i until passwords.size) {
            if (passwords[i] == passwords[j].reversed()) {
                println("${passwords[i].length} ${passwords[i][passwords[i].length / 2]}")
                return
            }
        }
    }
}
