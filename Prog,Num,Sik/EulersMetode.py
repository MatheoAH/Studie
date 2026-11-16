def eksplisitt_steg(f, tn, xn, h):
    # Først beregnes det neste tidspunktet.
    t_neste = tn + h

    # Fullfør Euler-oppdateringen. Bruk f, tn, xn og h.
    x_neste = xn + h * f(tn, xn)

    return t_neste, x_neste


def implisitt_steg(f, tn, xn, h):
    # Denne ferdig løste oppdateringen gjelder for f(t, x) = t - x.
    t_neste = tn + h

    # Fullfør uttrykket for den nye verdien.
    x_neste = (xn + h * t_neste) / (1 + h)

    return t_neste, x_neste


def euler_losning(stegfunksjon, f, t0, x0, h, antall_steg):
    # Startverdier.
    t = t0
    x = x0

    # Gjenta den valgte stegfunksjonen.
    for _ in range(antall_steg):
        t, x = stegfunksjon(f, t, x, h)

    return t, x

print(euler_losning(eksplisitt_steg, lambda t, x: t - x, 0, 1, 0.5, 3))