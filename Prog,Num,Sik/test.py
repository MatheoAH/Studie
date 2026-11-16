import numpy as np
w = lambda z: z**2*(4-z)
y = []
N = 4

start = 0
slutt = 3

h = (slutt-start)/N

for i in range(N+1):
    y.append(w(h*i))

print(0.45*8**(-1/4))

g = lambda V: 5-V-10**-6*(np.e**(V/0.05)-1)
gd = lambda V: -1/50000*np.e**(20*V)-1

V = 0.76477822375478

print(V-g(V)/gd(V))

vk = np.zeros(3