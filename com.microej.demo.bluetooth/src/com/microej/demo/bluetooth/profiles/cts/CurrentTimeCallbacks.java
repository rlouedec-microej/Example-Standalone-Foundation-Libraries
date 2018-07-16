package com.microej.demo.bluetooth.profiles.cts;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gatt.data.BluetoothCharacteristic;
import ej.bluetooth.gatt.data.BluetoothStatus;
import ej.bluetooth.gatt.server.BluetoothProfile;
import ej.bluetooth.gatt.server.BluetoothProfileCallbacksDefault;

public class CurrentTimeCallbacks extends BluetoothProfileCallbacksDefault {

	@Override
	public void onReadCharacteristicRequest(BluetoothProfile profile, BluetoothDevice device,
			BluetoothCharacteristic characteristic) {
		String charUuid = characteristic.getUuid();
		if (charUuid.equals(CurrentTimeService.CURRENT_TIME_UUID)) {
			profile.sendReadCharacteristicResponse(device, characteristic, BluetoothStatus.OK, makeCurrentTime());
		} else if (charUuid.equals(CurrentTimeService.LOCAL_TIME_INFO_UUID)) {
			profile.sendReadCharacteristicResponse(device, characteristic, BluetoothStatus.OK, makeLocalTimeInfo());
		}
	}

	private static byte[] makeCurrentTime() {
		return new byte[0];
	}

	private static byte[] makeLocalTimeInfo() {
		return new byte[0];
	}
}
