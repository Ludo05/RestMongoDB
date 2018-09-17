package mongospring.demo.Stuff;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cust")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
    public List<Customer> getAllPets() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Customer> getCustomerById(@PathVariable("id") ObjectId id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public Customer createPet(@Valid @RequestBody Customer customer) {
        Customer saved = repository.save(customer);
        return saved;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        repository.deleteById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public @ResponseBody String update(@PathVariable("id") ObjectId id, @RequestBody Customer customer){
       Customer c = repository.findByid(id);
       c.setFirstName(customer.getFirstName());
       c.setLastName(customer.getLastName());
       repository.save(c);
        return "updated";
    }
}