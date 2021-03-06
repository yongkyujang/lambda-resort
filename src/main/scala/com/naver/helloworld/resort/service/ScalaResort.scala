package com.naver.helloworld.resort.service

import com.naver.helloworld.resort.repository.GuestRepository
import scala.collection.JavaConversions._

class ScalaResort(repository: GuestRepository) extends ResortService {
	override def findGuestNamesByCompany(company: String): java.util.List[String] = {
		val all = repository.findAll
		all.filter ( g => g.getCompany == company)
			.sortBy ( g => g.getGrade )
			.map ( g => g.getName )
	}
}