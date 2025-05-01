fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val dp = IntArray(11)

    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for(i in 4..10){
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    }


    repeat(br.readLine().toInt()){
        write(dp[br.readLine().toInt()].toString())
        newLine()
    }
    close()
}