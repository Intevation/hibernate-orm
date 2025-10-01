/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.orm.test.mapping.formula.hhhNNN;

import org.hibernate.testing.orm.junit.DomainModel;
import org.hibernate.testing.orm.junit.SessionFactory;
import org.hibernate.testing.orm.junit.SessionFactoryScope;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@DomainModel(
		annotatedClasses = {
				org.hibernate.orm.test.mapping.formula.hhhNNN.Book.class,
				org.hibernate.orm.test.mapping.formula.hhhNNN.Person.class
		}
)

@SessionFactory
public class SubSelectTest {

	@BeforeEach
	void setUp(SessionFactoryScope scope) {
		scope.inTransaction( session -> {
			Person p = new Person();
			p.setId( 1L );
			session.persist(p);
			Book b1 = new Book();
			b1.setId( 1L );
			session.persist( b1 );
			Book b2 = new Book();
			b2.setId( 2L );
			b2.setAuthor( p );
			session.persist(b2);
		} );
	}

	@Test
	void testLoader(SessionFactoryScope scope) {
		scope.inTransaction(session -> {
			Book b = session.find( Book.class, 1L );
			Assert.assertEquals(new Integer(2), b.getBooksCounter());
		});
	}
}
