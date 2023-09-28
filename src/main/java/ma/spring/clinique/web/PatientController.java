package ma.spring.clinique.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.spring.clinique.entities.Patient;
import ma.spring.clinique.repository.PatientRepository;

@Controller @AllArgsConstructor
public class PatientController {
	PatientRepository patientRepository;
	
	@GetMapping("/index")
	public String index(Model model,
			@RequestParam(name="page",defaultValue ="0") int page,
			@RequestParam(name="size",defaultValue ="4")int size,
			@RequestParam(name="keyword",defaultValue ="")String keyword) {
		Page<Patient> pages = patientRepository.findByNameContains(keyword,PageRequest.of(page, size));
		model.addAttribute("listPatients", pages.getContent());
		model.addAttribute("pages",new int[pages.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("keyword",keyword);
		return "patients";
		
	}
	
	@GetMapping("/delete")
	public String delete(Long id,String keyword,int page) {
		patientRepository.deleteById(id);
		return "redirect:/index?page="+page+"&keyword="+keyword;
		
	}
	@GetMapping("/formPatients")
	public String formPtient(Model model) {	
		model.addAttribute("patient", new Patient());	
		return "formPatients";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@Valid Patient patient, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			return "formPatients";
		}
		patientRepository.save(patient);
		
		return "redirect:index?keyword="+patient.getName();
		
	}
	@GetMapping("/editPatient")
	public String editPatient(Model model, Long id) {	
		Patient patient = patientRepository.findById(id).get();
		model.addAttribute("patient", patient);	
		return "editPatient";
	}
	

}
