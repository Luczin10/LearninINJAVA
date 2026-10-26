// TODO: crie uma classe Book com os atributos title, author e year,
// um construtor e um método toString() que retorna:
//   "<title>" by <author> (<year>)
class Book{
    String title;
    String author;
    int year;

    Book(String title, String author, int year){
this.title = title;
this.author = author;
this.year = year;

    }
    
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + year + ")";
    }
}
void main() {
    int n = Integer.parseInt(IO.readln().trim());
    for (int i = 0; i < n; i++) {
        String[] parts = IO.readln().split(";");
        String title = parts[0];
        String author = parts[1];
        int year = Integer.parseInt(parts[2]);
        // TODO: crie um Book e imprima direto, por exemplo IO.println(book);
        Book livro = new Book(title, author, year);
        IO.println(livro);
    }
}
