package tags.implementation

/**
 * https://www.acmicpc.net/problem/9660
 */
fun main() {
    val winners = arrayOf("CY", "SK", "CY", "SK", "SK", "SK", "SK")
    val n = readln().toLong()
    println(winners[(n % 7).toInt()])
}
