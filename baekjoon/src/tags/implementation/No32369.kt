package tags.implementation

/**
 * https://www.acmicpc.net/problem/32369
 */
fun main() {
    val (n, a, b) = readln().split(" ").map { it.toInt() }
    var praise = 1
    var blame = 1
    repeat(n) {
        praise += a
        blame += b
        if (praise < blame) {
            val temp = praise
            praise = blame
            blame = temp
        } else if (praise == blame) {
            blame--
        }
    }
    println("$praise $blame")
}
