package tags.implementation

/**
 * https://www.acmicpc.net/problem/27111
 */
fun main() {
    val isVisited = BooleanArray(200_001)
    var count = 0
    val n = readln().toInt()
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (!isVisited[a]) {
            if (b == 1) {
                isVisited[a] = true
            } else {
                count++
            }
        } else {
            if (b == 1) {
                count++
            } else {
                isVisited[a] = false
            }
        }
    }
    println(count + isVisited.count { it })
}
