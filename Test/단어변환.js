console.log(solution("hit","cog",["hot", "dot", "dog", "lot", "log", "cog"]));
console.log(solution("hit","cog",["hot", "dot", "dog", "lot", "log"]));
function solution(begin, target, words){
    let answer = -1;
    let used = Array(words.length).fill(false);
    find(begin, target, 0);
    function isPossible(one, two){
        let flag = false;
        if(one.length != two.length){
            return false;
        }else{
            for(let i = 0; i < one.length; i++){
                if(one.charAt(i) !== two.charAt(i)){
                    if(!flag){
                        flag = true;
                    }else{
                        return false;
                    }
                }
            }
            return true;
        }
    }
    function find(begin, target, count){
        if(begin === target){
            if(answer == -1){
                answer = count;
            }else{
                answer = Math.min(answer, count);
            }
        }else{
            for(let i = 0; i < words.length; i++){
                if(isPossible(begin, words[i]) && !used[i]){
                    used[i] = true;
                    find(words[i], target, count+1);
                    used[i] = false;
                }
            }
        }
    }
    if(answer == -1){
        return 0;
    }else{
        return answer;
    }
}