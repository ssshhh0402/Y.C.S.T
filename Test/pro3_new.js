solution([5, 9, 13, 1, 0, 0, 11, 1, 7, 12, 9, 9, 2])
// 11 => 9 => 7(0)
// 7 => 11 => 9 => 7 
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
            count += (dp[next])
            break
        }else{
            count += 1
            used[next] = true
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
        const temps = find(i, base, dp)
        dp[i] = temps
        if(comp === temps){
            answer = i
        }else if(comp < temps){
            answer = i
            comp = temps
        }
    }
    // [
    //     0, 2, 4, 6, 3, 1,
    //     1, 3, 3, 3, 5, 3,
    //     4, 5
    //   ]
    console.log(dp)
    console.log(answer)
}
