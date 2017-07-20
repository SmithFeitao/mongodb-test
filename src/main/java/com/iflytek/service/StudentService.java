package com.iflytek.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.iflytek.model.Student;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class StudentService {
	public static void main(String[] args) throws IOException {
		
		Properties properties = new Properties();
		properties.load(StudentService.class.getResourceAsStream("/mongodb.properties"));
		
		
		
		MongoClient client = null;
		
		client = new MongoClient(properties.getProperty("mongodb.host"),Integer.parseInt(properties.getProperty("mongodb.port")));
		
//		System.out.println(client);
		
		
		String dbName = properties.getProperty("mongodb.dbName");
		
		DBCollection collection = client.getDB(dbName).getCollection("student");
		
		// 查询条件
		BasicDBObject query = new BasicDBObject();
		query.append("age", 23);
		
		DBCursor dbCursor = collection.find(query);
		
		List<Student> studentList = new ArrayList<Student>();
		// 查询的结果集
		try {
			while (dbCursor.hasNext()) {
				BasicDBObject dbObject = (BasicDBObject) dbCursor.next();
				studentList.add(new Student(dbObject.getString("className"),dbObject.getString("name"),dbObject.getInt("age")));
			}
		} finally{
			dbCursor.close();
		}
		
		for (Student student:studentList){
			System.out.println(student.toString());
		}
		
	}
}
