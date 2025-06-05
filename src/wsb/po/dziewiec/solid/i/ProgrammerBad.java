package wsb.po.dziewiec.solid.i;

// ŹLE: Klasa łamie ISP

// "Gruby" interfejs
interface IWorkerBad {
    void work();
    void eat();
    void sleep();
    void manageTeam(); // Nie każdy pracownik zarządza zespołem
}

class ProgrammerBad implements IWorkerBad {
    @Override
    public void work() { System.out.println("Programmer is coding."); }
    @Override
    public void eat() { System.out.println("Programmer is eating."); }
    @Override
    public void sleep() { System.out.println("Programmer is sleeping."); }

    @Override
    public void manageTeam() { // Programista może nie zarządzać zespołem
        // Musi zaimplementować, nawet jeśli to pusta implementacja lub rzuca wyjątek
        System.out.println("Programmer is not managing a team (unless they are a lead).");
        // throw new UnsupportedOperationException("Programmers don't always manage teams");
    }
}

class ManagerBad implements IWorkerBad {
    @Override
    public void work() { System.out.println("Manager is working on strategy."); }
    @Override
    public void eat() { System.out.println("Manager is eating."); }
    @Override
    public void sleep() { System.out.println("Manager is sleeping."); }
    @Override
    public void manageTeam() { System.out.println("Manager is managing the team."); }
}

class ISPDemoBad {
    public static void main(String[] args) {
        ProgrammerBad p = new ProgrammerBad();
        p.work();
        p.manageTeam(); // Wywołanie metody, która może nie być relevantna

        ManagerBad m = new ManagerBad();
        m.work();
        m.manageTeam();
    }
}
