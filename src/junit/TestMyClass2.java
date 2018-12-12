package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMyClass2
{

	
	@Test
	public void test()
	{
		MyClass c = new MyClass();
		assertEquals("this tests the 1plus1 method", 2, c.add1plus1());
		//fail( "Not yet implemented" );
	}

}
