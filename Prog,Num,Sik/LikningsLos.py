import fractions

print("Iterasjon A")
x = 16/5

def f(x):
    return (12)/(x+1)

def g(x):
    return 12-x**2

fx= x
gx= x


for i in range(1, 5):
    fx = f(fx)
    gx = g(gx)
    print(i, "A: ", fx, "B: ", gx)