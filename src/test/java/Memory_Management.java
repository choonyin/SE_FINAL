
import java.util.*;
import java.util.List;

public class Memory_Management {

	public static void main(String[] args) {
			List<String> i = new ArrayList<>();
			Scanner scanner = new Scanner(System.in);
			String method = "";
			String frame = "";
			String pages = "";
			String warning = "";
			do {
				System.out.print(warning+"Choose and write a method ('FIFO', 'LRU', 'Optimal'): ");
				method = scanner.nextLine();
				warning = "Incorrect Method! ";
			}while(!method.equals("FIFO") && !method.equals("LRU") && !method.equals("Optimal"));
			warning = "";
			do {
				System.out.print(warning+"Choose and write a frame number ('3', '4'): ");
				frame = scanner.nextLine();
				warning = "Incorrect Frame Number! ";
				if(!isNumeric(frame)) {
					warning = "Please Enter Number!";
				}
			}while(!frame.equals("3") && !frame.equals("4"));
			do {
				System.out.print("Enter a page (Enter 'Exit' to stop): ");
				pages = scanner.nextLine();
				if(isNumeric(pages) && pages!="" && Integer.parseInt(pages)>=0) {
					i.add(pages);
				}else if(pages.equals("Exit")){
					
				}else {
					System.out.println("Please enter a positive integer or 0!");
				}
			}while(!pages.equals("Exit"));
			if(method.equals("FIFO")) {
				System.out.println("Page fault: "+FIFO(i, Integer.parseInt(frame)));
			}else if(method.equals("LRU")) {
				System.out.println("Page fault: "+LRU(i, Integer.parseInt(frame)));
			}else if(method.equals("Optimal")) {
				System.out.println("Page fault: "+Optimal(i, Integer.parseInt(frame)));
			}
	}
	
	public static boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}

        public static int FIFO(List<String> i, int frame){
             return 0;
        }

        public static int LRU(List<String> i, int frame){
             return 0;
        }

        public static int Optimal(List<String> i, int frame){
             return 0;
	}
}
