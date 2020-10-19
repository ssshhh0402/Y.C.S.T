from collections import deque
def solution(cacheSize, cities):
    answer = 0
    cache = deque([])
    if not cacheSize:
        return len(cities) * 5
    for city in cities:
        city = city.lower()
        if city not in cache:
            if len(cache) == cacheSize:
                answer += 5
                cache.popleft()
                cache.append(city)
            else:
                answer += 5
                cache.append(city)
        else:
            answer += 1
            cache.remove(city)
            cache.append(city)

    return answer

