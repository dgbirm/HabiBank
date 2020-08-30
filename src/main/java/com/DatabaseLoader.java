//for having mock data to test.
@Component
public class DatabaseLoader implements CommandLineRunner {


    private final CustomerRepository repository;

	@Autowired
	public DatabaseLoader(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception { (4)
		this.repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
	}
}
    
}