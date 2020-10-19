words = input()
base= []
for word in words:
    if word.isdigit():
        base.append(int(word))
base.sort()
print('+'.join(list(map(str, base))))