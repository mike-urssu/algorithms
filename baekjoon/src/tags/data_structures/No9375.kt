package tags.data_structures

/**
 * https://www.acmicpc.net/problem/9375
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val clothes = sortedMapOf<String, Int>()
        val n = readln().toInt()
        repeat(n) {
            val (_, tag) = readln().split(" ")
            clothes[tag] = (clothes[tag] ?: 0) + 1
        }
        val count = clothes.values.fold(1) { acc, size -> acc * (size + 1) } - 1
        println(count)
    }
}
