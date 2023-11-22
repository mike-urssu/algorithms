package tags.math

/**
 * https://www.acmicpc.net/problem/2485
 */
fun main() {
    val n = readln().toInt()
    val trees = IntArray(n) { readln().toInt() }

    val distance = (0 until n - 1).minOf { i -> trees[i + 1] - trees[i] }
    val d = (distance downTo 1).first { i -> isValid(n, trees, i) }
    println(getMinTrees(n, trees, d))
}

private fun isValid(n: Int, trees: IntArray, distance: Int) =
    (0 until n - 1).all { i -> (trees[i + 1] - trees[i]) % distance == 0 }

private fun getMinTrees(n: Int, trees: IntArray, distance: Int) =
    (0 until n - 1).sumOf { i -> (trees[i + 1] - trees[i]) / distance - 1 }
