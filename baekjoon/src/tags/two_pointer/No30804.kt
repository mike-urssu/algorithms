package tags.two_pointer

/**
 * https://www.acmicpc.net/problem/30804
 */
fun main() {
    val n = readln().toInt()
    val fruits = readln().split(" ").map { it.toInt() }.toIntArray()

    val counts = IntArray(10).apply { this[fruits[0]]++ }
    var count = 1
    var max = 1
    var visited = 1
    var left = 0
    var right = 1
    while (right < n) {
        if (counts[fruits[right]] != 0) {
            counts[fruits[right++]]++
            max = max.coerceAtLeast(++count)
        } else {
            if (visited < 2) {
                counts[fruits[right++]]++
                visited++
                max = max.coerceAtLeast(++count)
            } else {
                while (true) {
                    counts[fruits[left]]--
                    count--
                    if (counts[fruits[left]] == 0) {
                        visited--
                        left++
                        break
                    }
                    left++
                }
            }
        }
    }
    println(max)
}
