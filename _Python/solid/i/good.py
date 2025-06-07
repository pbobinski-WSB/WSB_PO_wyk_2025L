# DOBRZE: Stosowanie ISP
from abc import ABC, abstractmethod

# Małe, specyficzne interfejsy (role)
class Workable(ABC):
    @abstractmethod
    def work(self):
        pass

class Eatable(ABC):
    @abstractmethod
    def eat(self):
        pass
    
class Sleepable(ABC): # Można by dodać
    @abstractmethod
    def sleep(self):
        pass

class TeamManager(ABC):
    @abstractmethod
    def manage_team(self):
        pass

# Klasy implementują tylko te interfejsy, które są dla nich relevantne
class Programmer(Workable, Eatable, Sleepable): # Programista pracuje i je
    def work(self):
        print("Programmer is coding.")
    def eat(self):
        print("Programmer is eating.")
    def sleep(self):
        print("Programmer is sleeping.")
        
class Manager(Workable, Eatable, Sleepable, TeamManager): # Manager pracuje, je i zarządza
    def work(self):
        print("Manager is working on strategy.")
    def eat(self):
        print("Manager is eating.")
    def sleep(self):
        print("Manager is sleeping.")
    def manage_team(self):
        print("Manager is managing the team.")

class RobotWorker(Workable): # Robot tylko pracuje
    def work(self):
        print("Robot is assembling parts.")

# Użycie:
programmer = Programmer()
programmer.work()
programmer.eat()

manager = Manager()
manager.work()
manager.manage_team()

robot = RobotWorker()
robot.work()
# robot.eat() # AttributeError: 'RobotWorker' object has no attribute 'eat' - co jest poprawne!