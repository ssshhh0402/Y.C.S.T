class node:
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right


def solution(nodeInfo):
    answer = 0
    nodeInfo.sort(key=lambda x: (-x[1], x[0]))
    root = None
    for nodes in nodeInfo:
        if not root:
            root = node(nodes)
        else:
            chk = root
            while True:
                if nodes[0] < chk.data[0]:
                    if not chk.left:
                        chk.left = node(nodes)
                        break
                    else:
                        chk = chk.left
                        continue
                if chk.data[0] < nodes[0]:
                    if not chk.right:
                        chk.right = node(nodes)
                        break
                    else:
                        chk = chk.right
                        continue
                break



    return answer

print(solution([[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]))
