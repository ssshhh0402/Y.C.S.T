console.log(solution(6,[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]));

function solution(n, edge){
    let answer = 0;
    let dist = Array(n+1).fill(Infinity);
    let base = Array.from(Array(n+1), () => []);
    for(let [start, end] of edge){
        base[start].push(end);
        base[end].push(start);
    }
    dist[1] = 0;
    let q = [];
    q.push(1);
    while(q.length != 0){
        let now = q.shift();
        for(let toGo of base[now]){
            if(dist[toGo] > dist[now] + 1){
                dist[toGo] = dist[now] + 1;
                q.push(toGo);
            }
        }
    }
    let count = 0;
    for(let i = 1; i < n+1; i++){
        if(dist[i] != Infinity){
            if(dist[i] > count){
                answer = 1;
                count = dist[i];
            }else if(dist[i] == count){
                answer += 1;
            }
        }
    }

    return answer;
}