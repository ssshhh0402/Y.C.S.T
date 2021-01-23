solution([5, 9, 13, 1, 0, 0, 11, 1, 7, 12, 9, 9, 2])
function solution(next_student){
    var answer = 0
    var comp = 0
    const n = next_student.length
    var base = new Array(n+1).fill(0)
    var used = new Array(n+1).fill(false)
    for(var i = 0; i < n; i++){
        base[i+1]= next_student[i]
    }
    for(var i = 1 ; i < n+1; i++){
        var count = 1
        var next = i
        used[next] = true
        while(true){
            next = base[next]
            if(next === 0 || used[next] === true){
                break
            }else{
                used[next] = true
                count += 1
            }
        }
        if(count === comp){
            answer = i
        }else if(count > comp){
            comp = count
            answer = i
        }
        used.fill(false)
    }
    return answer
}
