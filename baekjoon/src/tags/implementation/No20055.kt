package tags.implementation

/**
 * https://www.acmicpc.net/problem/20055
 */
private lateinit var conveyorBelts: IntArray
private lateinit var isRobotExist: BooleanArray
private var zeros = 0

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    conveyorBelts = readln().split(" ").map { it.toInt() }.toIntArray()
    isRobotExist = BooleanArray(2 * n)

    var currentStep = 0
    while (true) {
        if (zeros >= k) {
            break
        }
        rotate(n)
        currentStep++
    }

    println(currentStep)
}

private fun rotate(n: Int) {
    rotateConveyorBelts(n)
    moveRobots(n)

    if (conveyorBelts[0] > 0 && !isRobotExist[0]) {
        conveyorBelts[0]--
        isRobotExist[0] = true
        if (conveyorBelts[0] == 0) {
            zeros++
        }
    }
}

private fun rotateConveyorBelts(n: Int) {
    val lastConveyorBelt = conveyorBelts.last()
    val isLastRobotExist = isRobotExist.last()
    (2 * n - 1 downTo 1).forEach { i ->
        conveyorBelts[i] = conveyorBelts[i - 1]
        isRobotExist[i] = isRobotExist[i - 1]
    }
    conveyorBelts[0] = lastConveyorBelt
    isRobotExist[0] = isLastRobotExist
    isRobotExist[n - 1] = false
}

private fun moveRobots(n: Int) {
    (n - 2 downTo 0).forEach { i ->
        if (isRobotExist[i] && !isRobotExist[i + 1] && conveyorBelts[i + 1] > 0) {
            isRobotExist[i] = false
            isRobotExist[i + 1] = true
            conveyorBelts[i + 1]--
            if (conveyorBelts[i + 1] == 0) {
                zeros++
            }
        }
    }
    isRobotExist[n - 1] = false
}
