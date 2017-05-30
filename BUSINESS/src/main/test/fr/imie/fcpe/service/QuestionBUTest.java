package fr.imie.fcpe.service;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import fr.imie.fcpe.model.QuestionBO;

public class QuestionBUTest {

	QuestionBU questionBU;
    EntityManager entityManager;
	
	@Before
	public void setUp() throws Exception {
		questionBU = new QuestionBU();
        entityManager = mock(EntityManager.class);
        questionBU.em = entityManager;
	}

	@Test
	public void testFindAll() throws NamingException {
		// stub the entity manager to return a meaningful result when somebody asks
        // for the FIND_ALL named query
        Query query = mock(Query.class);
        when(entityManager.createNamedQuery("QuestionEntity.findAll")).thenReturn(query);
        
        // stub the query returned above to return a meaningful result when somebody
        // asks for the result list
        List<QuestionBO> dummyResult = new ArrayList<>();
        when(query.getResultList()).thenReturn(dummyResult);

        // let's call findAll() and see what it does
        List<QuestionBO> result = questionBU.findAll();

        // did it request the named query?
        verify(entityManager).createNamedQuery("QuestionEntity.findAll");
        // did it ask for the result list of the named query?
        verify(query).getResultList();

        assertSame(dummyResult.size(), result.size());
	}

}
