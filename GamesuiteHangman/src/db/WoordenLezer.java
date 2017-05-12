package db;

import domain.*;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WoordenLezer {
	private String woord;
	private WoordenLijst woorden = new WoordenLijst();

	public WoordenLezer() {
		File file = new File("hangman.txt");
		Scanner scannerfile;
		try {
			scannerfile = new Scanner(file);
			while (scannerfile.hasNextLine()) {
				Scanner scannerlijn = new Scanner(scannerfile.nextLine());
				woord = scannerlijn.next();
				lees();
				scannerlijn.close();
			}

			scannerfile.close();

		}

		catch (FileNotFoundException e) {
			throw new DbException("De file kan niet gevonden worden");
		}

	}

	public WoordenLijst lees() {
		getWoorden().voegToe(woord);
		return getWoorden();
	}

	public WoordenLijst getWoorden() {
		return woorden;
	}

}
