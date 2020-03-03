def find(a, b, c, d): #a: 선택문자열, b : 제한 c: 전체 문자열 d : 사용여부
        if len(a) == b:
            return int(a)
        for idx in range()



def solution(number, k):
    answer = ''
    lists = list(number)
    used = [0 for _ in range(len(lists))]
    for idx in range(len(lists)):
        used[idx] = 1
        a = find(lists[idx],len(lists)-k,lists, used)
        used[idx] = 0
    return answer

solution("1924", 2)