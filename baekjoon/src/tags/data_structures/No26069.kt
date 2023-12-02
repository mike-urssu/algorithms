package tags.data_structures

/**
 * https://www.acmicpc.net/problem/26069
 */
fun main() {
    val n = readln().toInt()
    val names = mutableSetOf<String>().apply { this.add("ChongChong") }
    repeat(n) {
        val (a, b) = readln().split(" ")
        if (names.contains(a)) {
            names.add(b)
        } else if (names.contains(b)) {
            names.add(a)
        }
    }
    println(names.size)
}
