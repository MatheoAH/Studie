import numpy as np

x = 7
h = 1/5

f = lambda x: np.log(x+1)

def genereldiff(func, x, h):
    diff_for = (func(x+h)-func(x))/h
    diff_bak = (func(x)-func(x-h))/h
    diff_senter = (func(x+h)-func(x-h))/2*h

    return diff_for, diff_bak, diff_senter

print(genereldiff(f, x, h))