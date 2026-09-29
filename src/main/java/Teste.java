import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Cliente;

public class Teste {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bancoPU");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
//        FIND
        Cliente cliente = entityManager.find(Cliente.class, 1);
        System.out.println("Nome do cliente: "+cliente.getNome());

//        INSERT
//        Cliente cliente = new Cliente();
//        cliente.setNome("Joao");
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(cliente);
//        entityManager.getTransaction().commit();

//        DELETE
//        Cliente cliente = entityManager.find(Cliente.class, 2);
//        entityManager.getTransaction().begin();
//        entityManager.remove(cliente);
//        entityManager.getTransaction().commit();


//        Cliente cliente =  new Cliente();
        cliente.setId(1);
        cliente.setNome("Jesus Cristo");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
