package chuong2.cau8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class PrimitiveRootCheck {

	// Hàm kiểm tra xem a có là căn nguyên thủy của n không
	static boolean isPrimitiveRoot(int a, int n) {
		if (n <= 1)
			return false;
		if (gcd(a, n) != 1)
			return false;

		int phi = n - 1;
		HashSet<Integer> primeFactors = new HashSet<>();
		int m = phi;
		for (int i = 2; i * i <= m; i++) {
			if (m % i == 0) {
				primeFactors.add(i);
				while (m % i == 0) {
					m /= i;
				}
			}
		}
		if (m > 1) {
			primeFactors.add(m);
		}
		for (int p : primeFactors) {
			if (power(a, phi / p, n) == 1) {
				return false;
			}
		}
		return true;
	}

	// Hàm tính ước chung lớn nhất của hai số
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	// Hàm tính a^b mod n
	static int power(int a, int b, int n) {
		int result = 1;
		a %= n;
		while (b > 0) {
			if ((b & 1) == 1) {
				result = (result * a) % n;
			}
			b >>= 1;
			a = (a * a) % n;
		}
		return result;
	}

	public static void main(String[] args) {
		int a;
		int n;

		String filePath = "D:\\input.txt";
		String A = "";
		String N = "";

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			int i;
			for (i = 1; i <= 2; i++) {
				if (i == 1) {
					A = br.readLine();
				} else {
					N = br.readLine();
				}
			}
		} catch (IOException e) {
			System.err.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
		}

		a = Integer.parseInt(A);
		n = Integer.parseInt(N);

		if (isPrimitiveRoot(a, n)) {
//   		 Ghi ra file
			String outputFilePath = "D:\\output.txt";
			try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
				writer.println(a + " là một căn nguyên thủy của " + n + ".");

			} catch (IOException e) {
				System.err.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
			}
		} else {

//  		 Ghi ra file
			String outputFilePath = "D:\\output.txt";
			try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
				writer.println(a + " không phải là căn nguyên thủy của " + n + ".");

			} catch (IOException e) {
				System.err.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
			}
		}
	}
}
