package tags.implementation

/**
 * https://www.acmicpc.net/problem/5373
 */
private val cube = arrayOf(
    arrayOf(
        charArrayOf('w', 'w', 'w'),
        charArrayOf('w', 'w', 'w'),
        charArrayOf('w', 'w', 'w')
    ),
    arrayOf(
        charArrayOf('y', 'y', 'y'),
        charArrayOf('y', 'y', 'y'),
        charArrayOf('y', 'y', 'y')
    ),
    arrayOf(
        charArrayOf('r', 'r', 'r'),
        charArrayOf('r', 'r', 'r'),
        charArrayOf('r', 'r', 'r')
    ),
    arrayOf(
        charArrayOf('o', 'o', 'o'),
        charArrayOf('o', 'o', 'o'),
        charArrayOf('o', 'o', 'o')
    ),
    arrayOf(
        charArrayOf('g', 'g', 'g'),
        charArrayOf('g', 'g', 'g'),
        charArrayOf('g', 'g', 'g')
    ),
    arrayOf(
        charArrayOf('b', 'b', 'b'),
        charArrayOf('b', 'b', 'b'),
        charArrayOf('b', 'b', 'b')
    )
)

private lateinit var up: Array<CharArray>
private lateinit var down: Array<CharArray>
private lateinit var front: Array<CharArray>
private lateinit var back: Array<CharArray>
private lateinit var left: Array<CharArray>
private lateinit var right: Array<CharArray>

fun main() {
    val t = readln().toInt()
    repeat(t) {
        init()
        val n = readln().toInt()
        val commands = readln().split(" ")
        repeat(n) {
            when (commands[it]) {
                "U+" -> upClockwise()
                "U-" -> upCounterClockwise()
                "D+" -> downClockwise()
                "D-" -> downCounterClockwise()
                "F+" -> frontClockwise()
                "F-" -> frontCounterClockwise()
                "B+" -> backClockwise()
                "B-" -> backCounterClockwise()
                "L+" -> leftClockwise()
                "L-" -> leftCounterClockwise()
                "R+" -> rightClockwise()
                "R-" -> rightCounterClockwise()
            }
        }
        up.forEach { println(it.joinToString("")) }
    }
}

private fun init() {
    up = Array(3) { cube[0][it].copyOf() }
    down = Array(3) { cube[1][it].copyOf() }
    front = Array(3) { cube[2][it].copyOf() }
    back = Array(3) { cube[3][it].copyOf() }
    left = Array(3) { cube[4][it].copyOf() }
    right = Array(3) { cube[5][it].copyOf() }
}

private fun upClockwise() {
    rotateClockwise(up)

    val temp = charArrayOf(front[0][0], front[0][1], front[0][2])
    front[0][0] = right[0][0]
    front[0][1] = right[0][1]
    front[0][2] = right[0][2]
    right[0][0] = back[0][0]
    right[0][1] = back[0][1]
    right[0][2] = back[0][2]
    back[0][0] = left[0][0]
    back[0][1] = left[0][1]
    back[0][2] = left[0][2]
    left[0][0] = temp[0]
    left[0][1] = temp[1]
    left[0][2] = temp[2]
}

private fun upCounterClockwise() {
    rotateCounterClockwise(up)

    val temp = charArrayOf(front[0][0], front[0][1], front[0][2])
    front[0][0] = left[0][0]
    front[0][1] = left[0][1]
    front[0][2] = left[0][2]
    left[0][0] = back[0][0]
    left[0][1] = back[0][1]
    left[0][2] = back[0][2]
    back[0][0] = right[0][0]
    back[0][1] = right[0][1]
    back[0][2] = right[0][2]
    right[0][0] = temp[0]
    right[0][1] = temp[1]
    right[0][2] = temp[2]
}

private fun downClockwise() {
    rotateClockwise(down)

    val temp = charArrayOf(front[2][0], front[2][1], front[2][2])
    front[2][0] = left[2][0]
    front[2][1] = left[2][1]
    front[2][2] = left[2][2]
    left[2][0] = back[2][0]
    left[2][1] = back[2][1]
    left[2][2] = back[2][2]
    back[2][0] = right[2][0]
    back[2][1] = right[2][1]
    back[2][2] = right[2][2]
    right[2][0] = temp[0]
    right[2][1] = temp[1]
    right[2][2] = temp[2]
}

private fun downCounterClockwise() {
    rotateCounterClockwise(down)

    val temp = charArrayOf(front[2][0], front[2][1], front[2][2])
    front[2][0] = right[2][0]
    front[2][1] = right[2][1]
    front[2][2] = right[2][2]
    right[2][0] = back[2][0]
    right[2][1] = back[2][1]
    right[2][2] = back[2][2]
    back[2][0] = left[2][0]
    back[2][1] = left[2][1]
    back[2][2] = left[2][2]
    left[2][0] = temp[0]
    left[2][1] = temp[1]
    left[2][2] = temp[2]
}

private fun frontClockwise() {
    rotateClockwise(front)

    val temp = charArrayOf(up[2][2], up[2][1], up[2][0])
    up[2][2] = left[0][2]
    up[2][1] = left[1][2]
    up[2][0] = left[2][2]
    left[0][2] = down[0][0]
    left[1][2] = down[0][1]
    left[2][2] = down[0][2]
    down[0][0] = right[2][0]
    down[0][1] = right[1][0]
    down[0][2] = right[0][0]
    right[2][0] = temp[0]
    right[1][0] = temp[1]
    right[0][0] = temp[2]
}

private fun frontCounterClockwise() {
    rotateCounterClockwise(front)

    val temp = charArrayOf(up[2][0], up[2][1], up[2][2])
    up[2][0] = right[0][0]
    up[2][1] = right[1][0]
    up[2][2] = right[2][0]
    right[0][0] = down[0][2]
    right[1][0] = down[0][1]
    right[2][0] = down[0][0]
    down[0][2] = left[2][2]
    down[0][1] = left[1][2]
    down[0][0] = left[0][2]
    left[2][2] = temp[0]
    left[1][2] = temp[1]
    left[0][2] = temp[2]
}

private fun backClockwise() {
    rotateClockwise(back)

    val temp = charArrayOf(up[0][0], up[0][1], up[0][2])
    up[0][0] = right[0][2]
    up[0][1] = right[1][2]
    up[0][2] = right[2][2]
    right[0][2] = down[2][2]
    right[1][2] = down[2][1]
    right[2][2] = down[2][0]
    down[2][2] = left[2][0]
    down[2][1] = left[1][0]
    down[2][0] = left[0][0]
    left[2][0] = temp[0]
    left[1][0] = temp[1]
    left[0][0] = temp[2]
}

private fun backCounterClockwise() {
    rotateCounterClockwise(back)

    val temp = charArrayOf(up[0][2], up[0][1], up[0][0])
    up[0][2] = left[0][0]
    up[0][1] = left[1][0]
    up[0][0] = left[2][0]
    left[0][0] = down[2][0]
    left[1][0] = down[2][1]
    left[2][0] = down[2][2]
    down[2][0] = right[2][2]
    down[2][1] = right[1][2]
    down[2][2] = right[0][2]
    right[2][2] = temp[0]
    right[1][2] = temp[1]
    right[0][2] = temp[2]
}

private fun leftClockwise() {
    rotateClockwise(left)

    val temp = charArrayOf(front[0][0], front[1][0], front[2][0])
    front[0][0] = up[0][0]
    front[1][0] = up[1][0]
    front[2][0] = up[2][0]
    up[0][0] = back[2][2]
    up[1][0] = back[1][2]
    up[2][0] = back[0][2]
    back[2][2] = down[0][0]
    back[1][2] = down[1][0]
    back[0][2] = down[2][0]
    down[0][0] = temp[0]
    down[1][0] = temp[1]
    down[2][0] = temp[2]
}

private fun leftCounterClockwise() {
    rotateCounterClockwise(left)

    val temp = charArrayOf(front[0][0], front[1][0], front[2][0])
    front[0][0] = down[0][0]
    front[1][0] = down[1][0]
    front[2][0] = down[2][0]
    down[0][0] = back[2][2]
    down[1][0] = back[1][2]
    down[2][0] = back[0][2]
    back[2][2] = up[0][0]
    back[1][2] = up[1][0]
    back[0][2] = up[2][0]
    up[0][0] = temp[0]
    up[1][0] = temp[1]
    up[2][0] = temp[2]
}

private fun rightClockwise() {
    rotateClockwise(right)

    val temp = charArrayOf(up[0][2], up[1][2], up[2][2])
    up[0][2] = front[0][2]
    up[1][2] = front[1][2]
    up[2][2] = front[2][2]
    front[0][2] = down[0][2]
    front[1][2] = down[1][2]
    front[2][2] = down[2][2]
    down[0][2] = back[2][0]
    down[1][2] = back[1][0]
    down[2][2] = back[0][0]
    back[2][0] = temp[0]
    back[1][0] = temp[1]
    back[0][0] = temp[2]
}

private fun rightCounterClockwise() {
    rotateCounterClockwise(right)

    val temp = charArrayOf(up[2][2], up[1][2], up[0][2])
    up[2][2] = back[0][0]
    up[1][2] = back[1][0]
    up[0][2] = back[2][0]
    back[0][0] = down[2][2]
    back[1][0] = down[1][2]
    back[2][0] = down[0][2]
    down[2][2] = front[2][2]
    down[1][2] = front[1][2]
    down[0][2] = front[0][2]
    front[2][2] = temp[0]
    front[1][2] = temp[1]
    front[0][2] = temp[2]
}

private fun rotateClockwise(array: Array<CharArray>) {
    val colors = charArrayOf(array[0][0], array[0][1], array[0][2], array[1][2], array[2][2], array[2][1], array[2][0], array[1][0])
    array[0][0] = colors[6]
    array[0][1] = colors[7]
    array[0][2] = colors[0]
    array[1][2] = colors[1]
    array[2][2] = colors[2]
    array[2][1] = colors[3]
    array[2][0] = colors[4]
    array[1][0] = colors[5]
}

private fun rotateCounterClockwise(array: Array<CharArray>) {
    val colors = charArrayOf(array[0][0], array[0][1], array[0][2], array[1][2], array[2][2], array[2][1], array[2][0], array[1][0])
    array[0][0] = colors[2]
    array[0][1] = colors[3]
    array[0][2] = colors[4]
    array[1][2] = colors[5]
    array[2][2] = colors[6]
    array[2][1] = colors[7]
    array[2][0] = colors[0]
    array[1][0] = colors[1]
}
