package br.com.galaticos.galacticoScrapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import br.com.galaticos.galacticoScrapper.repository.SystemsRepository;

@Service
public class SearchService {

	@Autowired
	private SystemsRepository repositories;

	@Autowired
	private ApiCallService apiCallService;

	public void getWithCpfFilter(Model model, String select, String cpfCnpj) {
		if ("Caged".equals(select)) {
			model.addAttribute("caged", apiCallService.getToCaged(cpfCnpj));
		} else if ("Censec".equals(select)) {
			model.addAttribute("censec", apiCallService.getToCensec(cpfCnpj));
		}
	}

	public void getWithCnpjFilter(Model model, String select, String cpfCnpj) {
		if ("Jucesp".equals(select)) {
			model.addAttribute("jucesp", apiCallService.getToJucesp(cpfCnpj));
		} else if ("Cadesp".equals(select)) {
			model.addAttribute("cadesp", apiCallService.getToCadesp(cpfCnpj));
		} else if ("Arpenp".equals(select)) {
			model.addAttribute("arpenp", apiCallService.getToArpenp(cpfCnpj));
		} else if ("Caged".equals(select)) {
			model.addAttribute("caged", apiCallService.getToCaged(cpfCnpj));
		} else if ("Censec".equals(select)) {
			model.addAttribute("censec", apiCallService.getToCensec(cpfCnpj));
		} else if ("All".equalsIgnoreCase(select)) {
			model.addAttribute("jucesp", apiCallService.getToJucesp(cpfCnpj));
			model.addAttribute("cadesp", apiCallService.getToCadesp(cpfCnpj));
			model.addAttribute("arpenp", apiCallService.getToArpenp(cpfCnpj));
			model.addAttribute("caged", apiCallService.getToCaged(cpfCnpj));
			model.addAttribute("censec", apiCallService.getToCensec(cpfCnpj));

		}
	}

	public void getAllWithNoFilter(Model model) {
		model.addAttribute("arpenp", repositories.arpenpRepository.findAll());
		model.addAttribute("cadesp", repositories.cadespRepository.findAll());
		model.addAttribute("caged", repositories.cagedRepository.findAll());
		model.addAttribute("censec", repositories.censecRepository.findAll());
		model.addAttribute("jucesp", repositories.jucespRepository.findAll());
		model.addAttribute("siel", repositories.sielRepository.findAll());
		model.addAttribute("sivec", repositories.sivecRepository.findAll());
	}

	public void getAllWithTypeFilter(Model model, String select) {
		if ("Jucesp".equals(select)) {
			model.addAttribute("jucesp", repositories.jucespRepository.findAll());
		} else if ("Cadesp".equals(select)) {
			model.addAttribute("cadesp", repositories.cadespRepository.findAll());
		} else if ("Arpenp".equals(select)) {
			model.addAttribute("arpenp", repositories.arpenpRepository.findAll());
		} else if ("Caged".equals(select)) {
			model.addAttribute("caged", repositories.cagedRepository.findAll());
		} else if ("Censec".equals(select)) {
			model.addAttribute("censec", repositories.censecRepository.findAll());
		}else if("Sivec".equals(select)) {
			model.addAttribute("sivec", repositories.sivecRepository.findAll());
		}else if("Siel".equals(select)) {
			model.addAttribute("siel", repositories.sielRepository.findAll());
		}else if("Arisp".equals(select)) {
			model.addAttribute("arisp","/images/screeShots/Arisp/screenshot2056061056907505241.png");
		}
	}
}
