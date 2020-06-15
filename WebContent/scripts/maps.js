(function(){
	const coordinates_Madrid = { lat: 40.416697599669355, lng: -3.703793148377894 }
	const lat_input = element('#lat').value || coordinates_Madrid.lat;
	const lng_input = element('#lng').value || coordinates_Madrid.lng;
	const text = element('#address').value || " ";
	const mapCanvas = element('#map-canvas');
	const geocoder = new google.maps.Geocoder();
	const position = {
		lat : parseFloat(lat_input),
		lng : parseFloat(lng_input)
	}

	let map = new google.maps.Map(mapCanvas, {
		zoom : 18,
		center : position,
	});

	let marker = new google.maps.Marker({
		position : position,
		map : map,
		label : {
			text : text,
			fontSize : '14px',
			fontWeight : '900',
		},
		draggable: true,
		animation: google.maps.Animation.DROP
	});
	
	marker.addListener('dragend', setMarkerPosition);

	function setMarkerPosition(e) {
		let lat = e.latLng.lat();
		let lng = e.latLng.lng();
		element("#lat").value = lat;
		element("#lng").value = lng;
		
		geocodePosition(this.getPosition());
	}

	function geocodePosition(pos) {
	  geocoder.geocode({
	    latLng: pos
	  }, function(responses) {
		 marker.formatted_address = responses && responses.length > 0
		 ? responses[0].formatted_address 
	     : 'Dirección desconocida'
    	 let label = marker.getLabel();
		 label.text = marker.formatted_address;
		 marker.setLabel(label);
	     element('#address').value = marker.formatted_address;
	  });
	}

	function element(selector) {
		return document.querySelector(selector);
	}
})();