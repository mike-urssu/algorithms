package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.log
import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/1456
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var primeArray: BooleanArray

fun main() {
    setPrimeArray()
    val numbers = reader.readLine().split(" ").map { it.toLong() }
    writer.write("${getAlmostPrimeCount(numbers[1]) - getAlmostPrimeCount(numbers[0] - 1)}")
    writer.flush()
}

private fun setPrimeArray() {
    val size = 10000001
    primeArray = BooleanArray(size) { true }
    primeArray[0] = false
    primeArray[1] = false
    val sqrt = sqrt(size.toDouble()).toInt()

    for (i in 2..sqrt) {
        for (j in i * i until size step i) {
            primeArray[j] = false
        }
    }
}

private fun getAlmostPrimeCount(number: Long): Int {
    val sqrt = sqrt(number.toDouble()).toInt()

    var count = 0
    for (i in 2..sqrt) {
        if (primeArray[i]) {
            // log(243.0, 3.0) = 4.99999
            // 부동소수점으로 인해 결과값의 오차가 발생하기 때문에
            // number에 0.1을 더해서 오차 범위를 줄임
            count += log(number.toDouble() + 0.1, i.toDouble()).toInt() - 1
        }
    }
    return count
}