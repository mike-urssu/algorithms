package tags.string

/**
 * https://www.acmicpc.net/problem/21734
 */
fun main() {
    val s = readln()
    s.forEach {
        val sum = it.code.toString().sumOf { it.digitToInt() }
        println(it.toString().repeat(sum))
    }
}
