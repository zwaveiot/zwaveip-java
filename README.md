# zwaveip-java
A Z-Wave IP implementation for Java. Unofficial library, not supported by Sigma Designs.

This library enables Java applications to communicate with Z-Wave devices via a Z/IP (Z-Wave IP) Gateway.

#### Current status: beta  

#### To add the library to your project (from the "releases" page)  
1. Add zwaveip.jar as an "external JAR" to your project.  
2. Add the two supporting BouncyCastle JARs (as "external JARs") to your project: 
   * bcprov-jdk15on-159.jar  
   * bctls-jdk15on-159.jar  

#### To import the library
> import com.zwavepublic.zwaveip.\*;  
> import com.zwavepublic.zwaveip.command.\*;  

#### To convert the Z-Wave network's PSK (Pre-Shared Key) password from a hex string to the required binary representation
> private static byte[] convertHexStringToBinaryPsk(String hexString) {  
> &nbsp;&nbsp;&nbsp;&nbsp;byte[] result = new byte[hexString.length() / 2];  
>  
> &nbsp;&nbsp;&nbsp;&nbsp;for (int i = 0; i < hexString.length(); i += 2) {  
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;result[i / 2] = (byte)Integer.parseInt(hexString.substring(i, i + 2), 16);  
> &nbsp;&nbsp;&nbsp;&nbsp;}  
>  
> &nbsp;&nbsp;&nbsp;&nbsp;return result;  
> }  

#### To connect to a Z-Wave device
> // replace this address with your Z/IP device's IPv4 or IPv6 address  
> InetAddress address = InetAddress.getByName("192.168.0.50");  
>  
> // default pskIdentity and sample password  
> String pskIdentity = "Client_identity";  
> byte[] pskPassword = convertHexStringToBinaryPsk("123456789012345678901234567890aa");  
>  
> ZWaveIPClient zwaveIPClient = new ZWaveIPClient(address, pskIdentity, pskPassword);  

#### To send a message to the connected Z-Wave device (example) and wait for an acknowledgement
> zwaveIPClient.sendMessage(CommandClass.SWITCH_BINARY, SwitchBinaryCommand.SET, new byte[] {0xFF});  
/\* NOTE: sendMessage throws both IOException (for network errors) and ZWaveIPException (for Z-Wave timeouts/NAKs) \*/

#### To request device status from the connected Z-Wave device (example)
> try {  
> &nbsp;&nbsp;&nbsp;&nbsp;byte[] response = zwaveIPClient.sendMessageAndWaitForResponse(CommandClass.SWITCH_BINARY, SwitchBinaryCommand.GET, new byte[] {}, SwitchBinaryCommand.REPORT);  
> &nbsp;&nbsp;&nbsp;&nbsp;byte powerStateAsByte = response.data[0];  
> &nbsp;&nbsp;&nbsp;&nbsp;boolean powerStateAsBoolean = (powerStateAsByte != 0);  
> &nbsp;&nbsp;&nbsp;&nbsp;System.out.println("powerState: " + powerStateAsBoolean + " (" + powerStateAsByte + ")");  
> } catch (IOException ex) {  
> &nbsp;&nbsp;&nbsp;&nbsp;System.out.println("IOException (network error): " + ex.toString());  
> } catch (AckTimeoutException ex) {  
> &nbsp;&nbsp;&nbsp;&nbsp;System.out.println("Timeout (no ACK)");  
> } catch (ResponseTimeoutException ex) {  
> &nbsp;&nbsp;&nbsp;&nbsp;System.out.println("Timeout (no response)");  
> } catch (NakException ex) {  
> &nbsp;&nbsp;&nbsp;&nbsp;System.out.println("NAK");  
> }  

#### To disconnect from a Z-Wave device  
> zwaveIPClient.close();  


#### Documentation on Z-Wave command classes and Z-Wave commands  
###### For full documentation, see: http://zwavepublic.com/downloads  
###### For Java enumerations, see the 'command' subdirectory within this package
