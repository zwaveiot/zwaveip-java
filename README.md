# zwaveip-java
A Z-Wave IP implementation for Java. Unofficial library, not supported by Sigma Designs.

This library enables Java applications to communicate with Z-Wave devices via a Z/IP (Z-Wave IP) Gateway.

#### Current status: beta  

#### Too add the library to your project (pre-compiled post-beta on the "releases" page)  
> Add zwaveip.jar as an "external JAR reference" to your project.  
> Add the two supporting BouncyCastle JARs (as "external JAR references") to your project:  
  1. bcprov-jdk15on-159.jar  
  2. bctls-jdk15on-159.jar  

#### To import the library
> import com.zwavepublic.zwaveip.*;  
> import com.zwavepublic.zwaveip.command.*;  

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
> zwaveIPClient.sendMessage(CommandClass.SwitchBinary, SwitchBinaryCommand.Set, new byte[] {0xFF});  
NOTE: sendMessage throws both IOException (for newtwork errors) and ZWaveIPException (for Z-Wave timeouts/NAKs)

#### To request device status from the connected Z-Wave device (example)
> try {
> &nbsp;&nbsp;&nbsp;&nbsp;byte[] response = zwaveIPClient.sendMessageAndWaitForResponse(CommandClass.SwitchBinary, SwitchBinaryCommand.Get, new byte[] {}, SwitchBinaryCommand.Report);  
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

#### To close a Z-Wave device connection
> zwaveIPClient.close();  


#### Documentation on Z-Wave command classes and Z-Wave commands  
###### For full documentation, see: http://zwavepublic.com/downloads  
###### For Java enumerations, see the 'commands' subdirectory within this package
