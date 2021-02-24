package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CellPhones;

/**
 * Abutalib Hasan - amhasan
 * 202101 CIS171 12928
 * Feb 10, 2021
 */
public class ListHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CellPhonesList");
	public void insertPhone(CellPhones cp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cp);
		em.getTransaction().commit();
		em.close();

	}
	
	public List<CellPhones> showAllPhones(){
		EntityManager em = emfactory.createEntityManager();
			List<CellPhones> allPhones = em.createQuery("SELECT p FROM CellPhones p").getResultList();
			return allPhones;
			}
	public void deletePhone(CellPhones toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CellPhones> typedQuery = em.createQuery("select cp from CellPhones cp where cp.manufacturer = :selectedManufacturer and cp.model = :selectedModel", CellPhones.class);

//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedManufacturer", toDelete.getManufacturer());
		typedQuery.setParameter("selectedModel", toDelete.getModel());

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		CellPhones result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public CellPhones searchForPhoneById(int idToEdit) {
		// TODO Auto-generated method stub
		

		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CellPhones found = em.find(CellPhones.class, idToEdit);
		em.close();
		return found;

	}
	public List<CellPhones> searchForPhoneByManufacturer(String ManufacturerName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CellPhones> typedQuery = em.createQuery("select cp from CellPhones cp where cp.manufacturer = :selectedManufacturer", CellPhones.class);
		typedQuery.setParameter("selectedManufacturer", ManufacturerName);

		List<CellPhones> foundPhones = typedQuery.getResultList();
		em.close();
		return foundPhones;
	}

	
	public List<CellPhones> searchForItemByPhoneModel(String modelName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CellPhones> typedQuery = em.createQuery("select cp from CellPhones cp where cp.model = :selectedModel", CellPhones.class);
		typedQuery.setParameter("selectedModel", modelName);

		List<CellPhones> foundPhones = typedQuery.getResultList();
		em.close();
		return foundPhones;
}


	/**
	 * @param toEdit
	 */
	public void updatePhone(CellPhones toEdit) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				
				em.merge(toEdit);
				em.getTransaction().commit();
				em.close();

		
	}
	
	public void cleanUp(){
		emfactory.close();
	}


}
