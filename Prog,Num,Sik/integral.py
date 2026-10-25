import numpy as np
from fractions import Fraction


f = lambda x: 5 + x**2

def integral_trapes(func, a, b, n):
    h = (b - a) / n
    tot_sum = (func(a) + func(b)) / 2
    for i in range(1, n):               
        x = a + h * i
        tot_sum += func(x)
    return tot_sum * h


def til_brok(x):
    return Fraction(x)

print(til_brok(integral_trapes(f, 0, 3, 4)))

np.diff()