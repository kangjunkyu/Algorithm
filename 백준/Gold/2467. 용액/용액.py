N = int(input())
fluid = list(map(int, input().split()))

left, right = 0, N - 1

min = 100000000001

li =0
ri = 0

while left < right:
    sum = (fluid[left] + fluid[right])

    if(abs(sum) < min):
        min = abs(sum)
        li = left
        ri = right
    
    if sum < 0:
        left += 1
    else:
        right -= 1

print(fluid[li], fluid[ri])