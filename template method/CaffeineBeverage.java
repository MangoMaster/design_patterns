public abstract class CaffeineBeverage {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected abstract void brew();

    protected void pourInCup() {
        System.out.println("pouring into cup");
    }

    protected abstract void addCondiments();
}