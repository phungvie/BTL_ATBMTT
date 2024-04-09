package chuong1.cau4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class SimpleSubstitutionCipher {

	// Phương thức để thực hiện mã hóa chữ đơn
	public static String encrypt(String plaintext, String key) {
		// Tạo một HashMap để ánh xạ từ ký tự trong bản gốc sang ký tự đã mã hóa
		HashMap<Character, Character> substitutionMap = new HashMap<>();
		for (int i = 0; i < plaintext.length(); i++) {
			substitutionMap.put(plaintext.charAt(i), key.charAt(i));
		}

		// Tạo một StringBuilder để xây dựng văn bản đã mã hóa
		StringBuilder encryptedText = new StringBuilder();
		for (int i = 0; i < plaintext.length(); i++) {
			char originalChar = plaintext.charAt(i);
			char encryptedChar = substitutionMap.get(originalChar);
			encryptedText.append(encryptedChar);
		}

		return encryptedText.toString();
	}

	public static void main(String[] args) {
//        // Dữ liệu đầu vào
//        String plaintext = "WHENINROMEDOASTH";
//        String key = "HLXQPSVKMZYCDUEGJTNFBAIWOR";
//        
//        // Thực hiện mã hóa
//        String encryptedText = encrypt(plaintext, key);
//        
//        // In kết quả ra màn hình
//        System.out.println("Input: " + plaintext);
//        System.out.println("Key: " + key);
//        System.out.println("Output: " + encryptedText);

		// Đường dẫn của file cần đọc
		String filePath = "D:\\input.txt";
		String plaintext = "";
		String key = "";

		// Đọc từ file
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			int i;
			for (i = 1; i <= 2; i++) {
				if (i == 1) {
					plaintext = br.readLine();
				} else {
					key = br.readLine();
				}
			}
		} catch (IOException e) {
			System.err.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
		}

		// Thực hiện mã hóa
		String encryptedText = encrypt(plaintext, key);

//		 Ghi ra file
		String outputFilePath = "D:\\output.txt";
		try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
			writer.println("Input: " + plaintext);
			writer.println("Key: " + key);
			writer.println("Output: " + encryptedText);
		} catch (IOException e) {
			System.err.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
		}
	}
}