package app;

public class Triangulo {
	public String main(int a, int b, int c) {
		if (a>b+c || b>a+c || c>a+b)
			return "nao e um triangulo";
		else if (a==b && a==c)
        	return "triangulo equilatero";
        else if (a==b || a==c || b==c)
        	return "triangulo isosceles";
        return "triangulo escaleno";
	}
}
