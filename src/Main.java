import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Para escribir un fichero de texto
		//Pedimos un texto por consola y escribimos en un fichero de texto
		
		Scanner S= new Scanner (System.in);
		S.useDelimiter("\r\n");
		
		System.out.println("Introduce un texto");
		String texto =S.next();
		
		try {
			//el true que agregamos alado del nombre del texto, para q cuando abra el fich
			//no sobrescriba,sino q conserve lo q ya tenía
			BufferedWriter bw=new BufferedWriter(new FileWriter("test.txt",true));
			bw.write(texto);
			//\r\n es para hacer salto de linea en ficheros
			bw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//Llamamos al metodo para leer el fichero
		System.out.println("**********Empezamos a leer el fichero********");
		leerFicheroDeTexto("test.txt");
		System.out.println("Mostramos el número de lineas que tiene el fichero:");
		int numLineasFich= contarNumLineasFich("test.txt");
		System.out.println("El fichero tiene "+numLineasFich+" lineas");
		
		/*Vamos a pedir un número de lineas y leer hasta ese número de lineas
		 si el número que ingresan es negativo o se lee más lineas de las qu hay
		 lanza una exceptión */
		System.out.println("Intoduzca el número de lineas que desea leer ");
		System.out.println("El número debe ser positivo y no más del número de líneas que hay en el fichero: ");
		int numLineasLeer=S.nextInt();
		try (BufferedReader br= new BufferedReader(new FileReader("test.txt"))){
		if(numLineasLeer<0 || numLineasLeer>numLineasFich) {
			throw new IOException("No puedes leer "+numLineasLeer+" linas");
		}
		
		String linea="";
		for(int i=0; i< numLineasLeer &&(linea=br.readLine()) != null; i++) {
			System.out.println(linea);
		}
		}catch (IOException e){
			e.printStackTrace();
		}
		
		
	}
	public static void leerFicheroDeTexto(String fichero) {
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(fichero));
			String linea="";
			while((linea=br.readLine()) !=null) {
				System.out.println(linea);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int contarNumLineasFich(String fichero) {
		int cont=0;
		try {
			BufferedReader br= new BufferedReader(new FileReader(fichero));
			String linea="";
			
			while((linea=br.readLine()) !=null) {
				cont++;
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return cont;
	}

}
