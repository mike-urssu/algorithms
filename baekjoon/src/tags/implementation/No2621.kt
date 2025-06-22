package tags.implementation

/**
 * https://www.acmicpc.net/problem/2621
 */
import kotlin.system.exitProcess

private val orders = charArrayOf('R', 'B', 'Y', 'G')
private lateinit var cards: Array<MutableList<Int>>
private lateinit var colorsCount: IntArray
private lateinit var numbersCount: IntArray

fun main() {
    cards = Array(4) { mutableListOf() }
    colorsCount = IntArray(4)
    numbersCount = IntArray(10)
    repeat(5) {
        val (c, n) = readln().split(" ")
        colorsCount[orders.indexOf(c[0])]++
        numbersCount[n.toInt()]++
        cards[orders.indexOf(c[0])].add(n.toInt())
    }

    condition1()
    condition2()
    condition3()
    condition4()
    condition5()
    condition6()
    condition7()
    condition8()
    condition9()
}

private fun condition1() {
    val index = cards.indexOfFirst { it.size == 5 }
    if (index != -1) {
        val numbers = cards[index].sorted()
        if (numbers.last() - numbers.first() == 4) {
            println(900 + numbers.last())
            exitProcess(0)
        }
    }
}

private fun condition2() {
    val index = numbersCount.indexOfFirst { it == 4 }
    if (index != -1) {
        println(800 + index)
        exitProcess(0)
    }
}

private fun condition3() {
    val index1 = numbersCount.indexOf(3)
    val index2 = numbersCount.indexOf(2)
    if (index1 != -1 && index2 != -1) {
        println(index1 * 10 + 700 + index2)
        exitProcess(0)
    }
}

private fun condition4() {
    val index = colorsCount.indexOf(5)
    if (index != -1) {
        println(600 + cards.first { it.size == 5 }.sorted().max())
        exitProcess(0)
    }
}

private fun condition5() {
    val index = (1..5).firstOrNull { i -> (0..4).all { j -> numbersCount[i + j] == 1 } } ?: -1
    if (index != -1) {
        println(500 + index + 4)
        exitProcess(0)
    }
}

private fun condition6() {
    val index = numbersCount.indexOf(3)
    if (index != -1) {
        println(400 + index)
        exitProcess(0)
    }
}

private fun condition7() {
    val index1 = numbersCount.indexOfFirst { it == 2 }
    val index2 = numbersCount.indexOfLast { it == 2 }
    if (index1 != -1 && index1 != index2) {
        println(10 * index2 + index1 + 300)
        exitProcess(0)
    }
}

private fun condition8() {
    val index = numbersCount.indexOf(2)
    if (index != -1) {
        println(200 + index)
        exitProcess(0)
    }
}

private fun condition9() {
    println(numbersCount.lastIndexOf(1) + 100)
    exitProcess(0)
}
