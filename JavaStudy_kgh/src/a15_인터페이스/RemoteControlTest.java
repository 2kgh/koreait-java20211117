package a15_�������̽�;

public class RemoteControlTest {

	public static void main(String[] args) {
		LGRemoteControl lgRemonteControl = new LGRemoteControl();
		
		lgRemonteControl.powerButtonController();
		lgRemonteControl.volumeButtonController(1);
		lgRemonteControl.volumeButtonController(2);
		lgRemonteControl.powerButtonController();
	}

}
