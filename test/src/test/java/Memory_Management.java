
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
	
	public static int FIFO(List<String> i, int frame) {
		String[] memory = new String[frame];
		int pagefault = 0;
		int n = 0;
		int index = 0;
		for(n=0;n<i.size();n++) {
			int count = 0;
			boolean same = false;
			while(count<frame) {
				same = false;
				if(i.get(n).equals(memory[count])) {
					same = true;
					break;
				}
				count++;
			}
			if(!same) {
				memory[index] = i.get(n);
				index++;
				if(index>=frame) {
					index=0;
				}
				pagefault++;
			}
		}
		return pagefault;
	}
	
	public static int LRU(List<String> i, int frame) {
		String[] memory = new String[frame];
		int pagefault = 0;
		int n = 0;
		int index = 0;
		boolean swapped = false;
		for(n=0;n<i.size();n++) {
			int count = 0;
			boolean same = false;
			while(count<frame) {
				same = false;
				if(i.get(n).equals(memory[count])) {
					same = true;
					break;
				}
				count++;
			}
			if(!same) {
				if(index>=frame) {
					index=0;
					swapped = true;
				}
				if(!swapped) {
					memory[index] = i.get(n);
					index++;
				}
				if(swapped) {
					List<Integer> ru = new ArrayList<>();
					int count2=0;
					for(int n2=n-1; n2>=0;n2--) {
						if(ru.size()>=2) {
							while(count2<frame) {
								if(!ru.contains(count2)) {
									memory[count2] = i.get(n);
									break;
								}
								count2++;
							}
						}
						for(int num = 0; num<frame; num++) {
							if(memory[num].equals(i.get(n2))) {
								if(!ru.contains(num)) {
									ru.add(num);
									break;
								}
							}
						
						}
					}
				}
				pagefault++;
			}
		}
		return pagefault;	
	}
	public static int Optimal(List<String> i, int frame) {
		String[] memory = new String[frame];
		int pagefault = 0;
		int n = 0;
		int index = 0;
		boolean swapped = false;
		for(n=0;n<i.size();n++) {
			int count = 0;
			boolean same = false;
			while(count<frame) {
				same = false;
				if(i.get(n).equals(memory[count])) {
					same = true;
					break;
				}
				count++;
			}
			if(!same) {
				if(index>=frame) {
					index=0;
					swapped = true;
				}
				if(!swapped) {
					memory[index] = i.get(n);
					index++;
				}
				if(swapped) {
					List<Integer> ru = new ArrayList<>();
					int count2=0;
					for(int n2=n+1; n2<i.size();n2++) {
						if(ru.size()>=2) {
							while(count2<frame) {
								if(!ru.contains(count2)) {
									memory[count2] = i.get(n);
									break;
								}
								count2++;
							}
						}
						for(int num = 0; num<frame; num++) {
							if(memory[num].equals(i.get(n2))) {
								if(!ru.contains(num)) {
									ru.add(num);
									break;
								}
							}
						
						}
						if(n2==i.size()-1 && ru.size()<2) {
							count2=0;
							while(count2<frame) {
								if(!ru.contains(count2)) {
									memory[count2] = i.get(n);
									break;
								}
								count2++;
							}
						}
					}
				}
				pagefault++;
			}
		}
		return pagefault;	
	}
}
