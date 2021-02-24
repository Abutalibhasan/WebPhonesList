import java.util.List;
import java.util.Scanner;

import controller.ListHelper;
import model.CellPhones;
/**
 * Abutalib Hasan - amhasan
 * 202101 CIS171 12928
 * Feb 10, 2021
 */
public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	static ListHelper lh = new ListHelper();

	private static void addPhone() {
		// TODO Auto-generated method stub
		System.out.print("Enter the manufacturer: ");
		String man = in.nextLine();
		System.out.print("Enter the model : ");
		String model = in.nextLine();
		
		CellPhones toAdd = new CellPhones(man,model);
		lh.insertPhone(toAdd);

	}

	private static void deletePhone() {
		// TODO Auto-generated method stub
		System.out.print("Enter the manufacturer to delete: ");
		String man = in.nextLine();
		System.out.print("Enter the model to delete: ");
		String model = in.nextLine();

		CellPhones toDelete = new CellPhones(man,model);
		lh.deletePhone(toDelete);
	}

	private static void editPhone() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Manufacturer");
		System.out.println("2 : Search by Cell phone Model");
		int searchBy = in.nextInt();
		in.nextLine();
		List<CellPhones> founds;
		if (searchBy == 1) {
			System.out.print("Enter the manufacturer: ");
			String manuName = in.nextLine();
			founds = lh.searchForPhoneByManufacturer(manuName);
			
		} else {
			System.out.print("Enter the cellphone model: ");
			String modelName = in.nextLine();
			founds = lh.searchForItemByPhoneModel(modelName);

		}

		if (!founds.isEmpty()) {
			System.out.println("Found Results.");
			for (CellPhones c : founds) {
				System.out.println(c.getId() + " : " + c.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			CellPhones toEdit = lh.searchForPhoneById(idToEdit);
			System.out.println("Retrieved " + toEdit.getModel() + " from " + toEdit.getManufacturer());
			System.out.println("1 : Update Manufacturer");
			System.out.println("2 : Update Phone Model");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Manufacturer: ");
				String newMan = in.nextLine();
				toEdit.setManufacturer(newMan);
			} else if (update == 2) {
				System.out.print("New Model: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			}

			lh.updatePhone(toEdit);

		} else {
			System.out.println("---- No results found");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome shopping list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a cellphone");
			System.out.println("*  2 -- Edit a cellphone");
			System.out.println("*  3 -- Delete a cellphone");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addPhone();
			} else if (selection == 2) {
				editPhone();
			} else if (selection == 3) {
				deletePhone();
			} else if (selection == 4) {
				viewTheList();
			} else {
				//lh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
					List<CellPhones> allPhones = lh.showAllPhones();
					for(CellPhones singlePhone : allPhones){
					System.out.println(singlePhone.returnPhoneDetails());
		

	}

	}

}
