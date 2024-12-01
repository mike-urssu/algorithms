package tags.greedy

/**
 * https://www.acmicpc.net/problem/1105
 */
fun main() {
    val (left, right) = readln().split(" ")
    val min = if (left.length != right.length) {
        0
    } else {
        var count = 0
        for (i in left.indices) {
            if (left[i] == right[i]) {
                if (left[i] == '8') {
                    count++
                }
            } else {
                break
            }
        }
        count
    }
    println(min)
}
