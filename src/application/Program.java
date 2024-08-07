package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TEST 1: Seller Find By Id ===");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller.toString());

		System.out.println("=== TEST 2: Seller FindByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("=== TEST 3: Seller FindAll ===");
		List<Seller> list2 = sellerDao.findAll();
		for (Seller obj : list2) {
			System.out.println(obj);
		}

		System.out.println("=== TEST 4: Seller Insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("=== TEST 5: Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Pill");
		seller.setBaseSalary(5000.00);
		sellerDao.updateById(seller);
		System.out.println("Updated! The new data is : " + seller.toString());
	}
}
