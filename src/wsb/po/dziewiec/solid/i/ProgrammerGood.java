package wsb.po.dziewiec.solid.i;

// DOBRZE: Stosowanie ISP

// Małe, specyficzne interfejsy (role)
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

interface TeamManager {
    void manageTeam();
}

// Klasy implementują tylko te interfejsy, które są dla nich relevantne
class ProgrammerGood implements Workable, Eatable, Sleepable {
    @Override
    public void work() { System.out.println("Programmer is coding."); }
    @Override
    public void eat() { System.out.println("Programmer is eating."); }
    @Override
    public void sleep() { System.out.println("Programmer is sleeping."); }
}

class ManagerGood implements Workable, Eatable, Sleepable, TeamManager {
    @Override
    public void work() { System.out.println("Manager is working on strategy."); }
    @Override
    public void eat() { System.out.println("Manager is eating."); }
    @Override
    public void sleep() { System.out.println("Manager is sleeping."); }
    @Override
    public void manageTeam() { System.out.println("Manager is managing the team."); }
}

class RobotWorker implements Workable { // Robot tylko pracuje
    @Override
    public void work() { System.out.println("Robot is assembling parts."); }
}

class ISPDemoGood {
    public static void main(String[] args) {
        ProgrammerGood programmer = new ProgrammerGood();
        programmer.work();
        programmer.eat();

        ManagerGood manager = new ManagerGood();
        manager.work();
        manager.manageTeam();

        RobotWorker robot = new RobotWorker();
        robot.work();
        // robot.eat(); // Błąd kompilacji: RobotWorker nie implementuje Eatable - co jest poprawne!
    }
}
