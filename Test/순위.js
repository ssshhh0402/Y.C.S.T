solution(5,[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]);
function solution(n, results){
    let answer = 0;
    let dp = Array.from(Array(n+1), () => Array(n+1).fill(Infinity));
    for(let [winner, loser] of results){
        dp[winner][loser] = 1;
    }
    for(let z = 1; z < n+1; z++){
        for(let x = 1; x < n+1; x++){
            for(let y = 1; y < n+1; y++){
                if(dp[x][y] > dp[x][z] + dp[z][y]){
                    dp[x][y] = dp[x][z] + dp[z][y];
                }
            }
        }
    }
    for(let x = 1; x < n+1; x++){
        let flag = false;
        for(let y = 1; y < n+1; y++){
            if(x === y){
                continue;
            }else{
                if(dp[x][y] == Infinity && dp[y][x] == Infinity){
                    flag = true;
                    break;
                }
            }
        }
        if(!flag){
            answer += 1;
        }
    }
    console.log(dp);
    console.log(answer);
    const a = Number.MAX_SAFE_INTEGER;
    console.log(a);
    const b = a+1;
    console.log(b);
    console.log(a+a);
}