
package Application;

public class InputDataPacket extends DataPacket
{
	private String deviceID;
	
	public void setDeviceID(String ID)
	{
		deviceID = ID;
	}
	
	public String getDeviceID()
	{
		return deviceID;
	}
}