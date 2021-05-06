console.log(solution([6, 10, 2]));
console.log(solution([3, 30, 34, 5, 9]));
function solution(numbers){
    let answer = '';
    numbers.sort((a, b) => {
        let ca = String(a);
        let cb = String(b);
        if(ca + cb> cb + ca){
            return -1;
        }else if(ca + cb< cb + ca){
            return 1;
        }else{
            return 0;
        }
    })
    for(let number of numbers){
        answer += number;
    }
    if(answer.charAt(0) != '0'){
        return answer;
    }else{
        return '0';
    }
}