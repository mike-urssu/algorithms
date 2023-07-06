package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/10974
 */
fun main() {
    val n = readln().toInt()
    val numbers = IntArray(n) { it + 1 }
    val isVisited = BooleanArray(n)
    val permutation = IntArray(n)

    permutation(numbers, isVisited, permutation, 0, n)
}

private fun permutation(numbers: IntArray, isVisited: BooleanArray, permutation: IntArray, index: Int, n: Int) {
    if (index == n) {
        println(permutation.joinToString(" "))
        return
    }

    for (i in 0 until n) {
        if (!isVisited[i]) {
            permutation[index] = numbers[i]
            isVisited[i] = true
            permutation(numbers, isVisited, permutation, index + 1, n)
            isVisited[i] = false
        }
    }
}
