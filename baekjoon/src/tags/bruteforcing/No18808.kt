package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/18808
 */
private var n = 0
private var m = 0
private lateinit var stickers: Array<Array<BooleanArray>>
private lateinit var graph: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    val k = input[2]
    stickers = Array(k) {
        val (r, _) = readln().split(" ").map { it.toInt() }
        Array(r) { readln().split(" ").map { it == "1" }.toBooleanArray() }
    }

    graph = Array(n) { BooleanArray(m) }
    stickers.forEach { sticker ->
        attachSticker(sticker)
    }

    println(graph.sumOf { it.count { it } })
}

private fun attachSticker(sticker: Array<BooleanArray>) {
    var sticker = sticker
    repeat(4) {
        for (r in 0 until n) {
            for (c in 0 until m) {
                if (isAttachable(r, c, sticker)) {
                    attach(r, c, sticker)
                    return
                }
            }
        }
        sticker = rotateClockwise(sticker)
    }
}

private fun isAttachable(r: Int, c: Int, sticker: Array<BooleanArray>): Boolean {
    return isInBoundary(r, c, sticker) && !isOverlapped(r, c, sticker)
}

private fun isInBoundary(r: Int, c: Int, sticker: Array<BooleanArray>): Boolean {
    return r + sticker.size <= n && c + sticker[0].size <= m
}

private fun isOverlapped(r: Int, c: Int, sticker: Array<BooleanArray>): Boolean {
    sticker.indices.forEach { i ->
        sticker[i].indices.forEach { j ->
            if (graph[r + i][c + j] and sticker[i][j]) {
                return true
            }
        }
    }
    return false
}

private fun attach(r: Int, c: Int, sticker: Array<BooleanArray>) {
    sticker.indices.forEach { i ->
        sticker[i].indices.forEach { j ->
            graph[r + i][c + j] = graph[r + i][c + j] xor sticker[i][j]
        }
    }
}

private fun rotateClockwise(sticker: Array<BooleanArray>): Array<BooleanArray> {
    val r = sticker.size
    val c = sticker[0].size
    val newSticker = Array(c) { BooleanArray(r) }
    for (i in 0 until r) {
        for (j in 0 until c) {
            newSticker[j][r - 1 - i] = sticker[i][j]
        }
    }
    return newSticker
}
