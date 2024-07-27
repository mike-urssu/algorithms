package tags.implementation

/**
 * https://www.acmicpc.net/problem/26766
 */
fun main() {
    val writer = System.out.bufferedWriter()
    val love = """
 @@@   @@@ 
@   @ @   @
@    @    @
@         @
 @       @ 
  @     @  
   @   @   
    @ @    
     @     
    """.trimIndent()
    val n = readln().toInt()
    repeat(n) {
        writer.write("$love\n")
    }
    writer.flush()
}
