package principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrincipalTeste {

	public static void  main(String[] args) {
		List<Integer> lista = new ArrayList<>(Arrays.asList(1,50,20,22,30,40,9,2,36));
		
	//	lista = lista.stream().filter(l -> l >= 20).collect(Collectors.toList());
		List<String> listaS = lista.stream().filter(l -> l > 5)
				.sorted()
				.map(l -> l.toString()).collect(Collectors.toList());
		System.out.println(listaS);
	}
}
