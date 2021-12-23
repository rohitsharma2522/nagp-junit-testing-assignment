package com.nagarro.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class BrokerageUtilsTest {

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void givenStaticMethodWithNoArgsWhenMockedThenItWillReturn() {
		Assertions.assertEquals(10.0, BrokerageUtils.computeBrokerage(10, 200));
		try (MockedStatic<BrokerageUtils> utilities = Mockito.mockStatic(BrokerageUtils.class)) {
			utilities.when(() -> BrokerageUtils.computeBrokerage(10, 200)).thenReturn(10.0);

			Assertions.assertEquals(10.0, BrokerageUtils.computeBrokerage(10, 200));
		}
		Assertions.assertEquals(10.0, BrokerageUtils.computeBrokerage(10, 200));

	}

}
