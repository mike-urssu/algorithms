package tags.data_structures

/**
 * https://www.acmicpc.net/problem/7785
 */
fun main() {
    val n = readln().toInt()
    val names = sortedSetOf<String>(Comparator.reverseOrder())
    repeat(n) {
        val (name, action) = readln().split(" ")
        if (action == "enter") {
            names.add(name)
        } else {
            names.remove(name)
        }
    }
    names.forEach { println(it) }
}
