def solution(s):
    import re
    answer = []
    base = s.split(',{')
    base.sort(key=len)
    for item in base:
        numbers = re.findall("\d+", item)
        for number in numbers:
            if int(number) not in answer:
                answer.append(int(number))
    return answer
#
# print(solution("{{2},{2,1,3},{2,1},{2,1,3,4}}"))
# print(solution("{{1,2,3},{2,1},{1,2,4,3,},{2}}"))
print(solution("{{20,111},{111}}"))