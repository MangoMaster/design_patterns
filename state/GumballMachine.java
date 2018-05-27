/*public class GumballMachine {

    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("You can't insert another quarter");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("You inserted a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't insert a quarter, the machine is sold out");
        } else if (state == SOLD) {
            System.out.println("Please wait, we're already giving you a gumball");
        }
    }

    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("Quarter returned");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("You haven't inserted a quarter");
        } else if (state == SOLD) {
            System.out.println("Sorry, you already turned the crank");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't eject, you haven't inserted a quarter yet");
        }
    }

    public void turnCrank() {
        if (state == SOLD) {
            System.out.println("Turing twice doesn't get you another gumball!");
        } else if (state == NO_QUARTER) {
            System.out.println("You turned but there's no quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You turned but there are no gumballs");
        } else if (state == HAS_QUARTER) {
            System.out.println("You turned...");
            state = SOLD;
            dispense();
        }
    }

    public void dispense() {
        if (state == SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            --count;
            if (count == 0) {
                System.out.println("Oops, out of gumballs!");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            System.out.println("You need to pay first");
        } else if (state == SOLD_OUT) {
            System.out.println("No gumball dispensed");
        } else if (state == HAS_QUARTER) {
            System.out.println("No gumball dispensed");
        }
    }

    public String toString() {
        String str = "";
        str += "\nMighty Gumball, Inc.";
        str += "\nJava-enabled Stadning Gumball Model #2004";
        str += "\nInventory: " + count + " gumballs";
        if (state == SOLD_OUT) {
            str += "\nMachine is sold out";
        } else if (state == NO_QUARTER) {
            str += "\nMachine is waiting for quarter";
        } else if (state == HAS_QUARTER) {
            str += "\nMachine is waiting for turning crank";
        } else if (state == SOLD) {
            str += "\nMachine is ready for dispensing";
        }
        str += "\n";
        return str;
    }
}*/

public class GumballMachine {

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
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

    int getCount() {
        return count;
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