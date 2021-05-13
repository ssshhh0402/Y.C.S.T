console.log(solution([12,6,6,12,6,24,30,32,34,36,24,18,6,6,18,30,6]));
console.log(solution([4,3,2,1,2,3,4,3,2,1]));
console.log(solution([1000,2000,3000,2000,3000,4000,3000]));
function solution(prices){
    var answer = [];
    for(let i = 1 ; i < prices.length-1; i++){
        if(prices[i-1] < prices[i] && prices[i+1] < prices[i]){
            let value = find_max(i);
            answer.push(value);
        }else if(prices[i-1] > prices[i] && prices[i+1] > prices[i]){
            let value = find_min(i);
            answer.push(-value);
        }
    }
    return answer;
    function find_max(i){
        var count = 0;
        for(let j = 1 ; j < prices.length; j++){
            if(i - j < 0 || i + j >= prices.length){
                break;
            }
            if(prices[i-j] < prices[i-j+1] && prices[i+j] < prices[i+j - 1]){
                count = j;
            }else{
                break;
            }
        }
        return count;
    }
    function find_min(i){
        var count = 0;
        for(let j = 1; j < prices.length; j++){
            if(i - j < 0 || i + j >= prices.length){
                break;
            }
            if(prices[i-j] > prices[i-j+1] && prices[i+j] > prices[i + j - 1]){
                count = j;
            }else{
                break;
            }
        }
        return count;
    }
}