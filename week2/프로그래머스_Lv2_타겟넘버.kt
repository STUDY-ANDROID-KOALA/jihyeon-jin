class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0

        fun dfs(start: Int, result: Int){
            if(start == numbers.size - 1 && result == target){
                answer++
                return
            }
            else if(start == numbers.size - 1){
                return
            }
            val nStart = start + 1
            if(nStart < numbers.size){
                val next = numbers[nStart]
                dfs(nStart, result + next)
                dfs(nStart, result - next)
            }
        }
        dfs(0, numbers[0])
        dfs(0, -numbers[0])
        return answer
    }
}