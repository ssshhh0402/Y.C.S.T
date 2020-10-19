# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
N,M = map(int,input().split(' '))
buses = []
for idx in range(1, N+1):

    start, turm = map(int,input().split(' '))
    if start == M:
        if buses[0][1] == M:
            buses.append((idx, start))
        else:
            buses.clear()
            buses.append((idx, start))
    else:
        while True:
            start = start + turm
            if start == M:
                if buses[0][0] == M:
                    buses.append((idx, start))
                else:
                    buses.clear()
                    buses.append((idx,start))
                    break
            elif start > M:
                if not buses:
                    buses.append((idx, start))
                    break
                else:
                    if start < buses[0][1]:
                        buses.clear()
                        buses.append((idx,start))
                        break
                    elif start == buses[0][1]:
                        buses.append((idx, start))
                        break
                    else:
                        break
buses.sort(key= lambda x:x[0])
print(buses[0][0])
