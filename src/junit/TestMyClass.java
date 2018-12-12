package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestMyClass
{

	@Test
	public void test()
	{
		MyClass c = new MyClass();	
		assertEquals(2,c.add1plus1());
	}

}
