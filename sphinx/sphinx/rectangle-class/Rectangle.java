// TODO: crie uma classe Rectangle com:
//   - dois atributos int: width e height
//   - um construtor Rectangle(int width, int height)
//   - int area()          retorna width × height
//   - int perimeter()     retorna 2 × (width + height)
//   - boolean isSquare()  retorna true quando width é igual a height
public class Rectangle {
 private int width;
 private int height;

 Rectangle(int width, int height){
    this.width = width;
    this.height = height;

 }
 int area(){
    return width*height;
 }
 int perimeter(){
    return 2* (width*height);
 }
 boolean isSquare(){
    return width == height;
 }
    
}

void main() {
    int n = Integer.parseInt(IO.readln().trim());
    for (int i = 0; i < n; i++) {
        String[] parts = IO.readln().trim().split(" ");
        int width = Integer.parseInt(parts[0]);
        int height = Integer.parseInt(parts[1]);
        // TODO: crie um Rectangle e imprima: Area: <area>, Perimeter: <perimeter>, Square: <isSquare>
        Rectangle rectangle = new Rectangle(width, height);   
        IO.println();(rectangle.area(), rectangle.perimeter(), rectangle.isSquare());     
    }
}
