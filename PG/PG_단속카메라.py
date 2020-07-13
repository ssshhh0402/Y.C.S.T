def solution(routes):
    answer = 0
    routes = sorted(routes, key=lambda x: x[1])
    index = - 30000
    for route in routes:
        if route[0] > index:
            index = route[1]
            answer += 1
    return answer

print(solution([[-20,15], [-14,-5], [-18,-13], [-5,-3]]	))