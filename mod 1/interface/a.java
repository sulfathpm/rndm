import javax.swing.*;
import java.awt.*;
interface Printable {
    public void display();
    public void show();
}
interface Computable {
    public double area();
    public double perimeter();
    public double volume();
}
interface Drawable {
    public void draw();   }
    class Rectangle implements Printable, Computable, Drawable {
    double length, width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public void display() {
        System.out.println("Rectangle (" + length + "," + width + ")");       }
    public void show() {}
    public double area() { return length * width; }
    public double perimeter() { return 2 * (length + width); }
    public double volume() { return 0; }
    public void draw() { // Drawing Rectangle
        JFrame frame = new JFrame("Drawing Rectangle");
        frame.setSize(600, 600);
        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
		     g.drawRect(50, 50, (int)length, (int)width);
            }
        });
        frame.setVisible(true);
    }}
        public void draw() { // Drawing Circle
        JFrame frame = new JFrame("Drawing Circle");
        frame.setSize(400, 400);
        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
		     int d = (int)radius * 2;
                g.drawOval(50, 50, d, d);
            }
        });
        frame.setVisible(true);     }
        