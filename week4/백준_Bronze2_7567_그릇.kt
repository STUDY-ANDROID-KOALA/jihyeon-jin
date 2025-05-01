fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val st = br.readLine()
    val arr = st.toList()
    var sum = 10

    for(i in 1 until arr.size){
        sum += when(arr[i]){
            arr[i-1] -> 5
            else -> 10
        }
    }
    write(sum.toString())
    close()
}