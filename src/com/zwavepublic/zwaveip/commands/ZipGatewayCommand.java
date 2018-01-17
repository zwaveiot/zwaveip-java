package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ZipGateway commands (version 1) */
public enum ZipGatewayCommand implements com.zwavepublic.zwaveip.commands.Command {
    GATEWAY_MODE_SET(0x01),
    GATEWAY_MODE_GET(0x02),
    GATEWAY_MODE_REPORT(0x03),
    GATEWAY_PEER_SET(0x04),
    GATEWAY_PEER_GET(0x05),
    GATEWAY_PEER_REPORT(0x06),
    GATEWAY_LOCK_SET(0x07),
    UNSOLICITED_DESTINATION_SET(0x08),
    UNSOLICITED_DESTINATION_GET(0x09),
    UNSOLICITED_DESTINATION_REPORT(0x0a),
    COMMAND_APPLICATION_NODE_INFO_SET(0x0b),
    COMMAND_APPLICATION_NODE_INFO_GET(0x0c),
    COMMAND_APPLICATION_NODE_INFO_REPORT(0x0d);

    private static final HashMap<Integer, ZipGatewayCommand> _map = new HashMap<Integer, ZipGatewayCommand>(13);
    static {
        for (ZipGatewayCommand value: ZipGatewayCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ZipGatewayCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ZipGatewayCommand valueOf(int intValue) {
        ZipGatewayCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ZipGatewayCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

