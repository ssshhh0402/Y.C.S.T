import requests

def getCountries(s, p):
    target = "https://jsonmock.hackerrank.com/api/countries/search?name=" + s
    answer = 0
    response = requests.get(url=target)
    data = response.json()
    print(data)
    n = data['total_pages']
    for i in range(1, n+1):
        newOne = target + "&page="+str(i)
        response = requests.get(url=newOne)
        data = response.json()
        for item in data['data']:
            if item['name'].find(s) != -1 and item['population'] >= p:
                answer += 1

    return answer

print(getCountries("in",1000000))