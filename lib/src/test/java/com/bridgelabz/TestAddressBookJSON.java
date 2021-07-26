package com.bridgelabz;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestAddressBookJSON {

	@Test
	public void given3ContactsWhenWrittenToJSonFileShouldMatchContactEntries() 
	{
		Contacts jeff=new Contacts("Jeff","Bezoss","jeff@gmail.com","San Francisco","Address","120012","California","+23-1234567890");
		Contacts mark=new Contacts("Mark","Zukerberg","mark@gmail.com","New York City","Address","123456","New York","+12-9874563210");
		Contacts satya=new Contacts("Satya", "Nadela","satya@gmail.com","Los Angeles","Address","120546","California","+11-5463217890");
		List<Contacts> contacts=Arrays.asList(new Contacts[] {jeff, mark, satya});
		AddressBookJSON addressBookJsonIOService=new AddressBookJSON("addressJSonTest.csv");
		addressBookJsonIOService.writeContactDetailsInAFile(contacts);
		List<Contacts> readContacts=addressBookJsonIOService.readAddressBookFromAFile();
		assertEquals(jeff.toString(),readContacts.get(0).toString());
		assertEquals(mark.toString(),readContacts.get(1).toString());
		assertEquals(satya.toString(),readContacts.get(2).toString());
	}

}
