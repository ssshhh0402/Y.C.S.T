
def solution(record):
    answer = []
    names = {}
    for rec in record:
        now = rec.split(" ")
        if now[0] == "Enter" or now[0] == "Change":
           names[now[1]] = now[2]
    for rec in record:
        now = rec.split(" ")
        if now[0] == "Enter":
            answer.append(names[now[1]] + "님이 입장하셨습니다.")
        elif now[0] == "Leave":
            answer.append(names[now[1]] + "님이 퇴장하셨습니다")
    return answer


answers = solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]);
for answer in answers:
    print(answer)
