package tags.data_structures

/**
 * https://www.acmicpc.net/problem/19583
 */
private val reader = System.`in`.bufferedReader()

fun main() {
    val (s, e, q) = reader.readLine().split(" ")
    val students = reader.readLines().map {
        val (time, name) = it.split(" ")
        time to name
    }

    val isVisited = mutableSetOf<String>()
    students.forEach { (time, name) ->
        if (isBefore(s, time)) {
            isVisited.add(name)
        }
    }

    var count = 0
    students.forEach { (time, name) ->
        if (isVisited.contains(name) && isAfter(e, time) && isBefore(q, time)) {
            isVisited.remove(name)
            count++
        }
    }

    println(count)
}

private fun isBefore(time1: String, time2: String): Boolean {
    val (h1, m1) = time1.split(":")
    val (h2, m2) = time2.split(":")

    return if (h2 <= h1) {
        (!(h2 == h1 && m2 > m1))
    } else {
        false
    }
}

private fun isAfter(time1: String, time2: String): Boolean {
    val (h1, m1) = time1.split(":")
    val (h2, m2) = time2.split(":")

    return if (h2 >= h1) {
        !(h2 == h1 && m2 < m1)
    } else {
        false
    }
}
