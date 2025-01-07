N = int(input())

def solve(str:str, start:int, end:int, cnt:int):
    if cnt > 2:
        return 2
    while(start < end):
        if str[start] == str[end]:
            start += 1
            end -= 1
        else:
            return min(solve(str, start+1, end, cnt+1), solve(str, start, end-1, cnt+1))
        
    return cnt

arr = []

for _ in range(N):
    str = input()
    print(solve(str, 0, len(str)-1, 0))