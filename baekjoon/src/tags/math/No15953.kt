package tags.math

/**
 * https://www.acmicpc.net/problem/15953
 */
private val rangeAndPriceA = arrayOf(
    0..0 to 0,
    1..1 to 500,
    2..3 to 300,
    4..6 to 200,
    7..10 to 50,
    11..15 to 30,
    16..21 to 10,
    22..100 to 0
)

private val rangeAndPriceB = arrayOf(
    0..0 to 0,
    1..1 to 512,
    2..3 to 256,
    4..7 to 128,
    8..15 to 64,
    16..31 to 32,
    32..64 to 0
)

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        val priceA = rangeAndPriceA.first { a in it.first }.second
        val priceB = rangeAndPriceB.first { b in it.first }.second
        println((priceA + priceB) * 10000)
    }
}
