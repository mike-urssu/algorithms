package tags.implementation

/**
 * https://www.acmicpc.net/problem/27160
 */
fun main() {
    val fruits = arrayOf("STRAWBERRY", "BANANA", "LIME", "PLUM")
    val counts = IntArray(4)

    val n = readln().toInt()
    repeat(n) {
        val (fruit, count) = readln().split(" ")
        val index = fruits.indexOf(fruit)
        counts[index] += count.toInt()
    }

    if (counts.any { it == 5 }) {
        println("YES")
    } else {
        println("NO")
    }
}
