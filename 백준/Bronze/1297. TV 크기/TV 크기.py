d, h, w = map(int, input().split())

di = (h*h + w*w)**(0.5)

ratio = d / di

height = int(h * ratio)
width = int(w * ratio)

print("%d %d" %(height, width))