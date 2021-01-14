package main;

import java.awt.FontFormatException;
import java.io.IOException;

import frame.TestFrame;

public class Main {
	public Main() throws FontFormatException, IOException {
		new TestFrame();
	}
	public static void main(String[] args) throws FontFormatException, IOException {
		new Main();
	}
}
