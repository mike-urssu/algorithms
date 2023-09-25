package tags.bfs

/**
 * https://www.acmicpc.net/problem/9019
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        println(getCommand(a, b))
    }
}

private fun getCommand(a: Int, b: Int): String {
    var command = ""
    val isVisited = BooleanArray(10001)
    val queue: Queue<Pair<Int, String>> = LinkedList()

    isVisited[a] = true
    queue.add(Pair(a, ""))

    while (queue.isNotEmpty()) {
        val (n, c) = queue.poll()
        if (n == b) {
            command = c
            break
        }

        val d = getD(n)
        if (!isVisited[d]) {
            isVisited[d] = true
            queue.add(Pair(d, c + 'D'))
        }

        val s = getS(n)
        if (!isVisited[s]) {
            isVisited[s] = true
            queue.add(Pair(s, c + 'S'))
        }

        val l = getL(n)
        if (!isVisited[l]) {
            isVisited[l] = true
            queue.add(Pair(l, c + 'L'))
        }

        val r = getR(n)
        if (!isVisited[r]) {
            isVisited[r] = true
            queue.add(Pair(r, c + 'R'))
        }
    }

    return command
}

private fun getD(n: Int) =
    n * 2 % 10000

private fun getS(n: Int) =
    if (n == 0) {
        9999
    } else {
        n - 1
    }

private fun getL(n: Int) =
    (n % 1000) * 10 + n / 1000

private fun getR(n: Int) =
    (n % 10) * 1000 + n / 10
