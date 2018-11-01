package issues.memoryissues;

// Using finalize() to detect an object that
// hasn’t been properly cleaned up.
public class Book {

    private boolean isCheckedOut = false;

    Book(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkedIn();
        new Book(true);
        System.gc();
    }

    void checkedIn() {
        isCheckedOut = false;
    }

    @Override
    protected void finalize() {
        if (isCheckedOut)
            System.out.println("Error: checked out.");
//        super.finalize();
    }
}
