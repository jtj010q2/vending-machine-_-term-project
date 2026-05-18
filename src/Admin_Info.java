import org.mindrot.jbcrypt.BCrypt;
import java.io.*;

public class Admin_Info {

    private String hashedPassword;

    public Admin_Info() {
        File file = new File("admin.txt");
        if (file.exists()) {
            this.hashedPassword = loadPassword();
        } 
        else {
        	System.out.println("관리자 계정이 존재하지 않습니다. 생성 창으로 이동합니다.");
        	this.hashedPassword = null;
        }
    }

    public boolean setInitialPassword(String pw) {
        if (!validatePassword(pw)) {
            System.out.println("형식이 올바르지 않습니다.");
            return false;
        }
        this.hashedPassword = BCrypt.hashpw(pw, BCrypt.gensalt());
        savePassword(this.hashedPassword);
        return true;
    }

    boolean validatePassword(String pw) {
    	if(pw.length()<8) {
    		System.out.println("비밀번호는 8자리 이상이여야 합니다.");
    		return false;
    	}
    	
    	int num_count = 0; 		
    	int char_count = 0;		
    	int special_count = 0;	//셋중 하나라도 0일때 false
    	
    	for (int i = 0 ; i < pw.length(); i++) {
    		
    	}
    	if() {
    		
    	}
    	
    	return true;
    }

    boolean login(String pw) {
        return BCrypt.checkpw(pw, this.hashedPassword);
    }

    void savePassword(String hashed) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("admin.txt"))) {
            bw.write(hashed);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    String loadPassword() {
        try (BufferedReader br = new BufferedReader(new FileReader("admin.txt"))) {
            return br.readLine();
        } 
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}