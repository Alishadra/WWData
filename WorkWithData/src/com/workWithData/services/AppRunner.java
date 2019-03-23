package com.workWithData.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.workWithData.utils.Randomizer;
import com.workWithData.Entity.MyPojo;

public class AppRunner {

	public static void main(String[] args) {
		
//		public static int getID() {
//			
//			
//			Random id = new Random();
//			for (int i = 1; i <11; i++) {
//				id.nextInt();
//			}
//			
//		}
		
		public static void writeConectionLogFile(ConectionLog, conectionLog boolean appented) {
			FileReader file = null;
			
			
			try {
				file = new FileReader(fileName:"D:/WorkWJava/Test.txt", true);
				file.write();		
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						file.close();
					} catch (Exception e) {
					}
				}
		}
		
		
		
	}

}
