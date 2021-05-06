
solution([1,1,1,1,1], 3);
function solution(numbers, target){
    let answer = 0;
    find(0, 0);
    function find(score, idx){
        if(idx == numbers.length){
            if(score == target){
                answer += 1;
            }
            
        }else{
            find(score + numbers[idx], idx+1);
            find(score - numbers[idx], idx+1);
        }
    }
    console.log(answer);
}