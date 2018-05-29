import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {
    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    public MatchMakingTestDrive() {
        initializeDatabase();
    }

    public void drive() {
        PersonBean joe = getPersonFromDatabase("Joe Javabean");
        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());
        try {
            ownerProxy.setInterests("bowling, Go");
            System.out.println("Interests set from owner proxy");
        } catch (Exception ex) {
            System.out.println("Can't set interests from owner proxy");
        }
        try {
            ownerProxy.setHotOrNotRating(10);
            System.out.println("Rating set from owner proxy");
        } catch (Exception ex) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("bowling, Go");
            System.out.println("Interest set from non owner proxy");
        } catch (Exception ex) {
            System.out.println("Can't set interests from non owner proxy");
        }
        try {
            nonOwnerProxy.setHotOrNotRating(3);
            System.out.println("Rating set from non owner proxy");
        } catch (Exception ex) {
            System.out.println("Can't set rating from non owner proxy");
        }
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
    }

    PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
    }

    PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
    }
}