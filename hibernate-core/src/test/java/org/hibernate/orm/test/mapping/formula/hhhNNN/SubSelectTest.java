/*
 * SPDX-License-Identifier: LGPL-2.1-or-later
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.orm.test.mapping.formula.hhhNNN;

import org.hibernate.testing.orm.junit.DomainModel;
import org.hibernate.testing.orm.junit.SessionFactory;
import org.hibernate.testing.orm.junit.SessionFactoryScope;
import org.junit.jupiter.api.Test;

@DomainModel(
		annotatedClasses = {
				org.hibernate.orm.test.mapping.formula.hhhNNN.Book.class,
				org.hibernate.orm.test.mapping.formula.hhhNNN.Person.class
		}
)

@SessionFactory
public class SubSelectTest {
	@Test
	void testLoader(SessionFactoryScope scope) {
		scope.inTransaction(session -> {
			Person p = new Person();
			p.setId( 1L );
			session.persist(p);
			Book b = new Book();
			b.setId( 1L );
			b.setAuthor( p );
			session.persist(b);
		});
	}
}
