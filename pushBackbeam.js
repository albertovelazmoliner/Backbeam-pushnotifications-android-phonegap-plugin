var pushBackbeamPlugin = {
	subscribeDeviceToChannelsBackbeam: function(chanel,successCallback,errorCallback) {
		cordova.exec(
			successCallback, // success callback function
			errorCallback, // error callback function
			'PushBackbeamPlugin', // mapped to our native Java class called "PushBackbeamPlugin"
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
			'PushBackbeamPlugin', // mapped to our native Java class called "PushBackbeamPlugin"
			'unsubscribeDeviceFromChannelsBackbeam', // with this action name
			[{
				"chanel": chanel,
			}]
		); 
	}
}
