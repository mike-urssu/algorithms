package tags.data_structures

/**
 * https://www.acmicpc.net/problem/25192
 */
fun main() {
    val n = readln().toInt()
    var names = mutableSetOf<String>()
    var count = 0
    for (i in 0 until n) {
        val s = readln()
        if (s == "ENTER") {
            names = mutableSetOf()
        } else {
            if (!names.contains(s)) {
                names.add(s)
                count++
            }
        }
    }
    println(count)
}
