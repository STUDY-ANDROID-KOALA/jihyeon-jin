fun main() {
    val sv = Solution()
    val answer = sv.solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"))
    println(answer)
}
class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = Int.MAX_VALUE
        val visited = Array(words.size){false}

        if(!words.contains(target))
            return 0

        fun dfs(begin: String, count: Int) {
            if(begin == target){
                answer = minOf(answer, count)
                return
            }
            for(i in begin.indices){
                for(j in 0 until words.size){
                    val t = begin.substring(0, i) + begin.substring(i + 1)
                    val w = words[j].substring(0, i) + words[j].substring(i + 1)

                    if(t == w && begin != words[j] && !visited[j]){
                        visited[j] = true
                        dfs(words[j], count + 1)
                        visited[j] = false
                    }
                }
            }
        }
        dfs(begin, 0)

        return if(answer == Int.MAX_VALUE) 0 else answer
    }
}