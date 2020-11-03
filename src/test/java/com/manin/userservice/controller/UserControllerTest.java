package com.manin.userservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manin.userservice.model.ContactDetails;
import com.manin.userservice.model.TaxDetails;
import com.manin.userservice.model.User;
import com.manin.userservice.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.Optional;

import static com.manin.userservice.controller.UserController.USER_URL;
import static com.manin.userservice.model.ContactDetails.ADDRESS_VALIDATION_MSG;
import static com.manin.userservice.model.ContactDetails.CITY_VALIDATION_MSG;
import static com.manin.userservice.model.ContactDetails.EMAIL_ID_VALIDATION_MSG;
import static com.manin.userservice.model.ContactDetails.PHONE_NUMBER_VALIDATION_MSG;
import static com.manin.userservice.model.ContactDetails.PIN_CODE_VALIDATION_MSG;
import static com.manin.userservice.model.ContactDetails.STATE_VALIDATION_MSG;
import static com.manin.userservice.model.ContactDetails.TOWN_VALIDATION_MSG;
import static com.manin.userservice.model.TaxDetails.GST_NUMBER_VALIDATION_MSG;
import static com.manin.userservice.model.TaxDetails.PAN_NUMBER_VALIDATION_MSG;
import static com.manin.userservice.model.User.BUSINESS_NAME_VALIDATION_MSG;
import static com.manin.userservice.model.User.CONTACT_DETAILS_VALIDATION_MSG;
import static com.manin.userservice.model.User.OWNER_NAME_VALIDATION_MSG;
import static com.manin.userservice.model.User.TAX_DETAILS_VALIDATION_MSG;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void testGetAllUser() throws Exception {
        // when
        when(userService.getAllUsers()).thenReturn(Collections.emptyList());
        // then
        mockMvc.perform(MockMvcRequestBuilders.get(USER_URL)
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void testUserById() throws Exception {
        // when
        when(userService.getUserById(anyString())).thenReturn(Optional.empty());
        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/user/2")
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void testPostUser() throws Exception {
        // given
        User user = createUser();
        user.setBusinessName("ABS");
        // when
        when(userService.save(any())).thenReturn(any());
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void testPostUserWithBlankBusinessName() throws Exception {
        // given
        User user = createUser();
        user.setBusinessName("");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(BUSINESS_NAME_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithBlankOwnerName() throws Exception {
        // given
        User user = createUser();
        user.setOwnerName("");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(OWNER_NAME_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithNullContactDetails() throws Exception {
        // given
        User user = createUser();
        user.setBusinessContactDetails(null);
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(CONTACT_DETAILS_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithNullTaxDetails() throws Exception {
        // given
        User user = createUser();
        user.setTaxDetails(null);
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(TAX_DETAILS_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithBlankAddressInContactDetails() throws Exception {
        // given
        User user = createUser();
        user.getBusinessContactDetails().setAddressLane("");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(ADDRESS_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithBlankTownInContactDetails() throws Exception {
        // given
        User user = createUser();
        user.getBusinessContactDetails().setTown("");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(TOWN_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithBlankCityInContactDetails() throws Exception {
        // given
        User user = createUser();
        user.getBusinessContactDetails().setCity("");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(CITY_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithBlankStateInContactDetails() throws Exception {
        // given
        User user = createUser();
        user.getBusinessContactDetails().setState("");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(STATE_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithBlankPinCodeInContactDetails() throws Exception {
        // given
        User user = createUser();
        user.getBusinessContactDetails().setPinCode("");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(PIN_CODE_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithPinCodeLengthHigherThanReq() throws Exception {
        // given
        User user = createUser();
        user.getBusinessContactDetails().setPinCode("1234567");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(PIN_CODE_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithPinCodeLengthLowerThanReq() throws Exception {
        // given
        User user = createUser();
        user.getBusinessContactDetails().setPinCode("12345  ");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(PIN_CODE_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithBlankEmailInContactDetails() throws Exception {
        // given
        User user = createUser();
        user.getBusinessContactDetails().setEmailId("");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(EMAIL_ID_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithBlankPhoneNumber() throws Exception {
        // given
        User user = createUser();
        user.getBusinessContactDetails().setPhoneNumber("");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(PHONE_NUMBER_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithPhoneLengthHigherThanReq() throws Exception {
        // given
        User user = createUser();
        user.getBusinessContactDetails().setPhoneNumber("12345678901");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(PHONE_NUMBER_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithBlankPhoneLengthLowerThanReq() throws Exception {
        // given
        User user = createUser();
        user.getBusinessContactDetails().setPhoneNumber("123456789");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(PHONE_NUMBER_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithBlankGstNumberInTaxDetails() throws Exception {
        // given
        User user = createUser();
        user.getTaxDetails().setGstNumber("");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(GST_NUMBER_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithBlankPanNumberInTaxDetails() throws Exception {
        // given
        User user = createUser();
        user.getTaxDetails().setPanNumber("");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(PAN_NUMBER_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithGstNumberLengthLowerThanReq() throws Exception {
        // given
        User user = createUser();
        user.getTaxDetails().setGstNumber("12345678910121");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(GST_NUMBER_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithGstNumberLengthHigherThanReq() throws Exception {
        // given
        User user = createUser();
        user.getTaxDetails().setGstNumber("12345678910121123");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(GST_NUMBER_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithPANNumberLengthLowerThanReq() throws Exception {
        // given
        User user = createUser();
        user.getTaxDetails().setPanNumber("123456789");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(PAN_NUMBER_VALIDATION_MSG)));
    }

    @Test
    public void testPostUserWithPanNumberLengthHigherThanReq() throws Exception {
        // given
        User user = createUser();
        user.getTaxDetails().setPanNumber("12345678910");
        //then
        mockMvc.perform(MockMvcRequestBuilders.post(USER_URL)
                .content(mapper.writeValueAsString(user))
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message",
                        Matchers.is(PAN_NUMBER_VALIDATION_MSG)));
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
        taxDetails.setGstNumber("232456789101213");
        taxDetails.setPanNumber("1234567890");
        User user = new User();
        user.setBusinessName("ABS");
        user.setOwnerName("owner");
        user.setBusinessContactDetails(contactDetails);
        user.setTaxDetails(taxDetails);
        return user;
    }
}