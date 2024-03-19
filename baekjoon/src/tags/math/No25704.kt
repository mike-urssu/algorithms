package tags.math

/**
 * https://www.acmicpc.net/problem/25704
 */
fun main() {
    val n = readln().toInt()
    val p = readln().toInt()
    var price = p
    if (n >= 5) {
        price = price.coerceAtMost(p - 500)
        price = price.coerceAtLeast(0)
    }
    if (n >= 10) {
        price = price.coerceAtMost(p * 90 / 100)
    }
    if (n >= 15) {
        price = price.coerceAtMost(p - 2000)
        price = price.coerceAtLeast(0)
    }
    if (n >= 20) {
        price = price.coerceAtMost(p * 75 / 100)
    }
    println(price)
}
