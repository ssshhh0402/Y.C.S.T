def timeCalc(times):
    start_h, start_m = list(map(int, times[1].split(":")))
    end_h, end_m = list(map(int, times[0].split(":")))
    #timeInfo = times.split(":")
    answer = 0
    if int(end_h) == 0:
        end_h = 24
    answer += 60 * (end_h - start_h ) + end_m + start_m
    return answer



def chLyric(lyrics):
    lyrics = lyrics.replace("C#", "c")
    lyrics = lyrics.replace("D#", "d")
    lyrics = lyrics.replace("F#", "f")
    lyrics = lyrics.replace("G#", "g")
    lyrics = lyrics.replace("A#", "a")
    return lyrics

def solution(m, musicinfos):
    base =[]
    m = chLyric(m)
    for musicinfo in range(len(musicinfos)):
        lyrics = ''
        temps = musicinfos[musicinfo].split(",")
        lyric = chLyric(temps[3])
        time = timeCalc([temps[1],temps[0]])
        if time % len(lyric) == 0:
            n = time // len(lyric)
            lyrics += lyric * n
        else:
            n = time // len(lyric)
            M = time % len(lyric)
            lyrics += (lyric * n + lyric[:M])
        if m in lyrics:
            base.append([time, musicinfo, temps[2]])
    if not base:
        return "(None)"
    else:
        base = sorted(base, key=lambda x:(-x[0], x[1]))
        return base[0][2]


#print(solution("ABCDEFG",["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]))
#print(solution("ABC", ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]))
#print(solution("CCB", ["03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"]))
print(solution("ABC", ["23:00,00:00,FDS,CCCABC"]))