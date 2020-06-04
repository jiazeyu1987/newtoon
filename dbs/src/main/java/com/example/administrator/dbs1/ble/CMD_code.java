package com.example.administrator.dbs1.ble;

public class CMD_code {
	public static final String BLUE_CONNECT_OK = "BLUE_CONNECT_OK";
	public static final String BLUE_CONNECT_FAIL = "BLUE_CONNECT_FAIL";
	public static final String BLUE_RECEIVE_DATA = "BLUE_RECEIVE_DATA";
	public static final String BLUE_RECEIVE_FAIL = "BLUE_RECEIVE_FAIL";
	public static final String SEND_DATA = "SEND_DATA";

	public static final int REQUEST_SET_PARAMETERS = 8;
	public static final int REQUEST_HEART_RATE =2;
	public static final int CMD_LEFT_STIM_TURN_ON = 0x01;
	public static final int CMD_LEFT_STIM_TURN_OFF = 0x02;
	public static final int CMD_LEFT_SET_PARM_ALL = 0x03;
	public static final int CMD_LEFT_READ_PARM_ALL = 0x04;
//	public static final int CMD_LEFT_STIM_MODE_SETTING = 0x05;
	public static final int CMD_LEFT_IMPED_MEASURE_SINGLE = 0x06;
	public static final int CMD_LEFT_IMPED_MEASURE_ALL = 0x07;
	public static final int CMD_READ_CONTROLLER_PRI = 0x83;
	public static final int CMD_READ_CONTROLLER_MODE = 0x84;
	public static final int CMD_READ_CONTROLLER_LEFT = 0x90;
	public static final int CMD_READ_CONTROLLER_RIGHT = 0x91;
	/**added two command code by Paul on 3/13/2019
	 * CMD_LEFT_IMPED_MEASURE_ALL_CASE
	 * CMD_RIGHT_IMPED_MEASURE_ALL_CASE
	 */
	public static final int MULTI_LEFT_CLOSE = 0;
	public static final int MULTI_LEFT_OPEN = 1;
	public static final int MULTI_RIGHT_CLOSE = 2;
	public static final int MULTI_RIGHT_OPEN = 3;

	public static final int CMD_LEFT_MULTI_MODE_IMPLANT = 0x41;
	public static final int CMD_LEFT_MULTI_Mode = 0x71;
	public static final int CMD_LEFT_MULTI_ON = 0x03;
	public static final int CMD_LEFT_CROSS_ON = 0x1f;
	public static final int CMD_LEFT_MULTI_OFF = 0x00;
	public static final int CMD_RIGHT_MULTI_MODE_IMPLANT = 0x43;
	public static final int CMD_RIGHT_MULTI_Mode = 0x73;
	public static final int CMD_RIGHT_MULTI_ON = 0x0d;
	public static final int CMD_RIGHT_CROSS_ON = 0x20;
	public static final int CMD_RIGHT_MULTI_OFF = 0x00;

	// one here
	public static final int CMD_LEFT_IMPED_MEASURE_ALL_CASE = 0x0D;
	public static final int CMD_LEFT_CMD_SELECT_PROGRAM = 0x08;
	public static final int CMD_LEFT_CMD_SET_PROGRAM = 0x09;
	public static final int CMD_LEFT_CMD_READ_PROGRAM_CONTEXT = 0x0A;
	public static final int CMD_LEFT_CMD_READ_PROGRAM_NO = 0x0B;
	public static final int CMD_LEFT_CMD_SET_PROGRAM_MAG = 0x0C;

	public static final int CMD_RIGHT_STIM_TURN_ON = 0x11;
	public static final int CMD_RIGHT_STIM_TURN_OFF = 0x12;
	public static final int CMD_RIGHT_SET_PARM_ALL = 0x13;
	public static final int CMD_RIGHT_READ_PARM_ALL = 0x14;
//	public static final int CMD_RIGHT_STIM_MODE_SETTING = 0x15;
	public static final int CMD_RIGHT_IMPED_MEASURE_SINGLE = 0x16;
	public static final int CMD_RIGHT_IMPED_MEASURE_ALL = 0x17;
	// another one here
	public static final int CMD_RIGHT_IMPED_MEASURE_ALL_CASE = 0x1D;
	public static final int CMD_RIGHT_CMD_SELECT_PROGRAM = 0x18;
	public static final int CMD_RIGHT_CMD_SET_PROGRAM = 0x19;
	public static final int CMD_RIGHT_CMD_READ_PROGRAM_CONTEXT = 0x1A;
	public static final int CMD_RIGHT_CMD_READ_PROGRAM_NO = 0x1B;
	public static final int CMD_RIGHT_CMD_SET_PROGRAM_MAG = 0x1C;
	public static final int CMD_ID_SET = 0x20;
	public static final int CMD_ID_READ = 0x21;
	public static final int CMD_BATTERY_VOLT_MEASURE = 0x22;
	public static final int CMD_IMPLANT_SET_UPPER = 0x60;
    /*
	public static final int CMD_BATTERY_IMPED_MEASURE = 0x23;
	public static final int CMD_STATIC_CURRENT_MEASURE = 0x24;
	public static final int CMD_RUN_CURRENT_MEASURE = 0x25;
	public static final int CMD_IMPED_MEASURE_ALL = 0x26;
	*/
//	public static final int CMD_READ_IMPLANT_SW_VERSION = 0x27;
//	public static final int CMD_TEST_CMD = 0x28;
	public static final int CMD_WRITE_MEMORY = 0x29;
	public static final int CMD_READ_MEMORY = 0x2A;
	public static final int CMD_RESET_IMPLANT = 0xE0;
	// temporary cmd for test
	public static final int CMD_SET_FREQUENCY = 0x30;

	public static final int CMD_SET_PW_LEFT = 0x31;
	public static final int CMD_SET_PW_RIGHT = 0x32;
	public static final int CMD_SET_VOLTAGE_MAG_LEFT = 0x33;
	public static final int CMD_SET_VOLTAGE_MAG_RIGHT = 0x34;
	public static final int CMD_SET_ELECTRODE_LEFT = 0x35;
	public static final int CMD_SET_ELECTRODE_RIGHT = 0x36;
	public static final int CMD_SET_STIM_MODE_LEFT = 0x37;
	public static final int CMD_SET_STIM_MODE_RIGHT = 0x38;
	public static final int CMD_SET_CURRENT_MAG_LEFT = 0x39;
	public static final int CMD_SET_CURRENT_MAG_RIGHT = 0x3A;
	public static final int CMD_READ_ELECTRODE_LEFT = 0x3B;
	public static final int CMD_READ_ELECTRODE_RIGHT = 0x3C;

	public static final int CMD_READ_STIM_MODE_LEFT = 0x77;
	public static final int CMD_READ_STIM_MODE_RIGHT = 0x78;

	// old CMD code
	public static final int  CMD_SET_STIM_STATUS_ON = 0x10;
	public static final int  CMD_SET_STIM_STATUS_OFF = 0x20;
	public static final int  CMD_SET_MAG  = 0x30;
	public static final int  CMD_SET_PERIOD = 0x40;
	public static final int  CMD_SET_PW = 0x50;
	public static final int  CMD_ELECTRODE_SELECT = 0x60;
	public static final int  CMD_ELECTRODE_READ = 0x35;
	public static final int  CMD_IMPEDANCE_MEASURE = 0x70;
	public static final int  CMD_VOLTAGE_TEST = 0x80;
	public static final int  CMD_BATTERY_MEASURE = 0x90;
	public static final int  CMD_MAG_READ = 0xA0;
	public static final int  CMD_PERIOD_READ = 0xB0;
	public static final int  CMD_PW_READ = 0xC0;
	public static final int  CMD_RESET_PARAMETER = 0xD0;
	public static final int  CMD_SET_ID  = 0xF0;
	public static final int  CMD_EEPROM_READ = 0x11;
	public static final int  CMD_EEPROM_WRITE = 0x12;
	public static final int  CMD_SET_MAGUPPERBOUND = 0x13;
	public static final int  CMD_SET_PERIODLOWERBOUND = 0x14;
	public static final int  CMD_SET_PWUPPERBOUND = 0x15;
//	public static final int  CMD_SET_MAGLOWERBOUND = 0x43;
//	public static final int  CMD_SET_PERIODUPPERBOUND = 0x44;
//	public static final int  CMD_SET_PWLOWERBOUND = 0x45;
	public static final int  CMD_SELECT_PROGRAM = 0x81;
	public static final int  CMD_SET_PROGRAM = 0x82;
	public static final int  CMD_READ_IMPLANT_SW_VERSION = 0x27; //读取植入体软件版本
//	public static final int  CC_CMD_PP_SW_VERSION = 0x40; //读取程控仪软件版本
	public static final int  CMD_READ_MAGUPPERBOUND = 0x13;
	public static final int  CMD_READ_PERIODLOWERBOUND = 0x14;
	public static final int  CMD_READ_PWUPPERBOUND = 0x15;
//	public static final int  CMD_READ_MAGLOWERBOUND = 0x43;
//	public static final int  CMD_READ_PERIODUPPERBOUND = 0x44;
//	public static final int  CMD_READ_PWLOWERBOUND = 0x45;
	public static final int  CMD_SET_STIM_MODE = 0x16;
	public static final int  CMD_READ_STIM_MODE = 0x17;
	public static final int  CMD_SET_ENCRYPTION_ID = 0x18;
	public static final int  CMD_TEST_CMD = 0x19;
	public static final int  CMD_RF_TUNE_TXRX = 0x1A;
	public static final int  CMD_RF_TUNE_MATCH = 0x1B;
	public static final int  CMD_RF_TUNE_245CAP = 0x1C;
	public static final int  CMD_ALLSTIMPARAMTER_READ = 0x34;

	public static final int  USB_CMD_POWER_245G  = 0x20;
	public static final int  USB_CMD_POWER_400M  = 0x22;
	//public static final int  CMD_SET_USER_MODE 0x1D
	public static final int  CMD_SET_IMP_MODE = 0x1D;
	public static final int  CMD_READ_IMP_MODE = 0x2F;
	//01:patient mode, 03, doctor mode, 05: engineer mode.  ONLY same cmd twice can enter the mode.others: patient mode

	public static final int  CMD_STROSCPWIDTH1_102 = 0x1E;
	public static final int  CMD_STROSCPERIOD_102 = 0x1F;

	public static final int  CMD_ImSetRxBlockSize  = 0x22;
	public static final int  CMD_MAC_MODUSER = 0x23;

	public static final int  CMD_TXRFPWRDEFAULTSET = 0x25;

	public static final int  CMD_MICS_CALIBRATION = 0x26;

//	public static final int  CMD_MICS_WRITE = 0x27;
	public static final int  CMD_MICS_READ = 0x28;

	public static final int  CMD_IMSENDEMGERNCY = 0x29;
	public static final int  CMD_IMSTARTTX400CARRIER = 0x2A;

	// added by Paul on 2/20/2019
	public static final int NORMAL_FREQ_MODE = 0x00;
	public static final int HIGHER_FREQ_MODE = 0x01;

    // new cmd for setup the adjustable stim range
	public static final int CMD_SET_VOLTAGE_RANGE_LEFT = 0x52;
    public static final int CMD_SET_CURRENT_RANGE_LEFT = 0x53;
    public static final int CMD_SET_VOLTAGE_RANGE_RIGHT = 0x54;
    public static final int CMD_SET_CURRENT_RANGE_RIGHT = 0x55;

}
