package com.react_spring_boot.User;

import com.react_spring_boot.Exception.ResourceNotFoundException;
import com.react_spring_boot.Organization.Organization;
import com.react_spring_boot.Role.Role;
import com.react_spring_boot.Role.RoleRepository;
import com.react_spring_boot.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private final UserService userService;

    private RoleRepository roleRepository;

    /** READ or LIST*/
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /** READ / Find By ID */
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id));
        return ResponseEntity.ok().body(user);
    }

    /** CREATE / SAVE  */
    // @RequestBody Uses http message convertors to convert json message into java object
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /** UPDATE */
    // @PathVariable is used in Binding url value to method parameter value
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer id,
                                           @RequestBody User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id));

        user.setUsername(userDetails.getUsername());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        user.setPhoneNo(userDetails.getPhoneNo());
        user.setGender(userDetails.getGender());

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    /** DELETE */
    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser1(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    /** Finding User's Organization */
    @GetMapping("/user/{id}/organization")
    public Organization getUsersOrganization(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        return user.get().getOrganization();
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));

    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles(){
        return ResponseEntity.ok().body(userService.getRoles());

    }

    /** READ / Find By ID */
    @GetMapping("/role/{roleId}")
    public ResponseEntity<Role> getRoleById(@PathVariable(value = "roleId") Integer roleId)
            throws ResourceNotFoundException {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + roleId));
        return ResponseEntity.ok().body(role);
    }

    /** DELETE */
    @DeleteMapping("/role/delete/{roleId}")
    public Map<String, Boolean> deleteRole(@PathVariable(value = "roleId") Integer roleId)
            throws ResourceNotFoundException {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + roleId));

        roleRepository.delete(role);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /** UPDATE */
//     @PathVariable is used in Binding url value to method parameter value
    @PutMapping("/role/update/{roleId}")
    public ResponseEntity<Role> updateUser(@PathVariable(value = "roleId") Integer roleId,
                                           @RequestBody Role roleDetails) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + roleId));

        role.setRoleName(roleDetails.getRoleName());

        Role updatedRole = userService.saveRole(role);
        return ResponseEntity.ok(updatedRole);
    }
}

