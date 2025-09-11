package tags.sorting

/**
 * https://www.acmicpc.net/problem/23881
 */
import kotlin.system.exitProcess

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    var swap = 0
    for (i in n - 1 downTo 1) {
        val index = (0..i).maxBy { numbers[it] }
        if (index != i) {
            numbers.swap(index, i)
            swap++

            if (swap == k) {
                println("${numbers[index]} ${numbers[i]}")
                exitProcess(0)
            }
        }
    }
    println(-1)
}

private fun IntArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}
