package org.activiti;

import java.util.Collections;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HireProcessRestController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ApplicantRepository applicantRepository;

//    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/start-hire-process", method = RequestMethod.GET)
    public void startHireProcess(@RequestParam String name,@RequestParam String email,@RequestParam String phoneNumber) {

        Applicant applicant = new Applicant(name, email, phoneNumber);
        applicantRepository.save(applicant);

        Map<String, Object> vars = Collections.<String, Object>singletonMap("applicant", applicant);
        runtimeService.startProcessInstanceByKey("hireProcessWithJpa", vars);
    }

}