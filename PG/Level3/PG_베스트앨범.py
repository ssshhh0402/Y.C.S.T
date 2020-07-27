def solution(genres, plays):
    answer = []
    targets = []
    base = {}
    for idx in range(len(genres)):
        if genres[idx] in base:
            base[genres[idx]][0] += plays[idx]
            base[genres[idx]][1].append((idx, plays[idx]))
        else:
            base[genres[idx]] = [plays[idx], [(idx, plays[idx])]]
    while len(targets) != len(base.keys()):
        highest = 0
        target = ''
        for genre in base.keys():
            if genre not in targets and base[genre][0] > highest:
                target = genre
                highest = base[genre][0]
        targets.append(target)
    for target in targets:
        songs = sorted(base[target][1],key=lambda x:x[1],reverse=True)
        if len(songs) >= 2:
            n = 2
        else:
            n = len(songs)
        for song in range(n):
            answer.append(songs[song][0])
    return answer

print(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))