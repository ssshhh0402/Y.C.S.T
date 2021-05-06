console.log(solution([1, 5, 2, 6, 3, 7, 4],[[2, 5, 3], [4, 4, 1], [1, 7, 3]]));
function solution(array, commands){
    let answer = [];
    for(const [start, end, idx] of commands){
        let target = array.slice(start-1, end).sort((a, b) => a - b);
        answer.push(target[idx-1]);
    }
    return answer;
}