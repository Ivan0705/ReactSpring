package reactspring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactspring.demo.model.Employer;
import reactspring.demo.exeption.ResourceNotFoundException;
import reactspring.demo.repository.EmployerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployerRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployerRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employer> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employer createEmployee(@RequestBody Employer employer) {
        return employeeRepository.save(employer);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable Long id) {
        Employer employer = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employer not exits with id: " + id));
        return ResponseEntity.ok(employer);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employer> updateEmployee(@PathVariable Long id, @RequestBody Employer employerDetails) {
        Employer employer = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));

        employer.setFirstName(employerDetails.getFirstName());
        employer.setLastName(employerDetails.getLastName());
        employer.setEmailId(employerDetails.getEmailId());

        Employer updatedEmployer = employeeRepository.save(employer);
        return ResponseEntity.ok(updatedEmployer);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employer employer = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));

        employeeRepository.delete(employer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
