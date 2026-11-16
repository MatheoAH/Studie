import fractions

print("Iterasjon A")
x = 0.2

def f(x):
    return x-0.4*x*(x**2-1)

def g(x):
    return x+0.4*x*(x**2-1)

fx= x
gx= x


for i in range(1, 4):
    fx = f(fx)
    gx = g(gx)
    print(i, "A: ", fx, "B: ", gx)