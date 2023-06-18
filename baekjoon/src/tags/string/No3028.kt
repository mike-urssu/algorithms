package tags.string

/**
 * https://www.acmicpc.net/problem/3028
 */
fun main() {
    var index = 1
    readln().toCharArray().forEach { order ->
        when (order) {
            'A' -> if (index == 1) {
                index = 2
            } else if (index == 2) {
                index = 1
            }

            'B' -> if (index == 2) {
                index = 3
            } else if (index == 3) {
                index = 2
            }

            'C' -> if (index == 3) {
                index = 1
            } else if (index == 1) {
                index = 3
            }
        }
    }
    println(index)
}
