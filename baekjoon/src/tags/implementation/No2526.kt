package tags.implementation

/**
 * https://www.acmicpc.net/problem/2526
 */
fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val n = input[0] % input[1]
    val p = input[1]
    var v = n
    val numbers = IntArray(98)
    while (true) {
        if (numbers[v] == 2) {
            break
        }
        numbers[v]++
        v = (v * n) % p
    }
    println(numbers.count { it == 2 })
}
