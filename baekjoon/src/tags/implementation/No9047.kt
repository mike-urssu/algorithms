package tags.implementation

/**
 * https://www.acmicpc.net/problem/9047
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        var n = readln().toInt()
        var count = 0
        while (n != 6174) {
            n = next(n)
            count++
        }
        println(count)
    }
}

private fun next(n: Int): Int {
    val digits = IntArray(4)
    digits[0] = n / 1000
    digits[1] = (n % 1000) / 100
    digits[2] = (n % 100) / 10
    digits[3] = n % 10

    val d1 = digits.sortedDescending()
    val d2 = digits.sorted()
    return (d1[0] * 1000 + d1[1] * 100 + d1[2] * 10 + d1[3]) - (d2[0] * 1000 + d2[1] * 100 + d2[2] * 10 + d2[3])
}
