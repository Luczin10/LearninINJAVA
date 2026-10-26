class Book {
    private final String id;
    private final String title;
    private String borrower; // null quando disponível

    Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    String getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    String getBorrower() {
        return borrower;
    }

    boolean isAvailable() {
        return borrower == null;
    }

    void lendTo(String name) {
        borrower = name;
    }

    void giveBack() {
        borrower = null;
    }

    @Override
    public String toString() {
        return id + " " + title + " - "
                + (isAvailable() ? "available" : "borrowed by " + borrower);
    }
}

class Library {
    static final int LIMIT = 2;

    private final Map<String, Book> books = new TreeMap<>(); // ordena pelo id
    private final Set<String> members = new HashSet<>();

    String add(String id, String title) {
        if (books.containsKey(id))
            return "Book " + id + " already exists";
        books.put(id, new Book(id, title));
        return "Added book " + id + ": " + title;
    }

    String join(String name) {
        if (!members.add(name))
            return "Member " + name + " already exists";
        return "Member " + name + " joined";
    }

    String borrow(String id, String name) {
        Book book = books.get(id);
        if (book == null)
            return "No book " + id;
        if (!members.contains(name))
            return "No member " + name;
        if (!book.isAvailable())
            return book.getTitle() + " is already borrowed by " + book.getBorrower();
        if (countBorrowedBy(name) >= LIMIT)
            return name + " has reached the limit of " + LIMIT + " books";
        book.lendTo(name);
        return name + " borrowed " + book.getTitle();
    }

    String giveBack(String id) {
        Book book = books.get(id);
        if (book == null)
            return "No book " + id;
        if (book.isAvailable())
            return book.getTitle() + " is not borrowed";
        book.giveBack();
        return book.getTitle() + " returned";
    }

    String list() {
        if (books.isEmpty())
            return "No books";
        List<String> lines = new ArrayList<>();
        for (Book b : books.values())
            lines.add(b.toString());
        return String.join("\n", lines);
    }

    String summary() {
        int borrowed = 0;
        for (Book b : books.values())
            if (!b.isAvailable())
                borrowed++;
        return "Books: " + books.size() + ", borrowed: " + borrowed;
    }

    private int countBorrowedBy(String name) {
        int count = 0;
        for (Book b : books.values())
            if (name.equals(b.getBorrower()))
                count++;
        return count;
    }
}

void main() {
    final String UNKNOWN = "Unknown command";
    Library lib = new Library();

    while (true) {
        String line = IO.readln();
        if (line == null)
            line = "exit"; // fim da entrada sem exit
        String[] p = line.trim().split(" ", 3);

        switch (p[0]) {
            case "add" -> IO.println(p.length == 3 ? lib.add(p[1], p[2]) : UNKNOWN);
            case "join" -> IO.println(p.length == 2 ? lib.join(p[1]) : UNKNOWN);
            case "borrow" -> IO.println(p.length == 3 && !p[2].contains(" ")
                    ? lib.borrow(p[1], p[2])
                    : UNKNOWN);
            case "return" -> IO.println(p.length == 2 ? lib.giveBack(p[1]) : UNKNOWN);
            case "list" -> IO.println(p.length == 1 ? lib.list() : UNKNOWN);
            case "exit" -> {
                if (p.length == 1) {
                    IO.println(lib.summary());
                    IO.println("Goodbye!");
                    return;
                }
                IO.println(UNKNOWN);
            }
            default -> IO.println(UNKNOWN);
        }
    }
}