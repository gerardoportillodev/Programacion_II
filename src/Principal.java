class Figura{
    protected  String color;

    public Figura(String color){
        this.color = color;
    }

    public double calcularArea(){
        return 0;
    }

    public void mostrarInfo(){
        System.out.println("Color: " + this.color);
    }

}

class Circle extends Figura{
    private double radio;
    public Circle(String color, double radio){
        super(color);
        this.radio = radio;
    }
    @Override
    public double calcularArea(){
        return Math.PI * this.radio * this.radio;
    }

    @Override
    public void mostrarInfo(){
        System.out.println("Tipo: Circulo, Radio: " + radio + ", Area: " + calcularArea());
    }
}

class Rectan extends Figura{
    private double base;
    private double altura;

    public Rectan(String color, double base, double altura){
        super(color);
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double calcularArea(){
        return  base * altura;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Tipo: Rectangulo, Base: " + base + ", Altura: " + altura + ", Area: " + calcularArea());
    }
}

public class Principal {
    public static void main(String[] args) {
        Figura[] figuras = new Figura[3];
        figuras[0] = new Circle("Roja", 5.0);
        figuras[1] = new Rectan("Azul", 4.0, 6.0);
        figuras[2] = new Circle("Verde", 3.0);

        for (Figura figura : figuras){
            figura.mostrarInfo();
            System.out.println("Area calculada: " + figura.calcularArea());
            System.out.println("----------------");
        }

    }
}