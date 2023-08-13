package tags.data_structures

/**
 * https://www.acmicpc.net/problem/11478
 */
fun main() {
    val s = readln()
    val set = mutableSetOf<String>()
    for (i in s.indices) {
        for (j in 1..s.length - i) {
            set.add(s.substring(i, i + j))
        }
    }
    println(set.size)
}
