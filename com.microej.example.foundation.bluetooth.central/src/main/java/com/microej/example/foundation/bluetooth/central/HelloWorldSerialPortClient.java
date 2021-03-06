/*
 * Java
 *
 * Copyright 2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.foundation.bluetooth.central;

import ej.bluetooth.BluetoothConnection;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.util.AttributeNotFoundException;
import ej.bluetooth.util.services.sps.SerialPortClient;

public class HelloWorldSerialPortClient extends SerialPortClient {

	private static final byte[] HELLO_WORLD = "Hello world".getBytes();

	public HelloWorldSerialPortClient(BluetoothConnection connection, BluetoothService service)
			throws AttributeNotFoundException {
		super(connection, service);
	}

	public void sendHelloWorld() {
		sendData(HELLO_WORLD);
	}

	@Override
	public void onDataSent(boolean success) {
		System.out.println("Data sent");
	}

	@Override
	public void onDataReceived(byte[] data) {
		System.out.println("Data received: " + new String(data));
	}

}
