package tags.string

/**
 * https://www.acmicpc.net/problem/2002
 */
fun main() {
    val n = readln().toInt()
    val cars1 = Array(n) { readln() }
    val cars2 = Array(n) { readln() }
    val count = countOvertakenCars(cars1, cars2)
    println(count)
}

private fun countOvertakenCars(cars1: Array<String>, cars2: Array<String>): Int {
    var count = 0
    for (i in cars2.indices) {
        val index = cars1.indexOf(cars2[i])
        if ((0 until index).any { j -> cars2.indexOf(cars1[j]) >= i }) {
            count++
        }
    }
    return count
}
