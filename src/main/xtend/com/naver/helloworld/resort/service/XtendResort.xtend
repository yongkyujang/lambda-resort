package com.naver.helloworld.resort.service

import com.naver.helloworld.resort.repository.GuestRepository

class XtendResort implements ResortService {
	GuestRepository repository
	new (GuestRepository repository) {
		this.repository = repository
	}
	override findGuestNamesByCompany(String company) {
		val all = repository.findAll()
		all.filter [g | g.company == company ]
			.sortBy[g | g.grade]
			.map[g | g.name]
	}
}
