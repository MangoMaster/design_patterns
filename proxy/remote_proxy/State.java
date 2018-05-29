import java.io.Serializable;

public abstract class State implements Serializable {
    public void insertQuarter() {
        System.out.println("You can't insert a quarter");
    }

    public void ejectQuarter() {
        System.out.println("You can't eject a quarter");
    }

    public void turnCrank() {
        System.out.println("You can't turn crank");
    }

    public void dispense() {
        System.out.println("You can't dispense");
    }
}