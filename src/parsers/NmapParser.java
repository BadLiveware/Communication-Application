package parsers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import Application.Device;
import Util.Logger;

public class NmapParser implements DeviceParser {
	private Logger log = Util.Logger.getInstance();
	private String nameForLog = this.getClass().getSimpleName();
	
	String relLine = "Nmap scan report for ";

	/**
	 * Parses a string from Nmap into Device
	 * 
	 * @param s
	 * The string to be parsed
	 * @return a Device with the given IP
	 * @throws IllegalArgumentException
	 * if the given string cannot be parsed
	 */
	@Override
	public Device parse(String s) throws UnknownHostException, IllegalArgumentException {
		log.debug("Trying to parse "+s+ " into Device", nameForLog);
		if(!s.contains(relLine))
			throw new IllegalArgumentException("The given string\""+ s + "\" cannot be parsed into a valid device" );
		
		InetAddress ip = InetAddress.getByName(s.replace(relLine, ""));
		Device d = new Device(ip);
		return d;
	}

	@Override
	public Device parse(String deviceID, String s) throws UnknownHostException, IllegalArgumentException {
		log.debug("Trying to parse "+s+ " into Device with deviceID: "+ deviceID, nameForLog);
		if(!s.contains(relLine))
			throw new IllegalArgumentException("The given string\""+ s + "\" cannot be parsed into a valid device" );
		
		InetAddress ip = InetAddress.getByName(s.replace(relLine, ""));
		Device d = new Device(ip,deviceID);
		return d;
	}

}
