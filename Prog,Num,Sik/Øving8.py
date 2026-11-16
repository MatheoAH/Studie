import numpy as np

def f(x):
    return 2*x-np.cos(x)      # venstreside minus høyreside i den opprinnelige ligningen

def ga(x):
    return np.cos(x)/2     # fikspunktfunksjonen i (a)

x0 = 0            # startgjetningen
xa = x0
n = 0
while abs(f(xa)) > 10**(-5):   # stopp når avviket er <= tol_a
    xa = ga(xa)
    n += 1

    print(xa, n)


