import numpy as np

f = lambda x: 2*np.cos(x**2)+x

def simpson(f, a, b, N):
    h = (b - a) / N
    s = f(a) + f(b)

    for i in range(1, N):
        if i % 2 == 1:
            vekt = 4
        else:
            vekt = 2

        s += vekt * f(a + i * h)

    return h * s / 3

print(simpson(f, 1, -1, 2))
