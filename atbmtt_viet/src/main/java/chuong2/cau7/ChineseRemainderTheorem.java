package chuong2.cau7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ChineseRemainderTheorem {
	public static int findX(int[] m, int[] a) {
		int M = 1;
		for (int i = 0; i < m.length; i++) {
			M *= m[i];
		}

		int[] M_bar = new int[m.length];
		for (int i = 0; i < m.length; i++) {
			M_bar[i] = M / m[i];
		}

		int[] y = new int[m.length];
		for (int i = 0; i < m.length; i++) {
			y[i] = modInverse(M_bar[i], m[i]);
		}

		int x = 0;
		for (int i = 0; i < m.length; i++) {
			x = (x + (a[i] * M_bar[i] * y[i]) % M) % M;
		}

		return x;
	}

	public static int modInverse(int a, int m) {
		a = a % m;
		for (int x = 1; x < m; x++) {
			if ((a * x) % m == 1) {
				return x;
			}
		}
		return 1;
	}

	public static void main(String[] args) {

		// Đường dẫn của file cần đọc
		String filePath = "D:\\input.txt";
		String[] M = {};
		String[] A = {};

		// Đọc từ file
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			int i;
			for (i = 1; i <= 2; i++) {
				if (i == 1) {
					M = br.readLine().split(" ");
				} else {
					A = br.readLine().split(" ");
				}
			}
		} catch (IOException e) {
			System.err.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
		}

		int[] a = new int[A.length];
		int[] m = new int[M.length];

		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(A[i]);
		}
		for (int i = 0; i < m.length; i++) {
			m[i] = Integer.parseInt(M[i]);
		}

		int x = findX(m, a);
		
//		 Ghi ra file
		String outputFilePath = "D:\\output.txt";
		try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
			writer.println("x= "+x);
		
		} catch (IOException e) {
			System.err.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
		}
	}
}
