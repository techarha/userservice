package com.manin.userservice.service;

import com.manin.userservice.model.ContactDetails;
import com.manin.userservice.model.TaxDetails;
import com.manin.userservice.model.User;
import com.manin.userservice.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetAllUsersFromRepo() {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        List<User> users = userService.getAllUsers();
        assertThat(users.size()).isEqualTo(0);
    }

    @Test
    public void testGetUserByIdFromRepo() {
        User user = createUser();
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        Optional<User> optionalUser = userService.getUserById(any());
        assertThat(optionalUser.get().getBusinessName()).isEqualTo("ABS");
    }

    @Test
    public void testSaveUserToRepo() {
        User user = createUser();
        when(userRepository.save(user)).thenReturn(user);
        User savedUser = userService.save(user);
        assertThat(savedUser.getBusinessName()).isEqualTo("ABS");
    }

    private User createUser() {
        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setAddressLane("addressLane");
        contactDetails.setCity("city");
        contactDetails.setEmailId("email");
        contactDetails.setPhoneNumber("1234567890");
        contactDetails.setPinCode("123456");
        contactDetails.setState("state");
        contactDetails.setTown("town");
        TaxDetails taxDetails = new TaxDetails();
        taxDetails.setGstNumber("12324555");
        taxDetails.setPanNumber("121324325435");
        User user = new User();
        user.setBusinessName("ABS");
        user.setOwnerName("owner");
        user.setBusinessContactDetails(contactDetails);
        user.setTaxDetails(taxDetails);
        return user;
    }
}