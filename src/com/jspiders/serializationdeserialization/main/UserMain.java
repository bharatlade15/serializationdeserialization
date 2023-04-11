package com.jspiders.serializationdeserialization.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.jspiders.serializationdeserialization.object.User;

public class UserMain {
public static void main(String[] args) {
	File file;
	FileInputStream fileInputStream;
	FileOutputStream fileOutputStream;
	try {
	file=new File("Object.txt");
	if (file.exists()) {
		System.out.println("file already exit.");
	} else {
			file.createNewFile();
			System.out.println("file created.");
		} 
	
		fileOutputStream=new FileOutputStream(file);
		fileInputStream=new FileInputStream(file);
		
		//serialization
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		User user=new User(1,"Bhrat","bharat@gmail.com");
		objectOutputStream.writeObject(user);
		System.out.println("Object written to file.");
		objectOutputStream.close();
		
		//deserialization
		ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
		
			User output=(User) objectInputStream.readObject();//downcasting from Object class
			System.out.println(output);
			objectInputStream.close();
	}
	catch (IOException |ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
}

