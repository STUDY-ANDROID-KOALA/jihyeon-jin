fun main() {
    val (N, K) = readln().split(" ").map {it.toInt()}
    val list = readln().split(" ").map {it.toDouble()}
    
    var minDeviation = Double.MAX_VALUE

    for(i in K..N) {
        for(start in 0..N-i){
        val subList = list.subList(start, start + i)
        val avg = subList.sum() / i
        val variance = subList.sumOf { (it - avg) * (it - avg) } / i
        val deviation = Math.sqrt(variance)
        if(deviation < minDeviation)
            minDeviation = deviation
        }
    }

    println(minDeviation)

}
