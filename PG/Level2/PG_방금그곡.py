def timeCalc(times):
    timeInfo = times.split(":")
    return int(timeInfo[0] + timeInfo[1])

def chLyric(lyrics):
    # 가사 바꿔서 하는걸로 다시 한번 고민!
def solution(m, musicinfos):
    answer = 0
    lyrics = ''
    base= []
    for musicinfo in musicinfos:
        temps = musicinfo.split(",")
        count = timeCalc(temps[1]) - timeCalc(temps[0])
        if count % len(temps[3]) == 0:
            n = count // len(temps[3])
        else:
            n = count // len(temps[3]) + 1
        lyrics += temps[3] * n
        for _ in range(count):
            base.append(temps[2])
    N = len(m)
    start = m[0]

    for lyric in range(len(lyrics)):
        if lyrics[lyric] == start:
            if lyrics[lyric:lyric+N] == m:
                if m[-1] == '#':
                    if lyrics[lyric+N] == '#':
                        answer = lyric
                else:
                    answer = lyric
    if not answer:
        return "(None)"
    else:
        return base[answer-1]

print(solution("ABCDsEFG",["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]))


