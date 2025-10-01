/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.orm.test.mapping.formula.hhhNNN;

import jakarta.persistence.Entity;
import org.hibernate.annotations.Formula;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
class Book {

	@Id
	private Long id;

	@ManyToOne
	protected Person author;

	@ManyToOne
	private Person translator;

	public Person getAuthor() {
		return this.author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public Person getTranslator() {
		return this.translator;
	}

	public void setTranslator(Person translator) {
		this.translator = translator;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Formula("""
			SELECT COUNT(DISTINCT sid)
			FROM (SELECT id as sid FROM book)
			""")
	private Integer booksCounter;

	public Integer getBooksCounter(){
		return this.booksCounter;
	}

}
