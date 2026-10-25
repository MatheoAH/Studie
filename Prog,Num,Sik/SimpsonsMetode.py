import numpy as np

f = lambda x: 2*np.cos(x**2)+x

def simpsons_metode(func, a, b, m):
    n = 2*m
    x_noder = np.linspace(a, b, n+1)
    h = (b-a)/n
    S1 = func(x_noder[0]) + func(x_noder[n])
    S2 = sum(func(x_noder[1:n:2]))
    S3 = sum(func(x_noder[2:n-1:2]))
    S = h*(S1 + 4*S2 + 2*S3)/3
    return abs(S)

print(simpsons_metode(f, 1, -1, 2))