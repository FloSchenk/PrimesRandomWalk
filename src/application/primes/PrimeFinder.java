package application.primes;

public class PrimeFinder {
	public static boolean[] findPrimes(int max) {
		final int maxprim = (int) Math.sqrt(max) + 2;
		boolean[] zahlen = new boolean[max]; // alle Zahlen bis max
		for (int i = 0; i < max; i++)
			zahlen[i] = i % 2 == 1; // gerade Zahlen direkt streichen

		for (int prim = 3; prim < maxprim; prim += 2) // nur die ungeraden Zahlen
			if (zahlen[prim]) { // noch nicht gestrichen
				for (int i = prim; i <= max / prim; i++) {
					final int zahl = i * prim;
					if (zahl < max) // Überlauf verhindern
						zahlen[zahl] = false; // streichen
				}
			}
		zahlen[1] = false;
		zahlen[2] = true;
		
		return zahlen;
	}
}