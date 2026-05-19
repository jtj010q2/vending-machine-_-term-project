import java.io.*;
import java.time.*;
import java.time.format.*;

public class SalesRecord {
	private String fileName;
	
	public SalesRecord(String fileName) {
		this.fileName = fileName;
		File file = new File(this.fileName);
		boolean isNewFile = !file.exists();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true))){
			if (isNewFile) {
				bw.write("날짜,음료명,판매량,총매출액");
				bw.newLine();
			}		
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void	addRecord(Drink drink,int soldCount) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String today = LocalDate.now().format(formatter);
		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true))){
			bw.write(today+","+drink.name+","+soldCount+","+(drink.price * soldCount));
			bw.newLine();
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
