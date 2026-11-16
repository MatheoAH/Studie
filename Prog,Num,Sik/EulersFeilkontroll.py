import math

T0 = 0.0
X0 = 0.0
T_SLUTT = 2.0


def f(t, x):
    return t - x


def eksakt(t):
    return t - 1 + math.exp(-t)


def eksplisitt_euler(f, t0, x0, t_slutt, N):
    h = (t_slutt - t0) / N
    t = t0
    x = x0

    for _ in range(N):
        x = x + h * f(t, x)
        t = t + h

    return x


def undersok_feil(toleranse, maks_N):
    N = 0
    E = float("inf")

    h_verdier = []
    feil = []

    while E > toleranse and N < maks_N:
        N += 1

        h = (T_SLUTT - T0) / N
        x_num = eksplisitt_euler(f, T0, X0, T_SLUTT, N)
        E = abs(eksakt(T_SLUTT) - x_num)

        h_verdier.append(h)
        feil.append(E)

    oppnadd = True if E <= toleranse else False
    return N, h_verdier, feil, oppnadd

print(undersok_feil(0.01, 1000))

# Når funksjonen virker, kan du kjøre dette lokalt:
# N, h_verdier, feil, oppnadd = undersok_feil(0.01, 1000)
#
# import matplotlib.pyplot as plt
# plt.loglog(h_verdier, feil, "o-")
# plt.xlabel("Skrittlengde h")
# plt.ylabel("Absolutt avvik ved t = 2")
# plt.grid(True)
# plt.show()
