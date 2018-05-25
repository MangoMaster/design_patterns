public abstract class CaffeineBeverageWithHook {
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected abstract void brew();

    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }

    protected abstract void addCondiments();

    boolean customerWantsCondiments() {
        return true;
    }
}