package ma.spring.clinique;

import java.util.Date;

import ma.spring.clinique.security.entities.AppUser;
import ma.spring.clinique.security.repo.AppUserRepository;
import ma.spring.clinique.security.service.AccountServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.spring.clinique.entities.Patient;
import ma.spring.clinique.repository.PatientRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class CliniqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliniqueApplication.class, args);
	}

	 
	
	@Bean
	CommandLineRunner start(PatientRepository patientRepository) {
		
		return args -> {
			/*
			Patient patient1 = Patient.builder()
					.name("Hamza")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient2 = Patient.builder()
					.name("Youssef")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient3 = Patient.builder()
					.name("oussama")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient4 = Patient.builder()
					.name("ayoub")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient5 = Patient.builder()
					.name("alibambo")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient6 = Patient.builder()
					.name("Hamza")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient7 = Patient.builder()
					.name("Youssef")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient8 = Patient.builder()
					.name("oussama")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient9 = Patient.builder()
					.name("ayoub")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient10 = Patient.builder()
					.name("alibamboma")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient11 = Patient.builder()
					.name("Hamza")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient12 = Patient.builder()
					.name("Youssef")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient13 = Patient.builder()
					.name("oussama")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient14 = Patient.builder()
					.name("ayoub")
					.birthDate(new Date())
					.score(100)
					.malade(false)
					.build();
			Patient patient15 = Patient.builder()
					.name("alibaba")
					.birthDate(new Date())
					.score(100)
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
			});*/


		};
	}


	CommandLineRunner start1(JdbcUserDetailsManager jdbcUserDetailsManager){
		PasswordEncoder passwordEncoder= passwordEncoder();
		return args->{

			UserDetails u1 = jdbcUserDetailsManager.loadUserByUsername("user11");
			if (u1==null)
			   jdbcUserDetailsManager.createUser(User
					.withUsername("user11")
					.password(passwordEncoder()
							.encode("1234"))
					.roles("USER")
					.build());
			UserDetails u2 = jdbcUserDetailsManager.loadUserByUsername("user22");
			if (u2==null)
			    jdbcUserDetailsManager.createUser(User
					.withUsername("user22")
					.password(passwordEncoder()
							.encode("1234"))
					.roles("USER")
					.build());
			UserDetails a = jdbcUserDetailsManager.loadUserByUsername("admin2");
			if (a==null)
			    jdbcUserDetailsManager.createUser(User
					.withUsername("admin2")
					.password(passwordEncoder()
							.encode("1234"))
					.roles("USER","ADMIN")
					.build());
		};
	}
	//@Bean
	CommandLineRunner commandLineRunner(AccountServiceImpl accountService){
		return args -> {
			accountService.addNewRole("USER");
			accountService.addNewRole("ADMIN");
			accountService.addNewUser("user1","1234","user1@gmail.com","1234");
			accountService.addNewUser("user2","1234","user3@gmail.com","1234");
			accountService.addNewUser("admin","1234","admin1@gmail.com","1234");

			accountService.addRoleToUser("user1","USER");
			accountService.addRoleToUser("user2","USER");
			accountService.addRoleToUser("admin","USER");
			accountService.addRoleToUser("admin","ADMIN");

		};

	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
