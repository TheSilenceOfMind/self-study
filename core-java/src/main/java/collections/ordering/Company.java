package collections.ordering;


public class Company implements Comparable {

    private final String name;
    private final String owner;

    Company(String name, String owner) {
        if (name == null || owner == null)
            throw new NullPointerException();
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null)
            throw new NullPointerException();
        if (!(o instanceof Company))
            throw new ClassCastException();
        Company company = (Company) o;
        int res = this.name.compareTo(company.name);
        if (res == 0)
            return this.owner.compareTo(company.owner);
        else
            return res;
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s%nOwner: %s%n",
                name.toString(), owner.toString()
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + owner.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Company))
            return false;
        Company c = (Company) o;
        return
                this.name.equals(c.name)
                && this.owner.equals(c.owner);
    }
}
