solution([5, 9, 13, 1, 0, 0, 11, 1, 7, 12, 9, 9, 2])
function find(i, base, dp){
    var used = new Array(base.length + 1).fill(Boolean)
    var count = 1
    var next = i
    used[next] = true
    while(true){
        next = base[next]
        if(next === 0 || used[next] === true){
            break
        }else if(dp[next] !== 0){
            count += (dp[next] - 1)
            break
        }else{
            used[next] = true
            count += 1
        }
    }
    return count
}
function solution(next_student){
    var answer = 0
    var comp = 0
    var n = next_student.length
    var dp = new Array(n+1).fill(0)
    var base = new Array(n+1).fill(0)
    for(var i = 0; i < n; i++){
        base[i+1]= next_student[i]
    }
    for(var i = 1; i < n+1; i++){
        const item = find(i, base, dp)
        dp[i] = item
        if(comp === item){
            answer = i
        }else if(comp < item){
            answer = i
            comp = item
        }
    }
    console.log(answer)
}
