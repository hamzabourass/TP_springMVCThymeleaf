package ma.spring.clinique;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.spring.clinique.entities.Patient;
import ma.spring.clinique.repository.PatientRepository;

@SpringBootApplication
public class CliniqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliniqueApplication.class, args);
	}
	@Bean
	CommandLineRunner start(PatientRepository patientRepository) {
		
		return args -> {
			Patient patient1 = Patient.builder()
					.name("Hamza")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient2 = Patient.builder()
					.name("Youssef")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient3 = Patient.builder()
					.name("oussama")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient4 = Patient.builder()
					.name("ayoub")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient5 = Patient.builder()
					.name("ali")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient6 = Patient.builder()
					.name("Hamza")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient7 = Patient.builder()
					.name("Youssef")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient8 = Patient.builder()
					.name("oussama")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient9 = Patient.builder()
					.name("ayoub")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient10 = Patient.builder()
					.name("ali")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient11 = Patient.builder()
					.name("Hamza")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient12 = Patient.builder()
					.name("Youssef")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient13 = Patient.builder()
					.name("oussama")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient14 = Patient.builder()
					.name("ayoub")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			Patient patient15 = Patient.builder()
					.name("ali")
					.birthDate(new Date())
					.score(10)
					.malade(false)
					.build();
			patientRepository.save(patient1);
			patientRepository.save(patient2);
			patientRepository.save(patient3);
			patientRepository.save(patient4);
			patientRepository.save(patient5);
			patientRepository.save(patient6);
			patientRepository.save(patient7);
			patientRepository.save(patient8);
			patientRepository.save(patient9);
			patientRepository.save(patient10);
			patientRepository.save(patient11);
			patientRepository.save(patient12);
			patientRepository.save(patient13);
			patientRepository.save(patient14);
			patientRepository.save(patient15);
			

			patientRepository.findAll().forEach(p ->{
				System.out.println(p.toString());
			});

			
		};
	}

}
