// console.log(solution([50,82,75,120],["NLWL","WNLL","LWNW","WWLN"]));
// console.log(solution([145,92,86],["NLW","WNL","LWN"]));
console.log(solution([60,70,60],["NNN","NNN","NNN"]	));
function solution(weights, head2head){
    var answer = [];
    var base = [];
    for(let i = 0; i < weights.length; i++){  //[승률, 더 나가는사람, 자기 몸무게, 번호]
        var value = find(i,weights[i]);
        base.push(value);
    }
    base.sort((a, b) => {
        if(a[0] !== b[0]){
            return b[0] - a[0];
        }else{
            if(a[1] !== b[1]){
                return b[1] - a[1];
            }else{
                if(a[2] !== b[2]){
                    return b[2] - a[2];
                }else{
                    return a[3] - b[3];
                }
            }
        }
    })
    for(let result of base){
        answer.push(result[3]);
    }
    return answer;
    function find(i, weight){
        let target = head2head[i];
        let count = 0;
        let win = 0;
        let rate = 0;
        let win_h = 0;
        for(let j = 0; j < target.length; j++){
            var now = target.charAt(j);
            if(now !== 'N'){
                count += 1;
                if(now === 'W'){
                    win += 1;
                    if(weights[j] > weight){
                        win_h += 1;
                    }
                }
            }
        }
        if(count === 0){
            rate = 0;
        }else{
            rate = win / count;
        }
        return [rate, win_h, weight, i+1];
    }
}