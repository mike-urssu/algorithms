package tags.string

/**
 * https://www.acmicpc.net/problem/21942
 */
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val reader = System.`in`.bufferedReader()
private val writer = System.out.bufferedWriter()

private val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
private val map = mutableMapOf<Pair<String, String>, LocalDateTime>()
private val fines = sortedMapOf<String, Long>()

fun main() {
    val input = reader.readLine().split(" ")
    val n = input[0].toInt()
    val l = input[1]
    val f = input[2].toInt()

    val dueDays = l.substring(0, 3).toLong()
    val dueHours = l.substring(4, 6).toLong()
    val dueMinutes = l.substring(7).toLong()

    repeat(n) {
        val (d1, d2, product, name) = reader.readLine().split(" ")
        val date = LocalDateTime.parse("$d1 $d2", dateTimeFormatter)
        val target = name to product
        if (map.containsKey(target)) {
            val diff = getDiff(map.remove(target)!!, date)
            if (diff > 0) {
                fines[name] = (fines[name] ?: 0) + diff
            }
        } else {
            val dueDate = date.plusDays(dueDays).plusHours(dueHours).plusMinutes(dueMinutes)
            map[target] = dueDate
        }
    }

    if (fines.isEmpty()) {
        println(-1)
    } else {
        fines.forEach { (t, u) -> writer.write("$t ${u * f}\n") }
    }
    writer.flush()
}

private fun getDiff(date1: LocalDateTime, date2: LocalDateTime) =
    Duration.between(date1, date2).toMinutes()
