package tags.implementation

/**
 * https://www.acmicpc.net/problem/2840
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val movements = Array(k) {
        val (s, c) = readln().split(" ")
        s.toInt() to c[0]
    }

    var index = 0
    val wheel = CharArray(n)
    val isVisited = BooleanArray(26)
    movements.forEach { (s, c) ->
        index = (index + s) % n
        if (wheel[index] == '\u0000') {
            if (isVisited[c - 'A']) {
                println("!")
                return
            }
            isVisited[c - 'A'] = true
            wheel[index] = c
        } else if (wheel[index] != c) {
            println("!")
            return
        }
    }

    val s = StringBuilder()
    (index downTo 0).forEach {
        if (wheel[it] == '\u0000') {
            s.append('?')
        } else {
            s.append(wheel[it])
        }
    }
    (n - 1 downTo index + 1).forEach {
        if (wheel[it] == '\u0000') {
            s.append('?')
        } else {
            s.append(wheel[it])
        }
    }
    println(s)
}
