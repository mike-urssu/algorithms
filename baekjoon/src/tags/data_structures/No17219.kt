package tags.data_structures

/**
 * https://www.acmicpc.net/problem/17219
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val sitesAndPasswords = mutableMapOf<String, String>()
    repeat(n) {
        val (site, password) = readln().split(" ")
        sitesAndPasswords[site] = password
    }
    repeat(m) {
        val site = readln()
        println(sitesAndPasswords[site])
    }
}
