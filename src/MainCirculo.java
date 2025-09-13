class Circulo{
    private double radio;
    Circulo(){
        this.radio=1.0;
    }
    Circulo(double radio){
        this.radio=0.1;
    }

    public double getRadio(){
        return radio;
    }

    public void setRadio(double nuevoRadio) {
        if(nuevoRadio>0){
            this.radio=nuevoRadio;
        }else{
            System.out.println(" ");
        }
    }

    public void area(){
        System.out.println("El radio es: " + (Math.PI*Math.pow(radio,2)));
    }

    public void area(double radio){
        System.out.println("El radio es: " + (Math.PI*Math.pow(radio,2)));
    }

    public void circunferencia(){
        System.out.println("La circunferencia es: " + (2*(Math.PI*radio)));
    }
}

class MainCirculo{
    public static void main(String[] args){

        Circulo circulo=new Circulo();
        circulo.setRadio(6);
        circulo.area();
        circulo.area(2.3);
        circulo.circunferencia();

        Circulo circulo2=new Circulo(3.2);
        circulo2.setRadio(2);
        circulo2.area(2.3);
        circulo2.area();
        circulo2.circunferencia();




    }
}
