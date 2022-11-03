package week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.TreeMap

/**
 * https://www.acmicpc.net/problem/2531
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private val myFoods: Queue<Int> = LinkedList()
private val typesOfFood = TreeMap<Int, Int>()

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val plates = numbers[0]
    val row = numbers[2]
    val coupon = numbers[3]

    val types = ArrayList<Int>()
    repeat(plates) { types.add(reader.readLine().toInt()) }

    repeat(row) { i -> add(types[i]) }
    var max = typesOfFood.size

    repeat(plates) { i ->
        poll()
        add(types[(plates + row + i) % plates])
        max = max.coerceAtLeast(typesOfFood.size + if (typesOfFood.containsKey(coupon)) 0 else 1)
    }

    writer.write("$max")
    writer.flush()
}

private fun add(type: Int) {
    myFoods.add(type)
    typesOfFood[type] = typesOfFood.getOrDefault(type, 0) + 1
}

private fun poll() {
    val type = myFoods.poll()
    typesOfFood[type] = typesOfFood[type]!! - 1
    if (typesOfFood[type] == 0) {
        typesOfFood.remove(type)
    }
}