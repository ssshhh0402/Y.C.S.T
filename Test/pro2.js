solution(4,[2,3,1])
solution(4,[3,2,3,1])
function solution(m,v){
    var base =new Array()
    for(const item of v){
        if(base.length === 0){
            base.push(m-item)
        }else{
            var target = -1
            for(var i = base.length-1; i >=0; i--){
                if(base[i] >= item){
                    target = i
                }else{
                    break;
                }
            }
            if(target === -1){
                base.push(m - item)
            }else{
                base[target] = base[target] - item
            }
        }            
    }
    console.log(base.length)
    return base.length
}