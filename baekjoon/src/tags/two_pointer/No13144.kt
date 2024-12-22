package tags.two_pointer

/**
 * https://www.acmicpc.net/problem/13144
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    val isVisited = BooleanArray(100001)

    var count = 0L
    var left = 0
    var right = 0
    while (left < n) {
        while (right < n && !isVisited[numbers[right]]) {
            isVisited[numbers[right++]] = true
        }
        isVisited[numbers[left]] = false
        count += right - left
        left++
    }
    println(count)
}
