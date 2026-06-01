package com.example.schoolmanagmentjpa.Service;

import com.example.schoolmanagmentjpa.API.ApiException;
import com.example.schoolmanagmentjpa.DTO.IN.AddressDTO;
import com.example.schoolmanagmentjpa.DTO.OUT.AddressDTOOUT;
import com.example.schoolmanagmentjpa.Model.Address;
import com.example.schoolmanagmentjpa.Model.Teacher;
import com.example.schoolmanagmentjpa.Repository.AddressRepository;
import com.example.schoolmanagmentjpa.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    //get
    public Address getAddress(Integer id) {
        Address address = addressRepository.findAddressById(id);
        if(address == null){
            throw new ApiException("Address not found");
        }
        return address;
    }

    //add
    public void addAddress(Integer teacherId, AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if(teacher == null){
            throw new ApiException("teacher not found");
        }

        if(teacher.getAddress() != null){
            throw new ApiException("Address already exists for this teacher");
        }

        Address address = new Address();

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        address.setTeacher(teacher);
        teacher.setAddress(address);

        addressRepository.save(address);
    }

    //update
    public void updateAddress(Integer id, AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(id);
        if(address == null){
            throw new ApiException("Address not found");
        }

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());


        addressRepository.save(address);
    }

    //delete
    public void deleteAddress(Integer id) {
        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            throw new ApiException("Address not found");
        }
        Teacher teacher = address.getTeacher();
        //لفك العلاقه بين التيشر والادرس قبل الحذف
        if (teacher != null) {
            teacher.setAddress(null);
            teacherRepository.save(teacher);
        }
        addressRepository.delete(address);
    }


    //    public AddressDTOOUT getAddress(Integer id) {
//        Address address = addressRepository.findAddressById(id);
//        if (address == null) {
//            throw new ApiException("Address not found");
//        }
//        return new AddressDTOOUT(address.getId(), address.getArea(), address.getStreet(), address.getBuildingNumber());
//    }
    //DTO Method
//    public AddressDTOOUT convertToDTO(Address address){
//        return new AddressDTOOUT(address.getId(), address.getArea(), address.getStreet(), address.getBuildingNumber());
//    }
}