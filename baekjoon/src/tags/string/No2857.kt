package tags.string

/**
 * https://www.acmicpc.net/problem/2857
 */
fun main() {
    val indices = mutableListOf<Int>()
    for (i in 1..5) {
        if (readln().contains("FBI")) {
            indices.add(i)
        }
    }
    if (indices.isEmpty()) {
        println("HE GOT AWAY!")
    } else {
        println(indices.joinToString(" "))
    }
}
