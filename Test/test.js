
const N = 5
solution(N)

function solution(N) {
    const items = ["OOXXOXXOOO",
        "OOXXOOXXOO",
        "OXOXOXOXOXOXOX",
        "OOOOOOOOOO",
        "OOOOXOOOOXOOOOX"]
    const itemsed = Array.from(Array(5), () => [])
    itemsed[0].push(10)
    itemsed[3].push(5)
    console.log(itemsed)
    const item = parseInt("9");
    console.log(item)
    const itemsx = Math.min(10,Infinity)
    console.log("itemsx :" + itemsx)
    for (let i = 0; i < N; i++) {
        const answer = items[i]
        let totalPoint = 0
        let count = 0

        for (const a of answer) {
            if (a === 'O') {
                count++
                totalPoint += count
            } else {
                count = 0
            }
        }
        console.log(totalPoint)
  }
const a = 'a';
console.log(a.toUpperCase());
console.log(a.toLowerCase());
}