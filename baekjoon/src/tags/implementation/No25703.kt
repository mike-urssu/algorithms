package tags.implementation

/**
 * https://www.acmicpc.net/problem/25703
 */
fun main() {
    val n = readln().toInt()
    println("int a;")
    println("int *ptr = &a;")
    if (n >= 2) {
        println("int **ptr2 = &ptr;")
    }
    (3..n).forEach { i ->
        println("int ${"*".repeat(i)}ptr$i = &ptr${i - 1};")
    }
}
