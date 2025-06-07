# ŹLE: Klasa łamie ISP
from abc import ABC, abstractmethod

class Worker(ABC): # "Gruby" interfejs
    @abstractmethod
    def work(self):
        pass
    @abstractmethod
    def eat(self):
        pass
    @abstractmethod
    def sleep(self):
        pass
    @abstractmethod
    def manage_team(self): # Nie każdy pracownik zarządza zespołem
        pass

class Programmer(Worker):
    def work(self):
        print("Programmer is coding.")
    def eat(self):
        print("Programmer is eating.")
    def sleep(self):
        print("Programmer is sleeping.")
    def manage_team(self): # Programista może nie zarządzać zespołem
        # raise NotImplementedError("Programmers don't always manage teams")
        print("Programmer is not managing a team (unless they are a lead).")

class Manager(Worker):
    def work(self):
        print("Manager is working on strategy.")
    def eat(self):
        print("Manager is eating.")
    def sleep(self):
        print("Manager is sleeping.")
    def manage_team(self):
        print("Manager is managing the team.")

# Użycie:
p = Programmer()
p.work()
p.manage_team() # Wywołanie metody, która może nie być relevantna