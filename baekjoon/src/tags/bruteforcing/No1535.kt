package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1535
 */
private var n = 0
private lateinit var l: IntArray
private lateinit var j: IntArray
private var max = 0

fun main() {
    n = readln().toInt()
    l = readln().split(" ").map { it.toInt() }.toIntArray()
    j = readln().split(" ").map { it.toInt() }.toIntArray()
    findMaxHappiness(0, 100, 0)
    println(max)
}

private fun findMaxHappiness(index: Int, health: Int, pleasure: Int) {
    if (health <= 0) {
        return
    }

    if (index == n) {
        max = max.coerceAtLeast(pleasure)
        return
    }

    findMaxHappiness(index + 1, health - l[index], pleasure + j[index])
    findMaxHappiness(index + 1, health, pleasure)
}
