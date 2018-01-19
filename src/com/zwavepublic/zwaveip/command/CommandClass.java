package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Z-Wave command classes */
public enum CommandClass {
    ANTITHEFT((byte)0x5d),
    APPLICATION_CAPABILITY((byte)0x57),
    APPLICATION_STATUS((byte)0x22),
    ASSOCIATION((byte)0x85),
    ASSOCIATION_COMMAND_CONFIGURATION((byte)0x9b),
    ASSOCIATION_GRP_INFO((byte)0x59),
    AV_CONTENT_DIRECTORY_MD((byte)0x95),
    AV_CONTENT_SEARCH_MD((byte)0x97),
    AV_RENDERER_STATUS((byte)0x96),
    AV_TAGGING_MD((byte)0x99),
    BARRIER_OPERATOR((byte)0x66),
    BASIC((byte)0x20),
    BASIC_TARIFF_INFO((byte)0x36),
    BASIC_WINDOW_COVERING((byte)0x50),
    BATTERY((byte)0x80),
    CENTRAL_SCENE((byte)0x5b),
    CHIMNEY_FAN((byte)0x2a),
    CLIMATE_CONTROL_SCHEDULE((byte)0x46),
    CLOCK((byte)0x81),
    CONFIGURATION((byte)0x70),
    CONTROLLER_REPLICATION((byte)0x21),
    CRC_16_ENCAP((byte)0x56),
    DCP_CONFIG((byte)0x3a),
    DCP_MONITOR((byte)0x3b),
    DEVICE_RESET_LOCALLY((byte)0x5a),
    DMX((byte)0x65),
    DOOR_LOCK((byte)0x62),
    DOOR_LOCK_LOGGING((byte)0x4c),
    ENERGY_PRODUCTION((byte)0x90),
    ENTRY_CONTROL((byte)0x6f),
    FIRMWARE_UPDATE_MD((byte)0x7a),
    GEOGRAPHIC_LOCATION((byte)0x8c),
    GROUPING_NAME((byte)0x7b),
    HAIL((byte)0x82),
    HRV_CONTROL((byte)0x39),
    HRV_STATUS((byte)0x37),
    HUMIDITY_CONTROL_MODE((byte)0x6d),
    HUMIDITY_CONTROL_OPERATING_STATE((byte)0x6e),
    HUMIDITY_CONTROL_SETPOINT((byte)0x64),
    INCLUSION_CONTROLLER((byte)0x74),
    INDICATOR((byte)0x87),
    IP_ASSOCIATION((byte)0x5c),
    IP_CONFIGURATION((byte)0x9a),
    IRRIGATION((byte)0x6b),
    LANGUAGE((byte)0x89),
    LOCK((byte)0x76),
    MAILBOX((byte)0x69),
    MANUFACTURER_PROPRIETARY((byte)0x91),
    MANUFACTURER_SPECIFIC((byte)0x72),
    MARK((byte)0xef),
    METER((byte)0x32),
    METER_PULSE((byte)0x35),
    METER_TBL_CONFIG((byte)0x3c),
    METER_TBL_MONITOR((byte)0x3d),
    METER_TBL_PUSH((byte)0x3e),
    MTP_WINDOW_COVERING((byte)0x51),
    MULTI_CHANNEL((byte)0x60),
    MULTI_CHANNEL_ASSOCIATION((byte)0x8e),
    MULTI_CMD((byte)0x8f),
    NETWORK_MANAGEMENT_BASIC((byte)0x4d),
    NETWORK_MANAGEMENT_INCLUSION((byte)0x34),
    NETWORK_MANAGEMENT_INSTALLATION_MAINTENANCE((byte)0x67),
    NETWORK_MANAGEMENT_PRIMARY((byte)0x54),
    NETWORK_MANAGEMENT_PROXY((byte)0x52),
    NO_OPERATION((byte)0x00),
    NODE_NAMING((byte)0x77),
    NON_INTEROPERABLE((byte)0xf0),
    NOTIFICATION((byte)0x71),
    POWERLEVEL((byte)0x73),
    PREPAYMENT((byte)0x3f),
    PREPAYMENT_ENCAPSULATION((byte)0x41),
    PROPRIETARY((byte)0x88),
    PROTECTION((byte)0x75),
    RATE_TBL_CONFIG((byte)0x48),
    RATE_TBL_MONITOR((byte)0x49),
    REMOTE_ASSOCIATION((byte)0x7d),
    REMOTE_ASSOCIATION_ACTIVATE((byte)0x7c),
    SCENE_ACTIVATION((byte)0x2b),
    SCENE_ACTUATOR_CONF((byte)0x2c),
    SCENE_CONTROLLER_CONF((byte)0x2d),
    SCHEDULE((byte)0x53),
    SCHEDULE_ENTRY_LOCK((byte)0x4e),
    SCREEN_ATTRIBUTES((byte)0x93),
    SCREEN_MD((byte)0x92),
    SECURITY((byte)0x98),
    SECURITY_2((byte)0x9f),
    SECURITY_PANEL_MODE((byte)0x24),
    SECURITY_PANEL_ZONE((byte)0x2e),
    SECURITY_PANEL_ZONE_SENSOR((byte)0x2f),
    SENSOR_ALARM((byte)0x9c),
    SENSOR_BINARY((byte)0x30),
    SENSOR_CONFIGURATION((byte)0x9e),
    SENSOR_MULTILEVEL((byte)0x31),
    SILENCE_ALARM((byte)0x9d),
    SIMPLE_AV_CONTROL((byte)0x94),
    SUPERVISION((byte)0x6c),
    SWITCH_ALL((byte)0x27),
    SWITCH_BINARY((byte)0x25),
    SWITCH_COLOR((byte)0x33),
    SWITCH_MULTILEVEL((byte)0x26),
    SWITCH_TOGGLE_BINARY((byte)0x28),
    SWITCH_TOGGLE_MULTILEVEL((byte)0x29),
    TARIFF_CONFIG((byte)0x4a),
    TARIFF_TBL_MONITOR((byte)0x4b),
    THERMOSTAT_FAN_MODE((byte)0x44),
    THERMOSTAT_FAN_STATE((byte)0x45),
    THERMOSTAT_HEATING((byte)0x38),
    THERMOSTAT_MODE((byte)0x40),
    THERMOSTAT_OPERATING_STATE((byte)0x42),
    THERMOSTAT_SETBACK((byte)0x47),
    THERMOSTAT_SETPOINT((byte)0x43),
    TIME((byte)0x8a),
    TIME_PARAMETERS((byte)0x8b),
    TRANSPORT_SERVICE((byte)0x55),
    USER_CODE((byte)0x63),
    VERSION((byte)0x86),
    WAKE_UP((byte)0x84),
    WINDOW_COVERING((byte)0x6a),
    ZENSOR_NET((byte)0x02),
    ZIP((byte)0x23),
    ZIP_6LOWPAN((byte)0x4f),
    ZIP_GATEWAY((byte)0x5f),
    ZIP_NAMING((byte)0x68),
    ZIP_ND((byte)0x58),
    ZIP_PORTAL((byte)0x61),
    ZWAVEPLUS_INFO((byte)0x5e);

    private static final HashMap<Byte, CommandClass> _map = new HashMap<Byte, CommandClass>();
    static {
        for (CommandClass value: CommandClass.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private CommandClass(byte value) {
        this._byteValue = value;
    }

    public byte byteValue() {
        return this._byteValue;
    }

    public static CommandClass valueOf(byte byteValue) {
        CommandClass result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static CommandClass valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

