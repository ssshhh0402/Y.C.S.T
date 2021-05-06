console.log(solution(3, [[1,1,0],[1,1,0],[0,0,1]]));
console.log(solution(3, [[1,1,0],[1,1,1],[0,1,1]]));
function solution(n,computers){
    var answer = 0;
    var used = Array(n).fill(false);
    var a = 'a';
    console.log(a.toUpperCase());
    console.log(a.toLowerCase());
    for(let x = 0; x < n; x++){
        if(!used[x]){
            answer += 1;
            
            used[x] = true;
            for(let y = 0; y < n; y++){
                if(x != y && !used[y] && computers[x][y] == 1){
                    let q = new Array();
                    q.push(y);
                    while(q.length != 0){
                        let now = q.shift();
                        used[now] = true;
                        for(let toGo = 0; toGo < n; toGo++){
                            if(!used[toGo] && computers[now][toGo] == 1){
                                q.push(toGo);
                            }
                        }
                    }
                }
            }
        }
    }
    return answer;
}