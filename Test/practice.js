practice();
function practice(){
    console.log("------ MAX 값 테스트 ------");
    const a = Number.MAX_SAFE_INTEGER;
    console.log(a);
    const b = a+1;
    console.log(b);
    console.log(a+a);
    console.log("------ split 테스트 ------");
    const c = "HELLO,JEONMIN";
    for(let a of c.split(",")){
        console.log(a);
    }
    console.log("------ isNan 테스트 ------");
    console.log(isNaN("9"));
    console.log(isNaN(9));
    console.log(isNaN("HELOO"));
    console.log("------- Map 테스트 ------");
    const map = new Map();
    map.set("Id", 0);
    map.set("Name", "Soonbum");
    console.log(map.has("Id"));
    console.log(map.get("Name"));
    map.set("Name", "Jungwoo");
    console.log(map.get("Name"));
    map.set(29, "age");

    for(let key of map.keys()){
        console.log(key + " : " + map.get(key));
    }
    console.log(parseInt(7 / 2));
};