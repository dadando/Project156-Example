<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>지도에 컨트롤 올리기</title>
    
</head>
<body>
<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a4b4101d3ccc5856359a1e0f7985cda"></script>
<script>

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.28384892842867, 127.145348888579), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//지도를 클릭했을때 클릭한 위치에 마커를 추가하도록 지도에 클릭이벤트를 등록합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    // 클릭한 위치에 마커를 표시합니다 
    addMarker(mouseEvent.latLng);             
});


//지도에 표시된 마커 객체를 가지고 있을 배열입니다
var markers = [];
//클릭한 마커를 담을 변수
var selectedMarker=null;
// 마커를 생성하고 지도위에 표시하는 함수입니다
function addMarker(position) {
	var SPRITE_MARKER_URL = './resources/images/markericon_red.png';
	var NORMAL_MARKER_URL = './resources/images/markericon_black.png';
    
	// 마커를 생성합니다
    var marker = new kakao.maps.Marker({
    	
    	position: position
    	
    });
    // 마커 객체에 마커아이디와 마커의 기본 이미지를 추가합니다
	//marker.normalImage = NORMAL_MARKER_URL;
    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
    
    // 생성된 마커를 배열에 추가합니다
    markers.push(marker);
    
    //마커에 click 이벤트를 등록합니다
    kakao.maps.event.addListener(marker,'click',function(){
    	 if (!selectedMarker || selectedMarker !== marker) {
    		marker.setMap(null);
    	}
    });
    /*
 	// 마커에 mouseover 이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'mouseover', function() {

        // 클릭된 마커가 없고, mouseover된 마커가 클릭된 마커가 아니면
        // 마커의 이미지를 오버 이미지로 변경합니다
        if (!selectedMarker || selectedMarker !== marker) {
            marker.setImage(SPRITE_MARKER_URL);
        }
    });

    // 마커에 mouseout 이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'mouseout', function() {

        // 클릭된 마커가 없고, mouseout된 마커가 클릭된 마커가 아니면
        // 마커의 이미지를 기본 이미지로 변경합니다
        if (!selectedMarker || selectedMarker !== marker) {
            marker.setImage(NORMAL_MARKER_URL);
        }
    });*/
}



</script>
</body>
</html>
