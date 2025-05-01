fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[0] = 0

    for (i in 1..n) {
        if (i >= 3 && dp[i - 3] != Int.MAX_VALUE) {
            dp[i] = minOf(dp[i], dp[i - 3] + 1)
        }
        if (i >= 5 && dp[i - 5] != Int.MAX_VALUE) {
            dp[i] = minOf(dp[i], dp[i - 5] + 1)
        }
    }

    write(if (dp[n] != Int.MAX_VALUE) dp[n].toString() else "-1")
    close()
}