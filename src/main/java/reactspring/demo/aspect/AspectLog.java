package reactspring.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactspring.demo.controller.EmployeeController;
import reactspring.demo.model.Employer;

@Aspect
@Component
public class AspectLog {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Before(value = "execution(* reactspring.demo.controller.EmployeeController.*(..)) && args(employer)")
    public void beforeAdvice(JoinPoint joinPoint, Employer employer) {
        System.out.println("Before method:" + joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* reactspring.demo.controller.EmployeeController.getAllEmployees())")
    public void beforeAdviceGetAllEmployees(JoinPoint joinPoint) {
        logger.info("called method getAllEmployees", joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* reactspring.demo.controller.EmployeeController.createEmployee())")
    public void beforeAdviceCreateEmployee(JoinPoint joinPoint) {
        logger.info("called method createEmployee", joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* reactspring.demo.controller.EmployeeController.getEmployerById())")
    public void beforeAdviceGetEmployerById(JoinPoint joinPoint) {
        logger.info("called method getEmployerById by id", joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* reactspring.demo.controller.EmployeeController.updateEmployee())")
    public void beforeAdviceUpdateEmployee(JoinPoint joinPoint) {
        logger.info("called method updateEmployee by id", joinPoint.getSignature().getName());
    }


    @Before(value = "execution(* reactspring.demo.controller.EmployeeController.deleteEmployee())")
    public void beforeAdviceDeleteEmployee(JoinPoint joinPoint) {
        logger.info("called method deleteEmployee by id", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* reactspring.demo.controller.EmployeeController.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After method:" + joinPoint.getSignature());
    }

    @After(value = "execution(* reactspring.demo.controller.EmployeeController.getAllEmployees())")
    public void afterAdviceGetAllEmployees(JoinPoint joinPoint) {
        logger.info("Successfully called method getAllEmployees", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* reactspring.demo.controller.EmployeeController.createEmployee())")
    public void afterAdviceCreateEmployee(JoinPoint joinPoint) {
        logger.info("Successfully  created employee with name", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* reactspring.demo.controller.EmployeeController.getEmployerById())")
    public void afterAdviceGetEmployerById(JoinPoint joinPoint) {
        logger.info("Successfully called method getEmployerById by id", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* reactspring.demo.controller.EmployeeController.updateEmployee())")
    public void afterAdviceUpdateEmployee(JoinPoint joinPoint) {
        logger.info("Successfully updated employee by id", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* reactspring.demo.controller.EmployeeController.deleteEmployee())")
    public void afterAdviceDeleteEmployee(JoinPoint joinPoint) {
        logger.info("Successfully  deleted employee by id", joinPoint.getSignature().getName());
    }
}
