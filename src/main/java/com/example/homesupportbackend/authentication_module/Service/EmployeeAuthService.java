package com.example.homesupportbackend.authentication_module.Service;

import com.example.homesupportbackend.authentication_module.dto.EmployeeLogInRequestDTO;
import com.example.homesupportbackend.authentication_module.dto.EmployeeLoginResponseDTO;
import com.example.homesupportbackend.authentication_module.dto.EmployeeSignUpRequestDTO;
import com.example.homesupportbackend.authentication_module.dto.EmployeeSignUpResponseDTO;
import com.example.homesupportbackend.authentication_module.entity.auth_identity;
import com.example.homesupportbackend.authentication_module.entity.employee;
import com.example.homesupportbackend.authentication_module.repository.AuthIdentityRepositroy;
import com.example.homesupportbackend.authentication_module.repository.EmployeeRepository;
import com.example.homesupportbackend.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeAuthService {
    private final AuthIdentityRepositroy authRepositroy;
    private final EmployeeRepository employeeRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public EmployeeAuthService(AuthIdentityRepositroy signUpRepositroy, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, EmployeeRepository employeeRepository){
        this.jwtUtil=jwtUtil;
        this.passwordEncoder=passwordEncoder;
        this.authRepositroy=signUpRepositroy;
        this.employeeRepository=employeeRepository;

    }

    private String codeGenerator(String role){
        String code="";
        if(role.equals("Warden")){
            code="WA";
        }
        if(role.equals("Rector")){
            code="RE";
        }
        if(role.equals("Chief Rector")){
            code="CRE";
        }
        return code;
    }
    private String userIdGenerator(String role){
        Long sequence = employeeRepository.getNextEmployeeSequence();
        String formattedSequence = String.format("%03d", sequence);
        String role_code=codeGenerator(role);
        return "EMP"+role_code+formattedSequence;
    }
    private String passwordGenerator(String role){
        int randomNumber = new java.util.Random().nextInt(90000) + 10000;
        return role + randomNumber;

    }

    @Transactional
    public EmployeeSignUpResponseDTO registerEmployee(EmployeeSignUpRequestDTO employeeSignUpRequestDTO) {
//        if (signUpRepositroy.existsByEmail(employeeSignUpRequestDTO.getEmail())) {
//            throw new RuntimeException("Email Already Registered");
//        }
//        if (signUpRepositroy.existsByPhone(employeeSignUpRequestDTO.getPhone_number())) {
//            throw new RuntimeException("Phone Number already registered");
//        }

        auth_identity auth = new auth_identity();
        employee emp=new employee();


        String password=passwordGenerator(employeeSignUpRequestDTO.getRole());
        String hashedPassword = passwordEncoder.encode(password);
        String user_id = userIdGenerator(employeeSignUpRequestDTO.getRole());
        auth.setAcc_type(employeeSignUpRequestDTO.getAccount_type());
        auth.setEmail_id(employeeSignUpRequestDTO.getEmail());
        auth.setPhone(employeeSignUpRequestDTO.getPhone_number());
        auth.setRole(employeeSignUpRequestDTO.getRole());
        auth.setUser_id(user_id);
        auth.setPassword(hashedPassword);
        auth.setVerified(true);

        auth_identity saveauth=authRepositroy.save(auth);

        emp.setAadhaar(employeeSignUpRequestDTO.getAadhaar_number());
        emp.setActype(employeeSignUpRequestDTO.getAccount_type());
        emp.setAddress(employeeSignUpRequestDTO.getAddress());
        emp.setEmail(employeeSignUpRequestDTO.getEmail());
        emp.setEmp_name(employeeSignUpRequestDTO.getName());
        //emp.setEmp_id(user_id);
        emp.setAuthIdentity(saveauth);
        emp.setPassword(hashedPassword);
        emp.setPhone(employeeSignUpRequestDTO.getPhone_number());
        emp.setRole(employeeSignUpRequestDTO.getRole());
        emp.setVerify("true");

        System.out.println("Generated ID: " + user_id);
        System.out.println("Saved auth ID: " + saveauth.getUser_id());
        System.out.println("Employee ID: " + emp.getEmp_id());
        System.out.println("Employee Auth ID: " +
                emp.getAuthIdentity().getUser_id());

        employee saveEmployee=employeeRepository.save(emp);

        EmployeeSignUpResponseDTO response=new EmployeeSignUpResponseDTO();
        response.setEmp_id(saveauth.getUser_id());
        response.setPassword(password);
        response.setMessage("Employee Added Successfully");
        return response;


    }


    public EmployeeLoginResponseDTO loginEmployee(EmployeeLogInRequestDTO loginRequest){
        Optional<auth_identity> auth = authRepositroy.findById(loginRequest.getEmp_id());

        if(auth.isEmpty()){
            throw new RuntimeException("Employee not found.Contact to Admin.");
        }
        auth_identity existingemp = auth.get();


        if(!passwordEncoder.matches(
                loginRequest.getPassword(),
                existingemp.getPassword()
        )){
            throw new RuntimeException("Incorrect Password");
        }
        employee existing=employeeRepository.findById(loginRequest.getEmp_id()).orElseThrow(
                ()->new RuntimeException("Technical issue. Contact to Admin"));
        String token= jwtUtil.generateToken(existingemp.getUser_id());
        String role=existingemp.getRole();
        String name=existing.getEmp_name();
        return new EmployeeLoginResponseDTO(token,role,name);
    }
}
