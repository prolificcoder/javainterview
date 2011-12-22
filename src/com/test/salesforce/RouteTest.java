package com.test.salesforce;

import org.junit.Assert;
import org.junit.Test;


public class RouteTest {

	@Test
	public void testMoveRoute() throws Exception {
		City c= new City(2, 2);
		Route r = new Route(c);
		Position p= r.moveRoute("RD", new Position(0,0));
		Assert.assertEquals(p.getI(), 1);
		Assert.assertEquals(p.getJ(), 1);
	}
//	@Test
//	public void testEquals() throws Exception {
//		Position p = new Position(1, 1);
//		Position p1= new Position(1, 1);
//		Assert.assertEquals(p,p1);
//	}
	
	@Test
	public void testNullMove() throws Exception{
		City c= new City(2, 2);
		Route r = new Route(c);
		boolean done=false;
		try{
		r.moveRoute("MD", new Position(0,0));
		}
		catch (Exception e)
		{
			done=true;
		}
		Assert.assertTrue(done);
	}
	
	@Test
	public void testMoveRouteSamePos() throws Exception {
		City c= new City(2, 2);
		Route r = new Route(c);
		Position p= r.moveRoute("RDLU", new Position(0,0));
		Assert.assertEquals(p.getI(), 0);
		Assert.assertEquals(p.getJ(), 0);
	}
	
	@Test
	public void testMoveRouteOutOfBound() throws Exception {
		City c= new City(2, 2);
		Route r = new Route(c);
		boolean done=false;
		try{
			r.moveRoute("DD", new Position(0,0));
			}
			catch (Exception e)
			{
				done=true;
			}
			Assert.assertTrue(done);
	}
	
	@Test
	public void testMoveRouteSame() throws Exception {
		City c= new City(2, 3);
		Route r = new Route(c);
		Position p= r.moveRoute("RM", new Position(0,0));
		Assert.assertEquals(p.getI(), 2);
		Assert.assertEquals(p.getJ(), 0);
	}
	
	@Test
	public void testMoveWholeRoute() throws Exception {
		City c= new City(4, 4);
		Route r = new Route(c);
		Position p= r.moveRoute("RMDMLMUM", new Position(0,0));
		Assert.assertEquals(p.getI(), 0);
		Assert.assertEquals(p.getJ(), 0);
	}
	
	@Test
	public void testMoveWholeRouteDiffStart() throws Exception {
		City c= new City(4, 4);
		Route r = new Route(c);
		Position p= r.moveRoute("LMUMRMDM", new Position(3,3));
		Assert.assertEquals(p.getI(), 3);
		Assert.assertEquals(p.getJ(), 3);
	}

}
