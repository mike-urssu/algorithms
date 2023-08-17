package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/2725
 */
fun main() {
    val prefixSum = getPrefixSum()
    val c = readln().toInt()
    repeat(c) {
        val n = readln().toInt()
        println(prefixSum[n])
    }
}

private fun getPrefixSum(): IntArray {
    val array = IntArray(1001)
    array[1] = 3
    for (i in 2 until array.size) {
        for (j in 1 until i) {
            if (getGCD(i, j) == 1) {
                array[i] += 2
            }
        }
    }
    return array.runningFold(0, Int::plus).drop(1).toIntArray()
}

private fun getGCD(n1: Int, n2: Int): Int {
    return if (n2 == 0) {
        n1
    } else {
        getGCD(n2, n1 % n2)
    }
}
