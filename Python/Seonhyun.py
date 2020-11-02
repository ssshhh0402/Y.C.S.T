import pandas as pd
df1= pd.read_csv("./AC.csv", encoding='utf-8')
df2 = df1.groupby(['origsentnum'], as_index=False)
for item in df2:
    print(item)
    item.
