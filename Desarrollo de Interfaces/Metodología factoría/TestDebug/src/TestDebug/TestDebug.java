package TestDebug;

import java.util.ArrayList;

public class TestDebug {
	public static void main(String[] args) {
		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<Alumno> arr2 = new ArrayList<Alumno>();
		
		arr1.add("Jose");
		arr1.add("Chino");
		arr1.add("Alfredo");
		
		Alumno alumno1 = new Alumno("Alfredo", 20, 180.0);
		Alumno alumno2 = new Alumno("Zihao", 30, 220.0);
		Alumno alumno3 = new Alumno("Raul", 25, 340.0);
		arr2.add(alumno1);
		arr2.add(alumno2);
		arr2.add(alumno3);
		/*
		for(int i=0;i<arr1.size();i++) {
			arr1.get(i);
		}
		*/
		for(Alumno i : arr2) {
			System.out.println(i);
		}
	}

}
