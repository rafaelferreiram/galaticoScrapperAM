package br.com.galaticos.galacticoScrapper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.galaticos.galacticoScrapper.model.Censec;

public interface CensecRepository extends MongoRepository<Censec, String> {
	
}
