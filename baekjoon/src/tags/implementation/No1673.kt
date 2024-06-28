package tags.implementation

/**
 * https://www.acmicpc.net/problem/1673
 */
fun main() {
    while (true) {
        val input = readlnOrNull() ?: break
        val (n, k) = input.split(" ").map { it.toInt() }
        println(getChicken(n, k))
    }
}

private fun getChicken(n: Int, k: Int): Int {
    var chicken = 0
    var coupon = n
    var stamp = 0
    while (coupon > 0) {
        chicken += coupon
        stamp += coupon
        coupon = stamp / k
        stamp %= k
    }
    return chicken
}
