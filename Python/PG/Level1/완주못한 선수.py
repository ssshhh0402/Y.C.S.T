def solution(participant, completion):
    answer = ''
    # lists = {}
    # for name in participant:
    #     if name not in lists.keys():
    #         lists[name] = 1
    #     else:
    #         lists[name] += 1
    # for person in lists:
    #     if lists[person] > completion.count(person):
    #         answer = person
    #         break
    # for name in participant:
    #     if participant.count(name) > completion.count(name):
    #         answer = name
    #         break
    participant = sorted(participant)
    completion = sorted(completion)
    for idx in range(len(participant)):
        if participant[idx] != completion[idx]:
            answer = participant[idx]
            break

    return answer
