fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val dp = Array(41){ Pair(0,0)}
    dp[0] = Pair(1,0)
    dp[1] = Pair(0,1)


    for(i in 2..40){
        dp[i] = Pair(dp[i-1].first + dp[i-2].first, dp[i-1].second + dp[i-2].second)
    }


    repeat(br.readLine().toInt()){
        val n = br.readLine().toInt()
        write(dp[n].first.toString() + " " + dp[n].second.toString())
        newLine()
    }
    close()
}