package tags.implementation

/**
 * https://www.acmicpc.net/problem/31994
 */
fun main() {
    val seminars = Array(7) {
        val input = readln().split(" ")
        val name = input[0]
        val proposers = input[1].toInt()
        name to proposers
    }

    val seminar = seminars.maxBy { it.second }.first
    println(seminar)
}
