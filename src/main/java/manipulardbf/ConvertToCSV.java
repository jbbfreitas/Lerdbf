package manipulardbf;

import java.io.*;
import com.linuxense.javadbf.*;

public class ConvertToCSV {

	public static void main(String args[]) {
		DBFReader reader = null;
		try {

			reader = new DBFReader(new FileInputStream("dbase_03.dbf"));
			Object[] rowObjects;
			int numberOfFields = reader.getFieldCount();
			for (int i = 0; i < numberOfFields; i++) {
				DBFField field = reader.getField(i);
				System.out.print(field.getName() + ";");
			}
            System.out.println();
			while ((rowObjects = reader.nextRecord()) != null) {
				for (int i = 0; i < rowObjects.length; i++) {
					System.out.print(rowObjects[i] + ";");
				}
				System.out.println();
			}
		} catch (DBFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			DBFUtils.close(reader);
		}
	}
}
