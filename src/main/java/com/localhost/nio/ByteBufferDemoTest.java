package com.localhost.nio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ByteBufferDemoTest {
	private String filePath;

	@Before
	public void setUp() throws Exception {
		filePath = "D:/hello2.txt";
	}

	@Test
	public void testReadFile() {
		new ByteBufferDemo().readFile(filePath);
	}

}
