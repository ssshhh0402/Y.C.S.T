import pandas as pd
df1= pd.read_csv("./AC2.csv", encoding='utf-8')
keys = df1.keys()
n = keys.size
df2 = dict(list(df1.groupby(['origsentnum'])))
for item in df2:
    target = df2[item]
    scores = {}
    for idx in range(28, n-1):
        temps = list(target[keys[idx]])
        name = target[keys[idx]].name
        for score in temps:
            if score != ' ':
                if name not in scores.keys():
                    scores[name] = {'score' : float(score), 'people' : 1}
                else:
                    scores[name]['score'] += float(score)
                    scores[name]['people'] += 1
    print(item + '번째')
    for answer in scores.keys():
        print(answer + '의 점수 : ' + str(scores[answer]['score'] / scores[answer]['people']))
