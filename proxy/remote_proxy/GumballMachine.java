import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state = soldOutState;
    String location;
    int count = 0;

    public GumballMachine(String location, int numberGumballs) throws RemoteException {
        super();
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        this.location = location;
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void refill(int count) {
        this.count += count;
        if (this.count > 0) {
            state = noQuarterState;
        }
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0)
            --count;
    }

    void setState(State state) {
        this.state = state;
    }

    State getSoldOutState() {
        return soldOutState;
    }

    State getNoQuarterState() {
        return noQuarterState;
    }

    State getHasQuarterState() {
        return hasQuarterState;
    }

    State getSoldState() {
        return soldState;
    }

    public String getLocation() {
        return location;
    }

    public int getCount() {
        return count;
    }

    public State getState() {
        return state;
    }

    public String toString() {
        String str = "";
        str += "\nMighty Gumball, Inc.";
        str += "\nJava-enabled Stadning Gumball Model #2004";
        str += "\nInventory: " + count + " gumballs";
        if (state == soldOutState) {
            str += "\nMachine is sold out";
        } else if (state == noQuarterState) {
            str += "\nMachine is waiting for quarter";
        } else if (state == hasQuarterState) {
            str += "\nMachine is waiting for turning crank";
        } else if (state == soldState) {
            str += "\nMachine is ready for dispensing";
        }
        str += "\n";
        return str;
    }
}