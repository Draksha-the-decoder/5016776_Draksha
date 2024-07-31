public class DependencyInjectionExample {

    public interface CustomerRepository {
        Customer findCustomerById(String id);
    }

    public static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(String id) {
            return new Customer(id, "Arpita");
        }
    }

   public static class Customer {
        private String id;
        private String name;

        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

   public static class CustomerService {
        private CustomerRepository customerRepository;

        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public Customer getCustomerById(String id) {
            return customerRepository.findCustomerById(id);
        }
    }

    public static void main(String[] args) {
       CustomerRepository customerRepository = new CustomerRepositoryImpl();
       CustomerService customerService = new CustomerService(customerRepository);
       Customer customer = customerService.getCustomerById("78954");
        System.out.println("Customer Details:");
        System.out.println("ID: " + customer.getId());
        System.out.println("Name: " + customer.getName());
    }
}

// OUTPUT

// Customer Details:
// ID: 78954
// Name: Arpita