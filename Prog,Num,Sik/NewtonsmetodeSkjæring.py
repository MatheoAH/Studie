import numpy as np

def f1(x):
    return np.e**x

def f2(x):
    return x-3

def F(x):
    return f1(x)+f2(x)

def Fd(x):
    return np.e**x+1

xn =0
for i in range(1, 20):
    xn = xn-F(xn)/Fd(xn)
    print(f"x{i}: {xn}")