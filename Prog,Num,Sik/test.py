import numpy as np

# last inn dataen
datoer = np.genfromtxt("dato.csv",delimiter=",",dtype="U20")
x = np.loadtxt("KPI.csv",delimiter=",")

# vi lager en dictionary, vår nøklene er år/måned og verdiene er KPI
KPI = dict(zip(datoer,x))


# nå vil KPI["år måned"] gi KPI for den oppgitte datoen, f eks 
# print(KPI["1932 Jan"])

# enkelte måneder har ikke fått KPI ennå
# print(KPI["2025 Des"])

# eksempel: vi beregner forlengs differanser
y = np.diff(x)
# svaret legges i en dictionary. 
Prisvekst_f = dict(zip(datoer, np.hstack((y,np.nan))))

# Her prisvekst med baklengs differanser

Prisvekst_b = dict() # fullfør svaret

# Her prisvekst med sentrale differanser
Prisvekst_s = dict() # fullfør svaret

# Her den andre deriverte
Prisvekstvekst = dict() # fullfør svaret

# Trend i prisvekst (synkende/økende/stabil)
Trend = dict() # fullfør svaret
        