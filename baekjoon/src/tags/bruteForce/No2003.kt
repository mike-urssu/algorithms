package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2003
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }

    var count = 0
    var left = 0
    var right = 0
    var shiftedLeft = false
    var shiftedRight = false
    var sum = numbers[0]
    while (right < n) {
        if (shiftedLeft) {
            shiftedLeft = false
            sum -= numbers[left - 1]
        }
        if (shiftedRight) {
            shiftedRight = false
            sum += numbers[right]
        }

        if (sum > m) {
            shiftedLeft = true
            left++
        } else if (sum == m) {
            shiftedLeft = true
            left++

            shiftedRight = true
            right++

            count++
        } else {
            shiftedRight = true
            right++
        }
    }
    println(count)
}
