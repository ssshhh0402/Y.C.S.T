inputs = list(input())
used_a = []
used_b =[]
for chr in range(len(inputs)-1):
    if inputs[chr] + inputs[chr+1] == '12':
        used_a.append(chr)
        used_a.append(chr+1)
    elif inputs[chr] + inputs[chr+1] == '21':
        used_b.append(chr)
        used_b.append(chr+1)
pos = True
for items in used_a:
    if items not in used_b:
        pos = True
        break
if pos:
    print("Yes")
else:
    print("No")