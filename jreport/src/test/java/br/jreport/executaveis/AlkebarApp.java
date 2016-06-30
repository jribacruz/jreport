package br.jreport.executaveis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import br.jreport.model.Alkebar;
import br.jreport.model.Teste2;

public class AlkebarApp {

	//teste para ver o entendimento do github
	public static void main(String[] args) throws FileNotFoundException {
	
		Alkebar alkebar1 = new Alkebar();
		alkebar1.generate(new FileOutputStream(new File("target/alkebarReport.pdf")));

	}

}


