package com.reyreey.filimo.Utill.CSVToDTO;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/14/2025, Tuesday
 **/
@Component
public class DataLoader implements CommandLineRunner {

//    @Autowired
//    private IPersonRepository personRepository;
//
//    public void init() {
//        // مسیر فایل CSV
//        String csvFilePath = "src/main/resources/personData.csv";
//
//        // خواندن داده‌ها از فایل CSV
//        List<PersonDTO> personDTOList = GenericCSVToDTO.readCSV(csvFilePath, PersonDTO.class);
//
//        // تبدیل به Entity و ذخیره در دیتابیس
//        if (personDTOList != null) {
//            for (PersonDTO personDTO : personDTOList) {
//                Person person= PersonMapper.mapToEntity(personDTO);
//
//                personRepository.save(person);
//                System.out.println("Person saved: " + person);
//            }
//        }
//    }

    @Override
    public void run(String... args) throws Exception {
//        if (personRepository.findAll().isEmpty()) {
//            init();
//        }
    }
}
