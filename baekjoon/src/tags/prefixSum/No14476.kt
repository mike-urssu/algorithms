package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/14476
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    val prefixGCDsInOrder = getPrefixGCDsInOrder(n, numbers)
    val prefixGCDsInReversedOrder = getPrefixGCDsInReversedOrder(n, numbers)

    var index = -1
    var maxGCD = Int.MIN_VALUE
    for (i in numbers.indices) {
        val k = numbers[i]
        val gcd = when (i) {
            0 -> prefixGCDsInReversedOrder[1]
            numbers.lastIndex -> prefixGCDsInOrder[n - 2]
            else -> getGCD(prefixGCDsInOrder[i - 1], prefixGCDsInReversedOrder[i + 1])
        }

        if (k % gcd != 0 && gcd > maxGCD) {
            index = i
            maxGCD = gcd
        }
    }

    if (index == -1) {
        println(index)
    } else {
        println("$maxGCD ${numbers[index]}")
    }
}

private fun getPrefixGCDsInOrder(n: Int, numbers: IntArray): IntArray {
    val prefixGCDsInOrder = IntArray(n)
    prefixGCDsInOrder[0] = numbers.first()
    (1 until n).forEach { i -> prefixGCDsInOrder[i] = getGCD(numbers[i], prefixGCDsInOrder[i - 1]) }
    return prefixGCDsInOrder
}

private fun getPrefixGCDsInReversedOrder(n: Int, numbers: IntArray): IntArray {
    val prefixGCDsInReversedOrder = IntArray(n)
    prefixGCDsInReversedOrder[n - 1] = numbers.last()
    (n - 2 downTo 0).forEach { i ->
        prefixGCDsInReversedOrder[i] = getGCD(numbers[i], prefixGCDsInReversedOrder[i + 1])
    }
    return prefixGCDsInReversedOrder
}

private fun getGCD(n1: Int, n2: Int): Int {
    return if (n2 == 0) {
        n1
    } else {
        getGCD(n2, n1 % n2)
    }
}
