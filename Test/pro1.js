solution(1,["1 fracta", "1 sina","1 hana","1 robel","1 abc", "1 sina", "1 lynn"])
function solution(n, record){
    var answer = [];
    const base = Array.from(Array(n+1), () => [])
    for(const character of record){
        const now = character.split(" ")
        const server = parseInt(now[0])
        const nick = now[1]
        if(base[server].indexOf(nick) === -1){
            if(base[server].length < 5){
                base[server].push(nick)
            }else{
                base[server].shift()
                base[server].push(nick)
            }
        }
    }
    for(const x of base){
        for(const y of x){
            console.log(y)
            answer.push(y)
        }
    }
    
    return answer
}