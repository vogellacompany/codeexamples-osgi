package com.vogella.tasks.services.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.vogella.tasks.services.internal.TransientTaskServiceImpl;

class TransientTaskServiceImplTests {

	@Test
	void test() {
		TransientTaskServiceImpl service = new TransientTaskServiceImpl();
		assertNotNull(service);
		assertTrue(service.getAll().size()>0);
	}

}
