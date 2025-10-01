/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.orm.test.mapping.formula.hhhNNN;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;


@Entity
class Person {

	@Id
	private Long id;

	@OneToMany(mappedBy = "author")
	private Set<Book> booksWritten;

	@OneToMany(mappedBy = "translator")
	private Set<Book> booksTranslated;

	public Set<Book> getBooksWritten() {
		return this.booksWritten;
	}

	public void setBooksWritten(Set<Book> booksWritten){
		this.booksWritten = booksWritten;
	}

	public Set<Book> getBooksTranslated() {
		return this.booksTranslated;
	}

	public void setBooksTranslated(Set<Book> booksTranslated){
		this.booksTranslated = booksTranslated;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
