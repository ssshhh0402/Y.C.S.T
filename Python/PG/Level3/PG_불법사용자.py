def diff(id, wish):                 #문자열 두개 동일한지 확인하는 함
    count = True
    if wish.count("*") == len(wish):
        return count
    else:
        for idx in range(len(id)):
            if id[idx] != wish[idx] and wish[idx] != '*':
                count = False
                break
    return count

def find(a, b, c, d):       #a: user_id 리스트 b: banne 리스트 c: 사용한 사람들 d: ban한 사람들
    global answer
    if len(b) == len(d):
        temps = sorted(c[:])
        if temps not in answer:
            answer.append(temps)
        return

    ban = len(d)
    for person in range(len(a)):
        if a[person] not in c:
            target = b[ban]
            if len(a[person]) == len(target) and diff(a[person], target):
                c.append(a[person])
                d.append(target)
                find(a, b, c,d)
                c.pop()
                d.pop()



def solution(user_id, banned_id):
    global answer
    answer = []
    find(user_id, banned_id,[],[])
    return len(answer)
#print(solution(["frodo", "fradi", "crodo", "abc123", "frodoc"],["fr*d*", "abc1**"]))
#print(solution(["frodo", "fradi", "crodo", "abc123", "frodoc"], ["*rodo", "*rodo", "******"]))
print(solution(["frodo", "fradi", "crodo", "abc123", "frodoc"], ["fr*d*", "*rodo", "******", "******"]))