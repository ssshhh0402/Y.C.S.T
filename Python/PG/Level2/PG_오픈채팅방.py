def solution(record):
    answer = []
    user = {}
    for rec in record:
        temp = rec.split(" ")
        if temp[0] == "Enter" or temp[0] == "Change":
            user[temp[1]] = temp[2]
    for rec in record:
        temp = rec.split(" ")
        if temp[0] == "Enter":
            answer.append(user[temp[1]] + "님이 들어왔습니다.")
        elif temp[0] == "Leave":
            answer.append(user[temp[1]] + "님이 나갔습니다.")

    return answer

print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]))