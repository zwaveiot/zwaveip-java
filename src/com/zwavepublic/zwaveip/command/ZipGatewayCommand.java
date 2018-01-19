package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ZipGateway commands (version 1) */
public enum ZipGatewayCommand implements Command {
    GATEWAY_MODE_SET((byte)0x01),
    GATEWAY_MODE_GET((byte)0x02),
    GATEWAY_MODE_REPORT((byte)0x03),
    GATEWAY_PEER_SET((byte)0x04),
    GATEWAY_PEER_GET((byte)0x05),
    GATEWAY_PEER_REPORT((byte)0x06),
    GATEWAY_LOCK_SET((byte)0x07),
    UNSOLICITED_DESTINATION_SET((byte)0x08),
    UNSOLICITED_DESTINATION_GET((byte)0x09),
    UNSOLICITED_DESTINATION_REPORT((byte)0x0a),
    COMMAND_APPLICATION_NODE_INFO_SET((byte)0x0b),
    COMMAND_APPLICATION_NODE_INFO_GET((byte)0x0c),
    COMMAND_APPLICATION_NODE_INFO_REPORT((byte)0x0d);

    private static final HashMap<Byte, ZipGatewayCommand> _map = new HashMap<Byte, ZipGatewayCommand>(13);
    static {
        for (ZipGatewayCommand value: ZipGatewayCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ZipGatewayCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ZipGatewayCommand valueOf(byte byteValue) {
        ZipGatewayCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZipGatewayCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

