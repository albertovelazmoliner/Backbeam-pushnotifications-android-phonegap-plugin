var pushBackbeamPlugin = {
	subscribeDeviceToChannelsBackbeam: function(chanel,successCallback,errorCallback) {
		cordova.exec(
			successCallback, // success callback function
			errorCallback, // error callback function
			'PushBackbeamPlugin', // mapped to our native Java class called "CalendarPlugin"
			'subscribeDeviceToChannelsBackbeam', // with this action name
			[{
				"chanel": chanel,
			}]
		); 
	},
	unsubscribeDeviceFromChannelsBackbeam: function(chanel,successCallback,errorCallback) {
		cordova.exec(
			successCallback, // success callback function
			errorCallback, // error callback function
			'PushBackbeamPlugin', // mapped to our native Java class called "CalendarPlugin"
			'unsubscribeDeviceFromChannelsBackbeam', // with this action name
			[{
				"chanel": chanel,
			}]
		); 
	}
}