package tags.math

/**
 * https://www.acmicpc.net/problem/6763
 */
fun main() {
    val speedLimit = readln().toInt()
    val recordedSpeed = readln().toInt()
    if (recordedSpeed - speedLimit <= 0) {
        println("Congratulations, you are within the speed limit!")
    } else if (recordedSpeed - speedLimit in 1..20) {
        println("You are speeding and your fine is \$100.")
    } else if (recordedSpeed - speedLimit in 21..30) {
        println("You are speeding and your fine is \$270.")
    } else {
        println("You are speeding and your fine is \$500.")
    }
}
