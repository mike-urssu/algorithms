package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/19941
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val str = readln().toCharArray()

    val people = (0 until n).filter { i -> str[i] == 'P' }
    val isVisited = BooleanArray(n).apply {
        people.forEach { i -> this[i] = true }
    }

    var count = 0
    people.forEach { i ->
        for (j in i - k..i + k) {
            if (j in 0 until n && !isVisited[j]) {
                isVisited[j] = true
                count++
                break
            }
        }
    }
    println(count)
}
