console.log(solution(["B", "RRB"]));
console.log(solution(["R", "BBB", "RBRBR"]));
console.log(solution(["R", "RRR", "RBBBB", "BRRRBRR"]));
function solution(grid){
    var answer = 0;
    var nextD = new Map([
        ["NR", new Map([
            ["L", new Map([
                ["R", "D"],
                ["B", "L"]
            ])],
            ["R", new Map([
                ["R", "R"],
                ["B", "D"]
            ])],
            ["D", new Map([
                ["R", "L"],
                ["B", "R"]
            ])]
        ])],
        ["RV", new Map([
            ["L", new Map([
                ["R", "L"],
                ["B", "D"]
            ])],
            ["R",new Map([
                ["R", "D"],
                ["B", "R"]
            ])],
            ["D", new Map([
                ["R", "R"],
                ["B", "L" ]
            ])]
        ])]
    ])
    var dir = new Map([
        ["NR", new Map([            //정방향
            ["L", new Map([
                ["R", [1,1]],
                ["B", [0,1]]
            ])],
            ["R", new Map([
                ["R", [0,-1]],
                ["B", [1,1]]
            ])],
            ["D", new Map([
                ["R", [0,1]],
                ["B", [0, -1]]
            ])]
        ])],
        ["RV", new Map([                    //거꾸로
            ["R", new Map([
                ["R", [-1,-1]],
                ["B", [0,-1]]
            ])],
            ["L", new Map([
                ["R",[0,1]],
                ["B", [-1,-1]]
            ])],
            ["D", new Map([
                ["R", [0,-1]],
                ["B", [0,1]]
            ])]
        ])]
    ]);
    for(let i = 0; i < grid.length; i++){
        find(i,0, "L", 0);
        find(i,grid[i].length-1, "R", 0);
        if(i == (grid.length - 1)){
            for(let j = 1; j < parseInt(grid[i].length / 2); j++){
                find(i, j*2, "D", 0);
            }
        }
    }
    function find(a, b, d, count){                            // x, y, dir
        if(a < 0 || a >= grid.length || b < 0 ||b >= grid[a].length){
            answer = Math.max(answer, count);
            return;
        }
        let color = grid[a].charAt(b);
        let now_d = "";
        if(b % 2 == 0){
            now_d = "NR";
        }else{
            now_d = "RV";
        }
        var dirs = dir.get(now_d).get(d).get(color);
        var nextDir = nextD.get(now_d).get(d).get(color);
        find(a + dirs[0], b + dirs[1], nextDir, count+1);
    }
    return answer;
}