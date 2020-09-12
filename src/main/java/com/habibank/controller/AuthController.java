// package com.habibank.controller;

// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;
// import java.util.stream.Collectors;
// import javax.validation.Valid;

// import com.habibank.model.Role;
// import com.habibank.model.User;
// import com.habibank.model.Role.ERole;
// import com.habibank.payload.request.LoginRequest;
// import com.habibank.payload.request.SignupRequest;
// import com.habibank.payload.response.JwtResponse;
// import com.habibank.payload.response.MessageResponse;
// import com.habibank.repo.RoleRepository;
// import com.habibank.repo.CustomerRepository;
// import com.habibank.repo.UserRepository;
// import com.habibank.security.jwt.JwtUtils;
// import com.habibank.security.services.UserDetailsImpl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;


// @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
// @RestController
// @RequestMapping("/")
// public class AuthController {
//     /***
//      *  Controller for handling login/logout logic of front end and user validation
//      * */
//     //Security package implementation
//     @Autowired
//     AuthenticationManager authManager;
//     @Autowired
//     RoleRepository roleRepo;
//     @Autowired
//     CustomerRepository custRepo;
//     @Autowired
//     UserRepository userRepo; 
//     @Autowired
//     PasswordEncoder encoder;
//     @Autowired
//     JwtUtils jwtUtils;

//     @GetMapping("/test") 
//     private String index() {
//         return "index of Auth API";
//     }

//     @PostMapping("/")
//     public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//             Authentication auth = authManager.authenticate(
//                     new UsernamePasswordAuthenticationToken(
//                         loginRequest.getUsername(),
//                         loginRequest.getPassword()));
            
//             SecurityContextHolder.getContext().setAuthentication(auth);
//             String jwt = jwtUtils.generateJwtToken(auth);
            
//             UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
//             List<String> roles = userDetails
//             .getAuthorities().stream()
//             .map(item -> item.getAuthority())
//             .collect(Collectors.toList());
            
//             return ResponseEntity.ok(
//                 new JwtResponse(
//                     jwt,
//                     userDetails.getId(),
//                     userDetails.getUsername(),
//                     userDetails.getEmail(),
//                     roles));
//     }
    
//     @PostMapping("/register")
//     public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//             //Check if username exists by email and username in Repository
//             if(userRepo.existsByuserName(signUpRequest.getUsername())) {
//                 return ResponseEntity
//                     .badRequest()
//                     .body(new MessageResponse("Error: Username is already taken!"));
//             }
//             if(userRepo.existsByEmail(signUpRequest.getEmail())) {
//                 return ResponseEntity
//                         .badRequest()
//                         .body(new MessageResponse("Error: Email is already in use!"));
//             }
//             //Create new users account
//             //Get by customer ID in payload (request, response)
//             User user = new User(/* signUpRequest.getUsername(),
//                     signUpRequest.getEmail(), */signUpRequest.getUserId(),
//                     encoder.encode(signUpRequest.getPassword()));//encode/encrypt raw password
// /* 
//             //list of user roles
//             //Set the role for the user (customer or admin) 
//             Set<String> strRoles = signUpRequest.getRole();
//             Set<Role> roles = new HashSet<>();

//             //Check if set of roles is null and not defined
//             if(strRoles == null) {
//                     Role userRole = roleRepo.findByName(ERole.ROLE_CUSTOMER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                     roles.add(userRole);
//                 } else { 
//                         strRoles.forEach(role -> {
//                             switch(role) {
//                             case "admin":
//                                 Role adminRole = roleRepo.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                                 roles.add(adminRole);
//                                 break;
//                             default:
//                                 Role userRole = roleRepo.findByName(ERole.ROLE_CUSTOMER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                                 roles.add(userRole);
//                         }
//                     });
//             }

//             user.setRoles(roles); */
//             userRepo.save(user);
            
//             return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//     }
// }