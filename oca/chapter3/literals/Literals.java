public class Literals {
	public static void main(String[] args) {
		
		// Litera³y dziesiêtne
		{
			// Podkre¶lenia
			int pre7 = 1000000;
			int with7 = 1_000_000;
			//int with7 = _1_000_000;	//¬LE
			//int with7 = 1_000_000_;	//¬LE
			int other = 123___4_____5_6;
			double x = 1_2_3.4_5_6;
			int bin = 0b0101_1111_1111;
			//int bin = 0b_0101_1111_1111;	//¬LE
			
			// Liczby dziesiêtne
			int length = 343;
			
			// Liczby binarne
			int b1 = 0b101010;
			int b2 = 0B00011;
			int b3 = 0B0_00_11;
			
			// Liczby ósemkowe
			int octalSix = 06;
			int octalEight = 010;
			System.out.println("Octal 010 = " + octalEight);
			
			// Liczby szesnastkowe
			int hex1 = 0X0001;
			System.out.println("hex1 = " + hex1);
			int hex2 = 0X7fffffff;
			System.out.println("hex2 = " + hex2);
			int hex3 = 0xDeadCafe;
			System.out.println("hex3 = " + hex3);
			
			// Long
			long longNumber = 0b1010101_0L;
			//long longNumber = 0b1010101_0_L; //¬LE
		}
		
		// Litera³y zmiennoprzecinkowe
		{
			double d1 = 123.456;
			double d2 = 123.456d;	// sufiks opcjonalny
			double d3 = 123.456D;	// sufiks opcjonalny
			
			// float f1 = 123.345; //¬LE
			float f1 = 123.345f; 
			float f2 = 123.345F; 
			float f3 = (float)123.345; // konwersja!
		}
		
		// Litera³y logiczne
		{
			boolean bool1 = true;
			boolean bool2 = false;
			// boolean bool3 = 0; //¬LE
		}
		
		// Litera³y znakowe
		{
			char c1 = 'A';
			char c2 = '@';
			
			char a = 0x892;
			char b = 982;
			char c = (char)7000;
			char d = (char) -98;
			//char e = -29; //¬LE - potrzebne rzutowanie
			char f1 = 65535;
			//char f2 = 65536; //¬LE - przekracza zakres
			char f2 = (char)65536;
			System.out.println((int)f2);
		}
		
		// Litera³y napisowe
		{
			System.out.println("Napis1" + " KOÑ");
		}
	}
}

