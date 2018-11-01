package issues.polymorphismissues;

public class CovariantReturnTypes {
    public static void main(String[] args) {
        BaseEntity o = new BaseFabric().getEntity();
        System.out.println(o);

        o = new DerivedFabric().getEntity();
        System.out.println(o);
    }
}

class BaseFabric {
    public BaseEntity getEntity() { return new BaseEntity(); }
}

class DerivedFabric extends BaseFabric {
    @Override
    public DerivedEntity getEntity() { return new DerivedEntity(); }
}

class BaseEntity {
    @Override
    public String toString() { return "BaseEntity"; }
}

class DerivedEntity extends BaseEntity {
    @Override
    public String toString() { return "DerivedEntity"; }
}