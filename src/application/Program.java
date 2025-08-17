package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> mapVotos = new HashMap<>();
		
		System.out.print("Digite o caminho do arquivo: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				String nome = fields[0];
				Integer votos = Integer.parseInt(fields[1]);
				
				
				if (mapVotos.containsKey(nome)) {
					Integer votosExistentes = mapVotos.get(nome);
					mapVotos.put(nome, votosExistentes + votos);
				} else {
					mapVotos.put(nome, votos);
				}
				
				line = br.readLine();
			}
			System.out.println("Total de votos por candidato:");
			for (String key : mapVotos.keySet()) {
				System.out.println(key + ": " + mapVotos.get(key));
			}
			
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}