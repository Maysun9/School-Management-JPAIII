package com.example.schoolmanagmentjpa.Controller;

import com.example.schoolmanagmentjpa.API.ApiResponse;
import com.example.schoolmanagmentjpa.DTO.IN.AddressDTO;
import com.example.schoolmanagmentjpa.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAddress(@PathVariable Integer id){
        return ResponseEntity.status(200).body(addressService.getAddress(id));
    }
    @PostMapping("/add/{teacherId}")
    public ResponseEntity<?> addAddress(@PathVariable Integer teacherId, @RequestBody @Valid AddressDTO dto){
        addressService.addAddress(teacherId,dto);
        return ResponseEntity.status(200).body(new ApiResponse("address added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id, @RequestBody @Valid AddressDTO dto){
        addressService.updateAddress(id,dto);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Address updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Address deleted successfully"));
    }
}