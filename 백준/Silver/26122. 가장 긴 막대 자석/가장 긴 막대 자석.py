def find_longest_magnetic_substring(n, s):
    max_length = 0
    segments = [] 
    current_char = s[0]  
    current_length = 0  

    for char in s:
        if char == current_char:
            current_length += 1
        else:
            segments.append(current_length)
            current_char = char
            current_length = 1
    segments.append(current_length)

    for i in range(1, len(segments)):
        max_length = max(max_length, 2 * min(segments[i-1], segments[i]))

    return max_length

N = int(input())
S = input()

print(find_longest_magnetic_substring(N, S))
