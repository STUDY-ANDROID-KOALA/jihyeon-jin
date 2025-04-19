fun main() {
    val T = readln().toInt()

    for(i in 0 until T) {
        val (a, b) = readln().split(" ")
        println(getMoney(a.toInt(), b.toInt()) )
    }
}

fun getMoney(a: Int, b: Int) : Int { 
   val firstMoney = when(a) {
        1 ->  500
        in 2..3 -> 300
        in 4..6 -> 200
        in 7..10 -> 50
        in 11..15 -> 30
        in 16..21 -> 10
        else -> 0
    }
   val secondMoney = when(b) {
        1 -> 512
        in 2..3 -> 256
        in 4..7 -> 128
        in 8..15 -> 64
        in 16..31 -> 32
        else -> 0
    }
    return (firstMoney + secondMoney) * 10000
}
